package com.delivery.api.server.controllers;

import com.delivery.api.service.services.RoadService;
import com.delivery.db.entities.Road;
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
@RequestMapping(value = "/road", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoadController {
    private final RoadService roadService;

    @GetMapping("/all")
    public ResponseEntity<List<Road>> getAllEmployees() {
        return new ResponseEntity<>(roadService.getAll(), HttpStatus.OK);
    }
}
