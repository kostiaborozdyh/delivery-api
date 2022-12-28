package com.delivery.api.service.convertor.impl;

import com.delivery.api.service.convertor.Convertable;
import com.delivery.api.service.dto.review.ReviewRequestDTO;
import com.delivery.api.service.dto.review.ReviewResponseDTO;
import com.delivery.db.entities.Review;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewConvertor implements Convertable<Review, ReviewRequestDTO, ReviewResponseDTO> {
    private final ModelMapper mapper;

    @Override
    public Review convertFromRequestDto(ReviewRequestDTO reviewRequestDTO) {
        return mapper.map(reviewRequestDTO, Review.class);
    }

    @Override
    public ReviewResponseDTO convertToResponseDTO(Review review) {

        ReviewResponseDTO reviewResponseDTO = mapper.map(review, ReviewResponseDTO.class);
        reviewResponseDTO.setUserFirstName(review.getUser().getFirstName());
        return reviewResponseDTO;
    }

    @Override
    public List<ReviewResponseDTO> convertToListResponseDTO(List<Review> reviewList) {
        return mapper.map(reviewList, new TypeToken<List<ReviewResponseDTO>>() {
        }.getType());
    }
}
