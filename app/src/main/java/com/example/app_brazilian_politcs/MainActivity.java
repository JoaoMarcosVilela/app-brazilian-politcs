package com.example.app_brazilian_politcs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.example.app_brazilian_politcs.database.Database;

public class MainActivity extends AppCompatActivity {
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(), Database.class, "EducaPol").build();

    }
}