package com.delivery.api.service.dto.order;

import com.delivery.api.service.dto.dates.DatesResponseDTO;
import com.delivery.api.service.dto.description.DescriptionResponseDTO;
import com.delivery.api.service.dto.road.RoadResponseDTO;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrderResponseDTO {
    private Integer id;
    private DescriptionResponseDTO description;
    private RoadResponseDTO road;
    private DatesResponseDTO dates;
    private String userLogin;
    private String paymentStatus;
    private String locationStatus;

}
