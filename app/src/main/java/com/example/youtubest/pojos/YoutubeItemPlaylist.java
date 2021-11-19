package com.example.youtubest.pojos;

import java.util.List;

public class YoutubeItemPlaylist {

    private String king;
    private String etag;
    private String id;
    private YoutubeItemSnippet snippet;
    private YoutubeItemContentDetails contentDetails;

    public YoutubeItemPlaylist() {
    }

    public YoutubeItemPlaylist(String king, String etag, String id, YoutubeItemSnippet snippet, YoutubeItemContentDetails contentDetails) {
        this.king = king;
        this.etag = etag;
        this.id = id;
        this.snippet = snippet;
        this.contentDetails = contentDetails;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public YoutubeItemSnippet getSnippet() {
        return snippet;
    }

    public void setSnippet(YoutubeItemSnippet snippet) {
        this.snippet = snippet;
    }

    public YoutubeItemContentDetails getContentDetails() {
        return contentDetails;
    }

    public void setContentDetails(YoutubeItemContentDetails contentDetails) {
        this.contentDetails = contentDetails;
    }

    @Override
    public String toString() {
        return "YoutubeItemPlaylist{" +
                "king='" + king + '\'' +
                ", etag='" + etag + '\'' +
                ", id='" + id + '\'' +
                ", snippet=" + snippet +
                ", contentDetails=" + contentDetails +
                '}';
    }
}
