package com.delivery.api.server.controllers;

import com.delivery.api.service.services.ReviewsService;
import com.delivery.db.entities.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/review", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReviewsController {
    private final ReviewsService reviewsService;

    @GetMapping("/all")
    public ResponseEntity<List<Review>> getAllEmployees() {
        return new ResponseEntity<>(reviewsService.getAll(), HttpStatus.OK);
    }
}
