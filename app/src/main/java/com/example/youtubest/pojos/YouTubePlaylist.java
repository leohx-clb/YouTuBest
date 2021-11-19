package com.example.youtubest.pojos;

import java.util.List;

public class YouTubePlaylist {

    private String king;
    private String etag;
    private List<YoutubeItemPlaylist> items;


    public YouTubePlaylist() {
    }

    public YouTubePlaylist(String king, String etag, List<YoutubeItemPlaylist> items) {
        this.king = king;
        this.etag = etag;
        this.items = items;
    }

    public String getKing() {
        return king;
    }

    public void setKing(String king) {
        this.king = king;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public List<YoutubeItemPlaylist> getItems() {
        return items;
    }

    public void setItems(List<YoutubeItemPlaylist> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "YouTubePlaylist{" +
                "king='" + king + '\'' +
                ", etag='" + etag + '\'' +
                ", items=" + items +
                '}';
    }
}
