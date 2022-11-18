package com.delivery.api.service.convertors;

import com.delivery.api.service.dto.description.DescriptionRequestDTO;
import com.delivery.api.service.dto.order.OrderRequestDTO;
import com.delivery.api.service.dto.order.OrderResponseDTO;
import com.delivery.db.entities.Dates;
import com.delivery.db.entities.LocationStatus;
import com.delivery.db.entities.Order;
import com.delivery.db.entities.PaymentStatus;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;
@Component
@RequiredArgsConstructor
public class OrderConvertor {
    private final  ModelMapper mapper;
    public Order convertFromRequestDto(OrderRequestDTO orderRequestDTO){
        Order order =  mapper.map(orderRequestDTO, Order.class);
        Dates dates = new Dates();
        dates.setDateOfArrival(LocalDateTime.now());
        order.setDates(dates);
        DescriptionRequestDTO description = orderRequestDTO.getDescription();
        order.getDescription().setVolume(description.getHeight()*description.getLength()*description.getWidth());
        return order;
    }

}
