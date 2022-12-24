package com.delivery.api.service.services;

import com.delivery.api.service.convertors.ReviewConvertor;
import com.delivery.api.service.dto.review.ReviewRequestDTO;
import com.delivery.api.service.dto.review.ReviewResponseDTO;
import com.delivery.db.entities.Review;
import com.delivery.db.entities.User;
import com.delivery.db.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private final ReviewConvertor reviewConvertor;

    @Transactional(readOnly = true)
    public List<ReviewResponseDTO> getAll(int pageNum, int pageSize) {
        List<Review> reviewList = reviewRepository.findAll(PageRequest.of(pageNum, pageSize)).stream().toList();
        return reviewConvertor.convertToListResponseDTO(reviewList);
    }


    public ReviewResponseDTO createReview(ReviewRequestDTO reviewRequestDTO) {
        User user = userService.getCurrentUser();
        Review review = reviewConvertor.convertFromRequestDto(reviewRequestDTO);
        review.setUser(user);
        review = save(review);
        return reviewConvertor.convertToResponseDTO(review);
    }

    @Transactional(rollbackFor = Exception.class)
    public Review save(Review review){
        return reviewRepository.save(review);
    }
}
