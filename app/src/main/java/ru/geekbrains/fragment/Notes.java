package ru.geekbrains.fragment;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initNotes(view);
    }

    private void initNotes(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        String[] notes = getResources().getStringArray(R.array.notes);
        for (String note : notes) {
            TextView tv = new TextView(getContext());
            tv.setText(note);
            tv.setTextSize(30);
            linearLayout.addView(tv);
        }
    }
}