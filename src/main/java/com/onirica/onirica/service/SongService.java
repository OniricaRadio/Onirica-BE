package com.onirica.onirica.service;

import com.onirica.onirica.model.Song;
import com.onirica.onirica.repository.SongRepository;
import org.springframework.stereotype.Service;
import com.onirica.onirica.util.SanitizerUtil;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepository;

    
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Song saveSong(Song song) {
        song.setTitle(SanitizerUtil.sanitize(song.getTitle()));
        song.setUrl(SanitizerUtil.sanitize(song.getUrl()));
        return songRepository.save(song);
    }

    public Optional<Song> getSongById(Long id) {
        return songRepository.findById(id);
    }

    public Song updateSong(Long id, Song updatedSong) {
        return songRepository.findById(id)
                .map(song -> {
                    song.setTitle(updatedSong.getTitle());
                    song.setArtist(updatedSong.getArtist());
                    song.setUrl(updatedSong.getUrl());
                    return songRepository.save(song);
                })
                .orElseThrow(() -> new RuntimeException("Song not found with id " + id));
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
