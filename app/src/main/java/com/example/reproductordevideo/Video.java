package com.example.reproductordevideo;

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

        if (hours > 0) {
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        } else {
            return String.format("%02d:%02d", minutes, seconds);
        }
    }
}
