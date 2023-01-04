package com.delivery.api.service.dto.googleMaps;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElementsDTO {
    private DistanceDTO distance;
    private DurationDTO duration;
    private DurationInTrafficDTO duration_in_traffic;
    private String status;
}
