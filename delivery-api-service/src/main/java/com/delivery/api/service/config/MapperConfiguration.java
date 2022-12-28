package com.delivery.api.service.config;

import com.delivery.api.service.dto.order.OrderResponseDTO;
import com.delivery.api.service.dto.review.ReviewResponseDTO;
import com.delivery.db.entities.Order;
import com.delivery.db.entities.Review;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.config.Configuration.AccessLevel;

@Configuration
public class MapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
        OrderDTOConfig(modelMapper);
        ReviewDTOConfig(modelMapper);
        return modelMapper;
    }

    private void OrderDTOConfig(ModelMapper modelMapper) {
        TypeMap<Order, OrderResponseDTO> propertyMapper = modelMapper.createTypeMap(Order.class, OrderResponseDTO.class);
        propertyMapper.addMappings(mapper -> mapper.map(src -> src.getUser().getLogin(), OrderResponseDTO::setUserLogin));
    }

    private void ReviewDTOConfig(ModelMapper modelMapper) {
        TypeMap<Review, ReviewResponseDTO> propertyMapper = modelMapper.createTypeMap(Review.class, ReviewResponseDTO.class);
        propertyMapper.addMappings(mapper -> mapper.map(src -> src.getUser().getFirstName(), ReviewResponseDTO::setUserFirstName));
    }

}
