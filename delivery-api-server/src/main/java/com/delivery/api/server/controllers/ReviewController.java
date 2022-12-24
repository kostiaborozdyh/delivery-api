package com.delivery.api.server.controllers;

import com.delivery.api.service.dto.review.ReviewRequestDTO;
import com.delivery.api.service.dto.review.ReviewResponseDTO;
import com.delivery.api.service.services.ReviewService;
import com.delivery.db.entities.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/review", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/all")
    public ResponseEntity<List<ReviewResponseDTO>> getAllReviews(
            @RequestParam(required = false, defaultValue = "${pagination.default.pageSize}") Integer pageSize,
            @RequestParam(required = false, defaultValue = "${pagination.default.pageNum}") Integer pageNum
    ) {
        return new ResponseEntity<>(reviewService.getAll(pageNum, pageSize), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ReviewResponseDTO> createReview(@RequestBody ReviewRequestDTO reviewRequestDTO) {
        return new ResponseEntity<>(reviewService.createReview(reviewRequestDTO), HttpStatus.OK);
    }
}
