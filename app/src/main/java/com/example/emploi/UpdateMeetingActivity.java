package com.example.emploi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateMeetingActivity extends AppCompatActivity {

    EditText title_input, link_input, date_input, salle_input, duree_input;
    Button update_button;
    MyDatabaseHelper myDB;

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

        getAndSetIntentData();

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the save cours button click
                updateMeeting();
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
            String id = intent.getStringExtra("meet_id");
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
}