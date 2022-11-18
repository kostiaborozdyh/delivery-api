package com.delivery.api.server.controllers;

import com.delivery.api.service.dto.description.DescriptionRequestDTO;
import com.delivery.api.service.dto.order.OrderRequestDTO;
import com.delivery.api.service.dto.order.OrderResponseDTO;
import com.delivery.api.service.dto.road.RoadRequestDTO;
import com.delivery.api.service.services.OrderService;
import com.delivery.db.entities.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/all")
    public ResponseEntity<List<OrderResponseDTO>> getAllEmployees() {
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequestDTO orderDTO) {
        return new ResponseEntity<>(orderService.createOrder(orderDTO), HttpStatus.OK);
    }
}
