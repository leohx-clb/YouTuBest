package com.example.youtubest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class YouTubeDBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 3;
    private static final String DATABASE_NAME = "youtubevideo.db";

    public static final String YOUTUBE_KEY = "id";
    public static final String YOUTUBE_TITRE = "titre";
    public static final String YOUTUBE_DESCRIPTION = "decription";
    public static final String YOUTUBE_URL = "url";
    public static final String YOUTUBE_CATEGORIE = "categorie";

    public static final String YOUTUBE_TABLE_NAME = "YouTubeVideo";

    public static final int YOUTUBE_KEY_COLUMN_INDEX = 0;
    public static final int YOUTUBE_KEY_COLUMN_TITRE = 1;
    public static final int YOUTUBE_KEY_COLUMN_DESCRIPTION = 2;
    public static final int YOUTUBE_KEY_COLUMN_URL = 3;
    public static final int YOUTUBE_KEY_COLUMN_CATEGORIE = 4;

    public static final String YOUTUBE_TABLE_CREATE =
            "CREATE TABLE " + YOUTUBE_TABLE_NAME + " (" +
                    YOUTUBE_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    YOUTUBE_TITRE + " TEXT, " +
                    YOUTUBE_DESCRIPTION + " TEXT, " +
                    YOUTUBE_URL + " TEXT, " +
                    YOUTUBE_CATEGORIE + " TEXT);";

    private static final String YOUTUBE_TABLE_DROP = "DROP TABLE IF EXISTS " + YOUTUBE_TABLE_NAME + ";";

    public YouTubeDBHelper (Context context) {super(context, DATABASE_NAME, null, VERSION);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(YOUTUBE_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(YOUTUBE_TABLE_DROP);
        onCreate(sqLiteDatabase);
    }
}
