package com.delivery.api.service.dto.review;

import com.delivery.api.service.dto.user.UserResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReviewResponseDTO {
    private UserResponseDTO user;
    private String userResponse;
    private LocalDateTime date;
}
