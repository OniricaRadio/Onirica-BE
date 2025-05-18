package com.onirica.onirica.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/songs")

public class SongController {

    @GetMapping
    public List<Song> getSongs() {
        return List.of(
            new Song("Strawberry", "Doss", "/audio/Doss-Strawberry.mp3" + //
                                "")
        );
    }

    static class Song {
        private String title;
        private String artist;
        private String url;

        public Song(String title, String artist, String url) {
            this.title = title;
            this.artist = artist;
            this.url = url;
        }

        // Getters
        public String getTitle() { return title; }
        public String getArtist() { return artist; }
        public String getUrl() { return url; }
    }
}
