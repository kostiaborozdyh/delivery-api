package com.delivery.api.service.dto.review;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReviewResponseDTO {
    private String userFirstName;
    private String userResponse;
    private LocalDateTime date;
}
