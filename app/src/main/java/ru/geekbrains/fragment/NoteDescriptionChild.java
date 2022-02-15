package ru.geekbrains.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NoteDescriptionChild extends Fragment {

    static final String ARG_INDEX_CHILD = "index";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_description_child, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            NoteMain noteMain = arguments.getParcelable(ARG_INDEX_CHILD);
            TextView tvNote = view.findViewById(R.id.description);
            String[] note_description = getResources().getStringArray(R.array.note_description);
            tvNote.setText(note_description[noteMain.getIndex()]);
        }
    }

    public static NoteDescriptionChild newInstance(NoteMain noteMain) {
        NoteDescriptionChild fragment = new NoteDescriptionChild();
        Bundle args = new Bundle();
        args.putParcelable(ARG_INDEX_CHILD, noteMain);
        fragment.setArguments(args);
        return fragment;
    }
}