package com.delivery.api.server.controllers;

import com.delivery.api.service.dto.user.UserRequestDTO;
import com.delivery.api.service.dto.user.UserResponseDTO;
import com.delivery.api.service.services.UserService;
import com.delivery.db.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {
    private final UserService userService;

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(
            @RequestParam(required = false, defaultValue ="${pagination.default.pageSize}") Integer pageSize,
            @RequestParam(required = false, defaultValue = "${pagination.default.pageNum}") Integer pageNum) {
        return new ResponseEntity<>(userService.getAllUsersBesideAdmin(pageNum,pageSize), HttpStatus.OK);
    }

    @PostMapping("/blockUser")
    public ResponseEntity<UserResponseDTO> blockUser(@RequestBody UserRequestDTO userRequestDTO) {
        return new ResponseEntity<>(userService.blockUser(userRequestDTO), HttpStatus.OK);
    }

    @PostMapping("/unblockUser")
    public ResponseEntity<UserResponseDTO> unBlockUser(@RequestBody UserRequestDTO userRequestDTO) {
        return new ResponseEntity<>(userService.unBlockUser(userRequestDTO), HttpStatus.OK);
    }

    @PostMapping("/deleteUser")
    public ResponseEntity<Void> deleteUser(@RequestBody UserRequestDTO userRequestDTO) {
        userService.deleteUser(userRequestDTO);
        return ResponseEntity.ok().build();
    }
}
