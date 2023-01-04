package com.delivery.api.service.dto.price;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PriceDTO {
    private String cityFrom;
    private String cityTo;
    private Integer distance;
    private Double price;
}
