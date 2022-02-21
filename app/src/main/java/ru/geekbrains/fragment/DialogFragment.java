package ru.geekbrains.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class DialogFragment extends androidx.fragment.app.DialogFragment {
    public static final String TAG = "MyDialog";

    @Override
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
       Activity activity = requireActivity();
        return new AlertDialog.Builder(activity).setTitle("Выход!")
                            .setMessage("Вы действительно хотите выйти?")
                            .setPositiveButton("Да", ((dialogInterface, i) ->
                                   exit(activity)))
                            .setNeutralButton("Нет",null).create();
    }

    void exit (Activity activity){
        Toast.makeText(activity,"Приложение закрыто" , Toast.LENGTH_LONG).show();
        activity.finish();
    }
}