package com.delivery.api.service.services;

import com.delivery.db.entities.Review;
import com.delivery.db.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewsService {
    private final ReviewRepository reviewRepository;
    @Transactional(readOnly = true)
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }
}
