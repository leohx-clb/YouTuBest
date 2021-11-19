package com.example.youtubest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.youtubest.dao.YouTubeVideoDAO;
import com.example.youtubest.pojos.YoutubeVideo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddYouTubeActivity extends AppCompatActivity {

    private YouTubeVideoDAO youTubeVideoDAO;
    private Context context;
    private Button btnAdd;
    //recup item
    private TextView tvTritre;
    private TextView tvDescription;
    private TextView tvURL;
    private Spinner spCategorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_you_tube);
        context = getApplicationContext();
        btnAdd = findViewById(R.id.buttonAdd);

        tvTritre = findViewById(R.id.edTitre);
        tvDescription = findViewById(R.id.edDescription);
        tvURL = findViewById(R.id.edUrl);
        spCategorie = findViewById(R.id.spCategorie);
        youTubeVideoDAO = new YouTubeVideoDAO(getApplicationContext());

        //spinner
        Spinner spinner =(Spinner) findViewById(R.id.spCategorie);
        // item spinner
        String[] categories = new String[]{
                "Sport",
                "Jeux Video",
                "Sport",
                "Music",
                "Tuto"
        };
        final List<String> categoriesList= new ArrayList<>(Arrays.asList(categories));
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                getApplicationContext(),R.layout.spinner_item,categoriesList);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(spinnerArrayAdapter);

        //navBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoutubeVideo youtubeVideo =
                        new YoutubeVideo(
                            tvTritre.getText().toString(),
                            tvDescription.getText().toString(),
                            tvURL.getText().toString(),
                            spCategorie.getSelectedItem().toString());
                //test
                //Toast.makeText(context,tvTritre.getText().toString()+tvDescription.getText().toString()+tvURL.getText().toString()+spCategorie.getSelectedItem().toString(),Toast.LENGTH_LONG).show();

                //ajout en base
                youTubeVideoDAO.add(youtubeVideo);
                finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}