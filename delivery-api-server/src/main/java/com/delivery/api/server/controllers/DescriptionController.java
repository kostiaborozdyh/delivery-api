package com.delivery.api.server.controllers;

import com.delivery.api.service.services.DescriptionService;
import com.delivery.db.entities.Description;
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
@RequestMapping(value = "/description", produces = MediaType.APPLICATION_JSON_VALUE)
public class DescriptionController {
    private final DescriptionService descriptionService;

    @GetMapping("/all")
    public ResponseEntity<List<Description>> getAllEmployees() {
        return new ResponseEntity<>(descriptionService.getAll(), HttpStatus.OK);
    }
}
