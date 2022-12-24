package com.delivery.api.service.convertors;

import com.delivery.api.service.dto.order.OrderRequestDTO;
import com.delivery.api.service.dto.review.ReviewRequestDTO;
import com.delivery.api.service.dto.review.ReviewResponseDTO;
import com.delivery.db.entities.Order;
import com.delivery.db.entities.Review;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewConvertor {
    private final ModelMapper mapper;

    public Review convertFromRequestDto(ReviewRequestDTO reviewRequestDTO) {
        return mapper.map(reviewRequestDTO, Review.class);
    }

    public ReviewResponseDTO convertToResponseDTO(Review review) {
        return mapper.map(review, ReviewResponseDTO.class);
    }

    public List<ReviewResponseDTO> convertToListResponseDTO(List<Review> reviewList) {
        return mapper.map(reviewList, new TypeToken<List<ReviewResponseDTO>>() {
        }.getType());
    }
}
