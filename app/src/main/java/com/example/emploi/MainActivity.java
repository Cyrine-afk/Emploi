package com.example.emploi;

import androidx.appcompat.app.AppCompatActivity;

import com.example.emploi.Adapter.MeetingAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.emploi.entities.Meeting;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton add_button;

    MyDatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_meeting_Button);

        // Set up the database helper
        myDB = new MyDatabaseHelper(MainActivity.this);

        // Set up RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Fetch the list of meetings from the database
        List<Meeting> meetingsList = myDB.getAllMeetings();

        // Set up the adapter
        MeetingAdapter meetingAdapter = new MeetingAdapter(this, meetingsList);
        recyclerView.setAdapter(meetingAdapter);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddMeetingActivity.class);
                startActivity(intent);
            }
        });
    }
}