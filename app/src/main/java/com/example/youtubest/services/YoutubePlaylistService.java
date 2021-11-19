package com.example.youtubest.services;

import com.example.youtubest.pojos.YouTubePlaylist;
import com.example.youtubest.pojos.YoutubeItemPlaylist;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubePlaylistService {

    public static final String ENDPOINT = "https://www.googleapis.com/youtube/v3/";
    public static final String API_KEY = "AIzaSyDWsQYGYOKZ7l9DnQLBJ5sZ6sS5UMVDIBI";

    @GET("playlistItems")
    Call<YouTubePlaylist> getYoutubePlaylists(@Query("key") String key,
                                              @Query("part") String part,
                                              @Query("playlistId") String playlistId,
                                              @Query("maxResults") int maxResultss);
}
