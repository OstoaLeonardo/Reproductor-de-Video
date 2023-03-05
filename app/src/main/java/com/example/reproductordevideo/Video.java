package com.example.reproductordevideo;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;

public class Video {
    private String name;
    private String path;
    private int duration;

    public Video(String name, String path, int duration) {
        this.name = name;
        this.path = path;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return name + "\n" + getDurationString(duration);
    }

    public String getDurationString(int duration) {
        int hours = (duration / (1000*60*60));
        int minutes = (duration / (1000*60)) % 60;
        int seconds = (duration / 1000) % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
