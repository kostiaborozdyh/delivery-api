package com.delivery.api.service.dto.googleMaps;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GoogleMapsDTO {
    private List<String> destination_addresses;
    private List<String> origin_addresses;
    private List<RowsDTO> rows;
    private String status;
}
