package com.example.youtubest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.youtubest.pojos.YoutubeVideo;

public class DetailActivity extends AppCompatActivity {

    private TextView tvTitre;
    private TextView tvContent;
    private Button btnVoir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent =  getIntent();
        YoutubeVideo youtubeVideo = (YoutubeVideo) intent.getSerializableExtra("video");

        tvTitre = findViewById(R.id.tvTitre);
        tvContent = findViewById(R.id.tvContent);
        btnVoir = findViewById(R.id.buttonVoir);

        tvTitre.setText(youtubeVideo.getTitre());
        tvContent.setText(youtubeVideo.getCategorie()+"\n"+youtubeVideo.getDescription());

        btnVoir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + youtubeVideo.getUrl()));
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse( youtubeVideo.getUrl()));
                //https://www.youtube.com/https:/www.youtube.com/watch?v=EKiLMRSSWEo&ab_channel=l%C3%A9onardMaron
                //https://www.youtube.com/EKiLMRSSWEo&ab_channel=l%C3%A9onardMaron
                //https://www.youtube.com/yuvirehky04&ab_channel=FreemeNCSMusic
                try {
                    startActivity(appIntent);
                } catch (ActivityNotFoundException ex) {
                    startActivity(webIntent);
                }
            }
        });

        //navBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}