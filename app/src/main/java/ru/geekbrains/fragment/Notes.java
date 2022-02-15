package ru.geekbrains.fragment;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Notes extends Fragment {
    private static final String NOTES = "Notes";
    private NoteMain noteMain = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            noteMain = (NoteMain) savedInstanceState.getParcelable(NOTES);
        }
        initNotes(view);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            showLandDescription(noteMain);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(NOTES, noteMain);
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
                noteMain = new NoteMain(position,note);
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                    showLandDescription(noteMain);
                } else
                    showPortDescription(noteMain);
            });
        }
    }

    private void showPortDescription(NoteMain noteMain){
        NoteDescription note_description = NoteDescription.newInstance(noteMain);
        requireActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment_notes, note_description).addToBackStack("").commit();
    }

    private void showLandDescription(NoteMain noteMain){
        NoteDescription note_description = NoteDescription.newInstance(noteMain);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_note_description, note_description).commit();
    }
}