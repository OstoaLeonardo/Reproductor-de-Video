package com.example.reproductordevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
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
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.video_item_list, parent, false);
        }

        Video video = getItem(position);

        if (video != null) {
            ImageView thumbnail = convertView.findViewById(R.id.thumbnail);
            TextView name = convertView.findViewById(R.id.videoName);
            TextView duration = convertView.findViewById(R.id.videoDuration);

            if (thumbnail != null) {
                thumbnail.setImageResource(R.drawable.movie_48px);
            } else {
                thumbnail.setImageResource(R.drawable.movie_48px);
            }

            if (name != null) {
                name.setText(video.getName());
            }

            if (duration != null) {
                duration.setText(video.getDurationString(video.getDuration()));
            }
        }

        return convertView;
    }
}
