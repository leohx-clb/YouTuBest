package com.example.youtubest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.youtubest.dao.YouTubeVideoDAO;
import com.example.youtubest.pojos.YouTubePlaylist;
import com.example.youtubest.pojos.YoutubeItemPlaylist;
import com.example.youtubest.pojos.YoutubeVideo;
import com.example.youtubest.services.YoutubePlaylistService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaylistActivity extends AppCompatActivity {

    private Button btnAdd;
    private TextView edUrl;
    private YouTubePlaylist youTubePlaylist;
    private YouTubeVideoDAO youTubeVideoDAO;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        context = getApplicationContext();
        btnAdd = findViewById(R.id.buttonAdd);
        //navBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        youTubeVideoDAO = new YouTubeVideoDAO(context);

        edUrl = findViewById(R.id.edUrl);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoutubePlaylistService youtubePlaylistService = new Retrofit.Builder()
                        .baseUrl(YoutubePlaylistService.ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(YoutubePlaylistService.class);

                youtubePlaylistService.getYoutubePlaylists(
                        YoutubePlaylistService.API_KEY,
                        "snippet,contentDetails",
                        edUrl.getText().toString(),
                        20).enqueue(new Callback<YouTubePlaylist>() {
                    @Override
                    public void onResponse(Call<YouTubePlaylist> call, Response<YouTubePlaylist> response) {
                        youTubePlaylist = response.body();
                        for (YoutubeItemPlaylist youtubeItemPlaylist:youTubePlaylist.getItems()) {
                            YoutubeVideo youtubeVideo = new YoutubeVideo();
                            youtubeVideo.setTitre(youtubeItemPlaylist.getSnippet().getTitle());
                            youtubeVideo.setDescription(youtubeItemPlaylist.getSnippet().getDescription());
                            youtubeVideo.setUrl(youtubeItemPlaylist.getContentDetails().getVideoId());
                            youtubeVideo.setCategorie("Playlist add");
                            youTubeVideoDAO.add(youtubeVideo);
                        }
                        finish();
                    }

                    @Override
                    public void onFailure(Call<YouTubePlaylist> call, Throwable t) {

                    }
                });

            }
        });


    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}