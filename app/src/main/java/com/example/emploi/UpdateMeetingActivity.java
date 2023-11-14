package com.example.emploi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateMeetingActivity extends AppCompatActivity {

    EditText title_input, link_input, date_input, salle_input, duree_input;
    Button update_button, delete_button;
    MyDatabaseHelper myDB;

    String id; // Make id an instance variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_meeting);

        myDB = new MyDatabaseHelper(this);

        title_input = findViewById(R.id.title_input2);
        link_input = findViewById(R.id.link_input2);
        date_input = findViewById(R.id.date_input2);
        salle_input = findViewById(R.id.salle_input2);
        duree_input = findViewById(R.id.duree_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title_input.getText().toString());
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the save cours button click
                updateMeeting();
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });
    }

    private void getAndSetIntentData() {
        Intent intent = getIntent();
        if (intent.hasExtra("meet_id")
                && intent.hasExtra("meet_title")
                && intent.hasExtra("meet_link")
                && intent.hasExtra("meet_date")
                && intent.hasExtra("meet_salle")
                && intent.hasExtra("meet_duree")) {
            id = intent.getStringExtra("meet_id");
            String title = intent.getStringExtra("meet_title");
            String link = intent.getStringExtra("meet_link");
            String date = intent.getStringExtra("meet_date");
            String salle = intent.getStringExtra("meet_salle");
            String duree = intent.getStringExtra("meet_duree");

            title_input.setText(title);
            link_input.setText(link);
            date_input.setText(date);
            salle_input.setText(salle);
            duree_input.setText(duree);
        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }

    }


    private void updateMeeting() {
        String updatedTitle = title_input.getText().toString();
        String updatedLink = link_input.getText().toString();
        String updatedDate = date_input.getText().toString();
        String updatedSalle = salle_input.getText().toString();
        int updatedDuree = Integer.parseInt(duree_input.getText().toString());

        // Update the meeting in the database
        myDB.updateMeet(Integer.parseInt(getIntent().getStringExtra("meet_id")),
                updatedTitle, updatedLink, updatedDate, updatedSalle, updatedDuree);

        // Close the activity
        finish();
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + title_input.getText().toString() + " ?");
        builder.setMessage("Are you sure you want to delete " + title_input.getText().toString() + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateMeetingActivity.this);
                myDB.deleteMeet(Integer.parseInt(id));
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}