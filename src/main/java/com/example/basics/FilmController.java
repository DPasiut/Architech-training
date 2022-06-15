package com.example.basics;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;

@RestController
@RequestMapping(value = "/film")
public class FilmController {
    private FilmService service;

    public FilmController(FilmService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public Collection<FilmDto> getFilms() {
        return service.getAllFilms();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FilmDto> getFilm(@PathParam("id") Long id) {
        return new ResponseEntity<>(service.getFilm(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<FilmDto> addFilm(@RequestBody FilmDto film) {
        return new ResponseEntity<>(service.addFilm(film), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<FilmDto> editFilm(@RequestParam Long id, @RequestBody FilmDto filmDto) {
        return new ResponseEntity<>(service.edit(id, filmDto), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Long> deleteFilm(@RequestParam Long id) {
        service.deleteFilm(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
