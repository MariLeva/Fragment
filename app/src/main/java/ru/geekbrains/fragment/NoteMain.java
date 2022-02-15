package ru.geekbrains.fragment;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class NoteMain implements Parcelable {
    private final int index;
    private Date date;
    private final String noteName;

    public NoteMain(int index, String note) {
        this.index = index;
        this.noteName = note;
        this.date = new Date();
    }

    public int getIndex() {
        return index;
    }

    public Date getDate() {
        return date;
    }

    public String getNoteName() {
        return noteName;
    }

    protected NoteMain(Parcel in) {
        index = in.readInt();
        noteName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(index);
        dest.writeString(noteName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NoteMain> CREATOR = new Creator<NoteMain>() {
        @Override
        public NoteMain createFromParcel(Parcel in) {
            return new NoteMain(in);
        }

        @Override
        public NoteMain[] newArray(int size) {
            return new NoteMain[size];
        }
    };
}
