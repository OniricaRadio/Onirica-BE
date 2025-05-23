package com.onirica.onirica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title must not be blank")
    private String title;

    @NotBlank(message = "Artist must not be blank")
    private String artist;

    @NotBlank(message = "URL must not be blank")
    private String url;

    public Song() {}

    public Song(String title, String artist, String url) {
        this.title = title;
        this.artist = artist;
        this.url = url;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getArtist() { return artist; }

    public void setArtist(String artist) { this.artist = artist; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }
}
