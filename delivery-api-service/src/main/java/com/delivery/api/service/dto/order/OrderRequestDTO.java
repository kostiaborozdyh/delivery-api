package com.delivery.api.service.dto.order;

import com.delivery.api.service.dto.description.DescriptionRequestDTO;
import com.delivery.api.service.dto.road.RoadRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {
    private DescriptionRequestDTO description;
    private RoadRequestDTO road;
}
