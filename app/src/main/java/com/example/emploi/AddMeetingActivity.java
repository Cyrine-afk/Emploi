package com.example.emploi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.emploi.entities.Meeting;

public class AddMeetingActivity extends AppCompatActivity {

    EditText title_input, link_input, date_input, salle_input, duree_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);

        title_input = findViewById(R.id.title_input);
        link_input = findViewById(R.id.link_input);
        date_input = findViewById(R.id.date_input);
        salle_input = findViewById(R.id.salle_input);
        duree_input = findViewById(R.id.duree_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the save cours button click
                saveMeeting();
            }
        });

    }


    private void saveMeeting() {
        // Retrieve data from UI components
        String meet_title = title_input.getText().toString();
        int meet_duree = Integer.parseInt(duree_input.getText().toString());
        String meet_link = link_input.getText().toString();
        String meet_date = date_input.getText().toString();
        String meet_salle = salle_input.getText().toString();


        // Validate if coursName is not empty
        if (meet_title.isEmpty()) {
            Toast.makeText(this, "Please enter a title to your meeting", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a Meeting object
        Meeting meeting = new Meeting();
        meeting.setMeetTitle(meet_title);
        meeting.setMeetDuree(meet_duree);
        meeting.setMeetLink(meet_link);
        meeting.setMeetDate(meet_date);
        meeting.setMeetSalle(meet_salle);


        // Save the meeting to the database using AppDatabase
        MyDatabaseHelper.getInstance(this).addMeet(meeting);

        // Show a success message
        Toast.makeText(this, "Meeting saved successfully", Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);

        // Finish the activity or navigate back to the previous screen
        finish();
    }
}