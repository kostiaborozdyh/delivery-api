package com.delivery.api.service.convertors;

import com.delivery.api.service.dto.user.UserResponseDTO;
import com.delivery.db.entities.Order;
import com.delivery.db.entities.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserConvertor {
    private final ModelMapper mapper;

    public List<UserResponseDTO> convertToListResponseDTO(List<User> userList) {
        return mapper.map(userList, new TypeToken<List<UserResponseDTO>>() {
        }.getType());
    }

    public UserResponseDTO convertToResponseDTO(User user) {
        return mapper.map(user,UserResponseDTO.class);
    }
}
