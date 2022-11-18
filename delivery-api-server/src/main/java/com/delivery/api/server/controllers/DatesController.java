package com.delivery.api.server.controllers;

import com.delivery.api.service.services.DatesService;
import com.delivery.db.entities.Dates;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/dates", produces = MediaType.APPLICATION_JSON_VALUE)
public class DatesController {
    private final DatesService datesService;

    @GetMapping("/all")
    public ResponseEntity<List<Dates>> getAllEmployees() {
        return new ResponseEntity<>(datesService.getAll(), HttpStatus.OK);
    }
}
