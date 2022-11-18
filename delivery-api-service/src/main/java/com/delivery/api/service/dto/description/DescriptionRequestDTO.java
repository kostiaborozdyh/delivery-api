package com.delivery.api.service.dto.description;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DescriptionRequestDTO {
    private String description;
    private Double weight;
    private Double height;
    private Double length;
    private Double width;
    private Double price;
}
