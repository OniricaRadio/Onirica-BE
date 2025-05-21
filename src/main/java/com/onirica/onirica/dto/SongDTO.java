package com.onirica.onirica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;

public class SongDTO {

    @NotBlank(message = "Title is required")
    @Pattern(regexp = "^(?!.*<script).*", message = "Title contains invalid characters")
    private String title;

    @NotBlank(message = "Artist is required")
    @Pattern(regexp = "^(?!.*<script).*", message = "Artist contains invalid characters")
    private String artist;

    @NotBlank(message = "URL is required")
    @URL(message = "Invalid URL format")
    private String url;

    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
