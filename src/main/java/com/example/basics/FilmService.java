package com.example.basics;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmService {

    FilmRepository filmRepository;
    SequenceGeneratorService sequenceGeneratorService;
    FilmService(FilmRepository filmRepository, SequenceGeneratorService service){
        this.filmRepository = filmRepository;
        this.sequenceGeneratorService = service;
    }
    public FilmDto getFilm(String id) {
        Optional<Film> film = filmRepository.findById(id);
        if (film.isEmpty()){
            throw new RuntimeException();
        }
        return film.get().dto();
    }

    public Collection<FilmDto> getAllFilms() {
        return filmRepository.findAll().stream().map(Film::dto).collect(Collectors.toList());
    }

    public FilmDto saveFilm(FilmDto filmDto) {
        Film film = Film.builder()
                .id(String.valueOf(sequenceGeneratorService.generateSequence(Film.SEQUENCE_NAME)))
                .author(filmDto.getAuthor())
                .category(filmDto.getCategory())
                .description(filmDto.getDescription())
                .title(filmDto.getTitle())
                .url(filmDto.getUrl())
                .build();
        filmRepository.save(film);
        return film.dto();
    }

    public FilmDto edit(String id, FilmDto filmDto) {
        Optional<Film> film = filmRepository.findById(id);
        if (film.isEmpty()){
            throw new RuntimeException();
        }
        Film oldFilm = film.get();
        Film editedFilm = Film.builder()
                .id(oldFilm.getId())
                .author(filmDto.getAuthor())
                .category(filmDto.getCategory())
                .description(filmDto.getDescription())
                .title(filmDto.getTitle())
                .url(filmDto.getUrl())
                .build();
        filmRepository.save(editedFilm);
        return editedFilm.dto();
    }

    public void deleteFilm(String id) {
        filmRepository.deleteById(id);
    }

}
