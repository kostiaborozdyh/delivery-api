package com.delivery.api.service.dto.description;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DescriptionResponseDTO {
    private String description;
    private Double weight;
    private Double volume;
    private Double price;
}
