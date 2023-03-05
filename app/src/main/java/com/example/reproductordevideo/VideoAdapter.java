package com.example.reproductordevideo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class VideoAdapter extends ArrayAdapter<Video> {
    private int resourceLayout;
    private Context mContext;

    public VideoAdapter(Context context, int resource, List<Video> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }

        Video p = getItem(position);

        if (p != null) {
            ImageView thumbnail = v.findViewById(R.id.thumbnail);
            TextView name = v.findViewById(R.id.videoName);
            TextView duration = v.findViewById(R.id.videoDuration);

            if (thumbnail != null) {
                thumbnail.setImageResource(R.drawable.default_thumbnail);
            }

            if (name != null) {
                name.setText(p.getName());
            }

            if (duration != null) {
                duration.setText(p.getDurationString(p.getDuration()));
            }
        }

        return v;
    }
}
