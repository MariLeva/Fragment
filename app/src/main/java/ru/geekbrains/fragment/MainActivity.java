package ru.geekbrains.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_notes, new Notes()).commit();
        }

        setSupportActionBar(findViewById(R.id.toolBar));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.toolbar_about:
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    getSupportFragmentManager().beginTransaction().addToBackStack("").add(R.id.fragment_note_description, new AboutFragment()).commit();
                } else
                    getSupportFragmentManager().beginTransaction().addToBackStack("").add(R.id.fragment_notes, new AboutFragment()).commit();
                return true;
            case R.id.toolbar_exit:
                new DialogFragment().show(getSupportFragmentManager(),DialogFragment.TAG);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}