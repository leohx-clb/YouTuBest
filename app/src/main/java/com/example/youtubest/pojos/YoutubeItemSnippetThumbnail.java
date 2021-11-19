package com.example.youtubest.pojos;

public class YoutubeItemSnippetThumbnail {

    private String url;
    private int widht;
    private int height;

    public YoutubeItemSnippetThumbnail() {
    }

    public YoutubeItemSnippetThumbnail(String url, int widht, int height) {
        this.url = url;
        this.widht = widht;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidht() {
        return widht;
    }

    public void setWidht(int widht) {
        this.widht = widht;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "YoutubeItemSnippetThumbnail{" +
                "url='" + url + '\'' +
                ", widht=" + widht +
                ", height=" + height +
                '}';
    }
}
