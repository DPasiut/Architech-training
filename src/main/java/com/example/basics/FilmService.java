package com.example.basics;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class FilmService {

    public FilmDto getFilm(Long id) {
        return new FilmDto();
    }

    public Collection<FilmDto> getAllFilms() {
        return new ArrayList<>();
    }

    public FilmDto addFilm(FilmDto film) {
        return film;
    }

    public FilmDto edit(Long id, FilmDto filmDto) {
        return new FilmDto();
    }

    public Boolean deleteFilm(Long id) {
        return true;
    }
}
