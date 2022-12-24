package com.delivery.api.service.services;

import com.delivery.api.service.convertors.UserConvertor;
import com.delivery.api.service.dto.user.UserRequestDTO;
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

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserConvertor userConvertor;
    private final AuthUtil authUtil;

    @Transactional(readOnly = true)
    public List<UserResponseDTO> getAllUsersBesideAdmin(int pageNum, int pageSize) {
        List<User> userList = userRepository.findByRoleIsNot(Role.ADMIN, PageRequest.of(pageNum, pageSize));
        return userConvertor.convertToListResponseDTO(userList);
    }

    public UserResponseDTO blockUser(UserRequestDTO userRequestDTO) {
        return setBan(userRequestDTO, true);
    }

    public UserResponseDTO unBlockUser(UserRequestDTO userRequestDTO) {
        return setBan(userRequestDTO, false);
    }


    private UserResponseDTO setBan(UserRequestDTO userRequestDTO, boolean ban) {
        User user = findById(userRequestDTO.getId());
        user.setBan(ban);
        save(user);
        return userConvertor.convertToResponseDTO(user);
    }

    @Transactional(readOnly = true)
    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("NO_USER_WITH_THIS_ID"));
    }
    @Transactional(readOnly = true)
    public User findByLogin(String login) {
        return userRepository.findByLogin(login)
                .orElseThrow(() -> new BadRequestException("NO_USER_WITH_THIS_LOGIN"));
    }

    public User getCurrentUser(){
        String userLogin = authUtil.getCurrentUserLogin();
        return findByLogin(userLogin);
    }
    @Transactional(rollbackFor = Exception.class)
    public User save(User user){
        return userRepository.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(UserRequestDTO userRequestDTO) {
        userRepository.deleteUserById(userRequestDTO.getId());
    }
}
