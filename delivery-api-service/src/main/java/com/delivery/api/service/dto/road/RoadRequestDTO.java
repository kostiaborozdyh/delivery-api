package com.delivery.api.service.dto.road;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoadRequestDTO {
    private String address;
    private String cityFrom;
    private String cityTo;
}
