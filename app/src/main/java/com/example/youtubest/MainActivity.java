package com.example.youtubest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.youtubest.adapters.YoutubeAdapter;
import com.example.youtubest.dao.YouTubeVideoDAO;
import com.example.youtubest.pojos.YoutubeVideo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_YouTubeVideoList="youTubeVideoList";

    private RecyclerView rvYouTube;
    private Context context;
    private YouTubeVideoDAO youTubeDAO;
    private YoutubeAdapter youtubeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_main);
        context = getApplicationContext();
        youTubeDAO = new YouTubeVideoDAO(context);
        rvYouTube = findViewById(R.id.rvYouTube);

        //recycler view
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        rvYouTube.setHasFixedSize(true);
        rvYouTube.setLayoutManager(layoutManager);

    }

    @Override
    protected void onStart() {
        super.onStart();
        YouTubeAsyncTask todoAsyncTask = new YouTubeAsyncTask();
        todoAsyncTask.execute();
    }

    public class YouTubeAsyncTask extends AsyncTask<String, String, List<YoutubeVideo>> {

        @Override
        protected List<YoutubeVideo> doInBackground(String... strings) {
            List<YoutubeVideo> responseYoutubeVideo = new ArrayList<>();
            try {
                responseYoutubeVideo = youTubeDAO.list();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return responseYoutubeVideo;
        }

        @Override
        protected void onPostExecute(List<YoutubeVideo> youtubeVideos) {
            youtubeAdapter = new YoutubeAdapter(youtubeVideos, new YoutubeAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(YoutubeVideo youtubeVideo) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("video", youtubeVideo);
                    startActivity(intent);
                }
            });
            rvYouTube.setAdapter(youtubeAdapter);
        }

    }
    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addYouTube:
                //crée un Intent pour ensuite démarrer AddYouTubeActivity
                Intent intent = new Intent(context, AddYouTubeActivity.class);

                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}