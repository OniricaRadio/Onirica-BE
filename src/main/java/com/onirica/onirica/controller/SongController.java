package com.onirica.onirica.controller;

import com.onirica.onirica.dto.SongDTO;
import com.onirica.onirica.model.Song;
import com.onirica.onirica.service.SongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/songs")

public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    @PostMapping
    public ResponseEntity<?> createSong(@Validated @RequestBody SongDTO songDTO) {
    
    Song song = new Song(songDTO.getTitle(), songDTO.getArtist(), songDTO.getUrl());

    Song savedSong = songService.saveSong(song);
    return ResponseEntity.ok(savedSong);
}

    @PutMapping("/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable Long id, @RequestBody Song updatedSong) {
        Optional<Song> optionalSong = songService.getSongById(id);
        if (optionalSong.isEmpty()) return ResponseEntity.notFound().build();

        Song existing = optionalSong.get();
        existing.setTitle(updatedSong.getTitle());
        existing.setArtist(updatedSong.getArtist());
        existing.setUrl(updatedSong.getUrl());
        
        if (!updatedSong.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        
        songService.saveSong(existing);
        return ResponseEntity.ok(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
    }
}