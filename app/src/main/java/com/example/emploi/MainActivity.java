package com.example.emploi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.emploi.Adapter.MeetingAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.example.emploi.entities.Meeting;

import java.util.List;
import com.example.emploi.MeetingActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.menu_emploi) {
            // Launch the MeetingActivity or perform the desired action
            Intent meetingIntent = new Intent(MainActivity.this, MeetingActivity.class);
            startActivity(meetingIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}