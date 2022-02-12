package ru.geekbrains.fragment;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Notes extends Fragment {
    private static final String NOTES = "Notes";
    private int notesIndex = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            notesIndex = savedInstanceState.getInt(NOTES, 0);
        }
        initNotes(view);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            showLandDescription(notesIndex);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(NOTES, notesIndex);
        super.onSaveInstanceState(outState);
    }

    private void initNotes(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        String[] notes = getResources().getStringArray(R.array.notes);
        for (int i = 0; i < notes.length; i++) {
            String note = notes[i];
            TextView tv = new TextView(getContext());
            tv.setText(note);
            linearLayout.addView(tv);
            final int position = i;
            tv.setOnClickListener(view1 -> {
                notesIndex = position;
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                    showLandDescription(position);
                } else
                    showPortDescription(position);
            });
        }
    }

    private void showPortDescription(int index){
        Note_description note_description = Note_description.newInstance(index);
        requireActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment_notes, note_description).addToBackStack("").commit();
    }

    private void showLandDescription(int index){
        Note_description note_description = Note_description.newInstance(index);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_note_description, note_description).commit();
    }
}