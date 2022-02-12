package ru.geekbrains.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Notes notes = new Notes();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_notes, notes).commit();
    }
}