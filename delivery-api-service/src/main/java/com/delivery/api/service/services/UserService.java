package com.delivery.api.service.services;

import com.delivery.api.service.convertor.impl.UserConvertor;
import com.delivery.api.service.dto.user.UserRequestDTO;
import com.delivery.api.service.dto.IdRequestDTO;
import com.delivery.api.service.dto.user.UserResponseDTO;
import com.delivery.auth.config.exception.BadRequestException;
import com.delivery.auth.config.util.AuthUtil;
import com.delivery.db.entities.Role;
import com.delivery.db.entities.User;
import com.delivery.db.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserConvertor userConvertor;

    @Transactional(readOnly = true)
    public List<UserResponseDTO> getAllUsersBesideAdmin(int pageNum, int pageSize) {
        List<User> userList = userRepository.findByRoleIsNot(Role.ADMIN, PageRequest.of(pageNum, pageSize));
        return userConvertor.convertToListResponseDTO(userList);
    }

    public UserResponseDTO blockUser(IdRequestDTO idRequestDTO) {
        return setBan(idRequestDTO, true);
    }

    public UserResponseDTO unBlockUser(IdRequestDTO idRequestDTO) {
        return setBan(idRequestDTO, false);
    }


    private UserResponseDTO setBan(IdRequestDTO idRequestDTO, boolean ban) {
        User user = findById(idRequestDTO.getId());
        user.setBan(ban);
        save(user);
        return userConvertor.convertToResponseDTO(user);
    }

    @Transactional(readOnly = true)
    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("No user with this id"));
    }

    @Transactional(readOnly = true)
    public User findByLogin(String login) {
        return userRepository.findByLogin(login)
                .orElseThrow(() -> new BadRequestException("No user with this login"));
    }

    public User getCurrentUser() {
        String userLogin = AuthUtil.getCurrentUserLogin();
        return findByLogin(userLogin);
    }

    @Transactional(rollbackFor = Exception.class)
    public User save(User user) {
        return userRepository.save(user);
    }

    public void registerUser(UserRequestDTO userDTO) {
        if (isLoginNotUnique(userDTO.getLogin())) {
            throw new BadRequestException("This login already exist");
        }
        if (isEmailNotUnique(userDTO.getEmail())) {
            throw new BadRequestException("This email already exist");
        }
        if (!isRoleInValid(userDTO.getRole())) {
            throw new BadRequestException("Not valid user role");
        }
        if (passwordNotEquals(userDTO.getPassword(), userDTO.getConfirmPassword())) {
            throw new BadRequestException("passwords are not equals");
        }

        User user = userConvertor.convertFromRequestDto(userDTO);
        save(user);
    }

    private boolean isLoginNotUnique(String login) {
        return userRepository.findByLogin(login).isPresent();
    }

    private boolean isEmailNotUnique(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    private boolean isRoleInValid(String role) {
        return Arrays.stream(Role.values()).anyMatch((t) -> t.name().equals(role));
    }

    private boolean passwordNotEquals(String password, String confirmPassword) {
        return !password.equals(confirmPassword);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(IdRequestDTO idRequestDTO) {
        userRepository.deleteUserById(idRequestDTO.getId());
    }
}
