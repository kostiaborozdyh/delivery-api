package com.delivery.api.service.convertor.impl;

import com.delivery.api.service.convertor.Convertable;
import com.delivery.api.service.dto.user.UserRequestDTO;
import com.delivery.api.service.dto.user.UserResponseDTO;
import com.delivery.db.entities.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserConvertor implements Convertable<User, UserRequestDTO, UserResponseDTO> {
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User convertFromRequestDto(UserRequestDTO userRequestDTO) {
        User user = mapper.map(userRequestDTO, User.class);
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        return user;
    }

    @Override
    public List<UserResponseDTO> convertToListResponseDTO(List<User> userList) {
        return mapper.map(userList, new TypeToken<List<UserResponseDTO>>() {
        }.getType());
    }

    @Override
    public UserResponseDTO convertToResponseDTO(User user) {
        return mapper.map(user, UserResponseDTO.class);
    }
}
