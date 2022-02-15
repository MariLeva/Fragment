package ru.geekbrains.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class NoteDescription extends Fragment {

    static final String ARG_INDEX = "index";
    static final SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            requireActivity().getSupportFragmentManager().popBackStack();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_description, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            NoteMain noteMain = (NoteMain) arguments.getParcelable(ARG_INDEX);
            TextView tvName = view.findViewById(R.id.nameNote);
            TextView tvDate = view.findViewById(R.id.date);
            tvName.setText(noteMain.getNoteName());
            tvDate.setText(format.format(noteMain.getDate()));
            getChildFragmentManager().beginTransaction().replace(R.id.description_fragment, NoteDescriptionChild.newInstance(noteMain)).commit();
        }
    }

    public static NoteDescription newInstance(NoteMain noteMain) {
        NoteDescription fragment = new NoteDescription();
        Bundle args = new Bundle();
        args.putParcelable(ARG_INDEX, noteMain);
        fragment.setArguments(args);
        return fragment;
    }
}