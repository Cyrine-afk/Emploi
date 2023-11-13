package com.example.emploi;

import androidx.appcompat.app.AppCompatActivity;
import com.example.emploi.Adapters.MenuAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sample menu items
        String[] menuItems = getResources().getStringArray(R.array.menu_items);

        // Set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerViewMenu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MenuAdapter menuAdapter = new MenuAdapter(this, menuItems);
        recyclerView.setAdapter(menuAdapter);

        // Set item click listener
        menuAdapter.setOnMenuItemClickListener(new MenuAdapter.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(int position) {
                // Handle item click here
                switch (position) {
                    case 0:
                        // Navigate to MeetingActivity
                        startActivity(new Intent(MainActivity.this, MeetingActivity.class));
                        break;
                    /*case 1:
                        // Navigate to EtudiantActivity
                        startActivity(new Intent(MainActivity.this, EtudiantActivity.class));
                        break;*/

                    default:
                        break;
                }
            }
        });
    }
}