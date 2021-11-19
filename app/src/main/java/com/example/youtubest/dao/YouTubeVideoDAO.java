package com.example.youtubest.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.youtubest.db.YouTubeDBHelper;
import com.example.youtubest.pojos.YoutubeVideo;

import java.util.ArrayList;
import java.util.List;

public class YouTubeVideoDAO extends DAO{

    public YouTubeVideoDAO(Context context) {super(new YouTubeDBHelper(context));}

    public YoutubeVideo find(int id) {
        // déclare une variable qui stockera l'objet créé
        YoutubeVideo youTubeVideo = null;

        // ouvre la base de données
        open();

        // exécute la requete et renvoie un Cursor contenant les données
        Cursor cursor = db.rawQuery("select * from " + YouTubeDBHelper.YOUTUBE_TABLE_NAME +
                        " where " + YouTubeDBHelper.YOUTUBE_KEY + " = ?",
                new String[]{String.valueOf(id)});

        // positionne le cursor sur le premier enregistrement
        if (cursor != null && cursor.moveToFirst()) {
            youTubeVideo = new YoutubeVideo();
            youTubeVideo.setId(cursor.getInt(YouTubeDBHelper.YOUTUBE_KEY_COLUMN_INDEX));
            youTubeVideo.setTitre(cursor.getString(YouTubeDBHelper.YOUTUBE_KEY_COLUMN_TITRE));
            youTubeVideo.setDescription(cursor.getString(YouTubeDBHelper.YOUTUBE_KEY_COLUMN_DESCRIPTION));
            youTubeVideo.setUrl(cursor.getString(YouTubeDBHelper.YOUTUBE_KEY_COLUMN_URL));
            youTubeVideo.setCategorie(cursor.getString(YouTubeDBHelper.YOUTUBE_KEY_COLUMN_CATEGORIE));

            // ferme le cursor
            cursor.close();
        }

        // ferme la bdd
        close();

        return youTubeVideo;
    }

    public List<YoutubeVideo> list() {

        // déclare la variable qui va stocker la liste d'objets
        List<YoutubeVideo> youtubeVideos = new ArrayList<>();

        // ouvre la base de données
        open();

        // éxécute la requete et renvoie un Cursor contenant les données
        Cursor cursor = db.rawQuery("select * from " + YouTubeDBHelper.YOUTUBE_TABLE_NAME, null);

        // positionne le cursor sur le premier enregistrement
        if (cursor != null && cursor.moveToFirst()) {
            // boucle tant que le cursor n'est pas arrivé sur le dernier enregistrement
            while (!cursor.isAfterLast()) {
                YoutubeVideo youTubeVideo = new YoutubeVideo();
                youTubeVideo = new YoutubeVideo();
                youTubeVideo.setId(cursor.getInt(YouTubeDBHelper.YOUTUBE_KEY_COLUMN_INDEX));
                youTubeVideo.setTitre(cursor.getString(YouTubeDBHelper.YOUTUBE_KEY_COLUMN_TITRE));
                youTubeVideo.setDescription(cursor.getString(YouTubeDBHelper.YOUTUBE_KEY_COLUMN_DESCRIPTION));
                youTubeVideo.setUrl(cursor.getString(YouTubeDBHelper.YOUTUBE_KEY_COLUMN_URL));
                youTubeVideo.setCategorie(cursor.getString(YouTubeDBHelper.YOUTUBE_KEY_COLUMN_CATEGORIE));

                // ajoute le todo créé dans la liste
                youtubeVideos.add(youTubeVideo);

                //passe à l'enregistrement suivant
                cursor.moveToNext();
            }

            // ferme le curseur
            cursor.close();
        }

        // ferme la base de données
        close();

        return youtubeVideos;
    }

    public void add(YoutubeVideo youtubeVideo) {
        // ouvre la base de données
        open();

        ContentValues values = new ContentValues();

        values.put(YouTubeDBHelper.YOUTUBE_TITRE, youtubeVideo.getTitre());
        values.put(YouTubeDBHelper.YOUTUBE_DESCRIPTION, youtubeVideo.getDescription());
        values.put(YouTubeDBHelper.YOUTUBE_URL, youtubeVideo.getUrl());
        values.put(YouTubeDBHelper.YOUTUBE_CATEGORIE, youtubeVideo.getCategorie());


        // effectue une insertion des données et récupère l'id généré
        int id = (int) db.insert(YouTubeDBHelper.YOUTUBE_TABLE_NAME, null, values);

        // met à jour l'id de l'objet
        youtubeVideo.setId(id);

        // ferme la base de données
        close();
    }

    public void update(YoutubeVideo youtubeVideo) {
        open();

        ContentValues values = new ContentValues();

        values.put(YouTubeDBHelper.YOUTUBE_TITRE, youtubeVideo.getTitre());
        values.put(YouTubeDBHelper.YOUTUBE_DESCRIPTION, youtubeVideo.getDescription());
        values.put(YouTubeDBHelper.YOUTUBE_URL, youtubeVideo.getUrl());
        values.put(YouTubeDBHelper.YOUTUBE_CATEGORIE, youtubeVideo.getCategorie());

        // exécute le update avec la clause where id = ?
        db.update(YouTubeDBHelper.YOUTUBE_TABLE_NAME, values, YouTubeDBHelper.YOUTUBE_KEY + " = ?",
                new String[]{String.valueOf(youtubeVideo.getId())});

        close();
    }

    public void delete(YoutubeVideo youtubeVideo) {
        open();

        // exécute le delete avec la clause where id = ?
        db.delete(YouTubeDBHelper.YOUTUBE_TABLE_NAME, YouTubeDBHelper.YOUTUBE_KEY + " = ?",
                new String[]{String.valueOf(youtubeVideo.getId())});

        close();
    }
}
