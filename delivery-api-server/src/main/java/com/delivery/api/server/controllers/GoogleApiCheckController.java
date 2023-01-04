package com.delivery.api.server.controllers;

import com.delivery.api.service.dto.googleMaps.GoogleMapsDTO;
import com.delivery.api.service.dto.googleMaps.GoogleMapsRequestDTO;
import com.delivery.api.service.dto.price.PriceDTO;
import com.delivery.api.service.services.GoogleMapsService;
import com.delivery.api.service.utils.GoogleMapsUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class GoogleApiCheckController {

    private final GoogleMapsService googleMapsService;

    @PostMapping("/getInfo")
    public ResponseEntity<List<PriceDTO>> getAllOrdersByUser(@RequestBody GoogleMapsRequestDTO googleMapsRequestDTO) {
        return new ResponseEntity<>(googleMapsService.getPriceList(googleMapsRequestDTO),HttpStatus.OK);
    }
}
