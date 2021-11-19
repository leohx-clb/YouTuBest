package com.example.youtubest.pojos;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class YoutubeItemSnippet {

    private Date publishedAt;
    private String channelId;
    private String title;
    private String description;
    private Map<String, YoutubeItemSnippetThumbnail> thumbnails = new HashMap<>();
    private String channelTitle;
    private String playlistId;
    private int position;
    private YoutubeItemSnippetResourceId youtubeItemSnippetResourceId;

    public YoutubeItemSnippet() {
    }

    public YoutubeItemSnippet(Date publishedAt, String channelId, String title, String description, Map<String, YoutubeItemSnippetThumbnail> thumbnails, String channelTitle, String playlistId, int position, YoutubeItemSnippetResourceId youtubeItemSnippetResourceId) {
        this.publishedAt = publishedAt;
        this.channelId = channelId;
        this.title = title;
        this.description = description;
        this.thumbnails = thumbnails;
        this.channelTitle = channelTitle;
        this.playlistId = playlistId;
        this.position = position;
        this.youtubeItemSnippetResourceId = youtubeItemSnippetResourceId;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, YoutubeItemSnippetThumbnail> getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Map<String, YoutubeItemSnippetThumbnail> thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public YoutubeItemSnippetResourceId getYoutubeItemSnippetResourceId() {
        return youtubeItemSnippetResourceId;
    }

    public void setYoutubeItemSnippetResourceId(YoutubeItemSnippetResourceId youtubeItemSnippetResourceId) {
        this.youtubeItemSnippetResourceId = youtubeItemSnippetResourceId;
    }

    @Override
    public String toString() {
        return "YoutubeItemSnippet{" +
                "publishedAt=" + publishedAt +
                ", channelId='" + channelId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", thumbnails=" + thumbnails +
                ", channelTitle='" + channelTitle + '\'' +
                ", playlistId='" + playlistId + '\'' +
                ", position=" + position +
                ", youtubeItemSnippetResourceId=" + youtubeItemSnippetResourceId +
                '}';
    }
}
