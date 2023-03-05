package com.example.reproductordevideo;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView videoList;
    private ArrayAdapter<Video> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoList = findViewById(R.id.videoList);

        mAdapter = new VideoAdapter(this, R.layout.video_item_list, getVideoList());
        videoList.setAdapter(mAdapter);

        videoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Video video = mAdapter.getItem(i);
                playVideo(video.getPath());
            }
        });
    }

    private List<Video> getVideoList() {
        List<Video> videoList = new ArrayList<>();

        Uri collection = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        String[] projection = new String[]{MediaStore.Video.Media.DATA, MediaStore.Video.Media.DISPLAY_NAME, MediaStore.Video.Media.DURATION};

        try{
            Cursor cursor = getApplicationContext().getContentResolver().query(collection,projection, null,null,null);

            while(cursor.moveToNext()){
                String videoPath = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA));
                String videoName = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME));
                int duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION));
                videoList.add(new Video(videoName, videoPath, duration));
            }
            cursor.close();
        } catch (Exception e){}

        return videoList;
    }

    private void playVideo(String videoPath){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse(videoPath),"video/*");
        startActivity(intent);
    }
}