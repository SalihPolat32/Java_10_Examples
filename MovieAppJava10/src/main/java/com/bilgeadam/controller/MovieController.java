package com.bilgeadam.controller;

import com.bilgeadam.repository.entity.Movie;
import com.bilgeadam.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.bilgeadam.constant.RestApiUrl.*;

@RestController
@RequestMapping(MOVIE)
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/beforePremired")
    public ResponseEntity<List<Movie>> findAllByPremiredBefore(String date) {

        return ResponseEntity.ok(movieService.findAllByPremiredBefore(date));
    }
}