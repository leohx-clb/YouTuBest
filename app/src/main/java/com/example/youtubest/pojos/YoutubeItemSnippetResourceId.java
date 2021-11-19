package com.example.youtubest.pojos;

public class YoutubeItemSnippetResourceId {

    private String king;
    private String videoId;

    public YoutubeItemSnippetResourceId() {
    }

    public YoutubeItemSnippetResourceId(String king, String videoId) {
        this.king = king;
        this.videoId = videoId;
    }

    public String getKing() {
        return king;
    }

    public void setKing(String king) {
        this.king = king;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @Override
    public String toString() {
        return "YoutubeItemSnippetResourceId{" +
                "king='" + king + '\'' +
                ", videoId='" + videoId + '\'' +
                '}';
    }
}
