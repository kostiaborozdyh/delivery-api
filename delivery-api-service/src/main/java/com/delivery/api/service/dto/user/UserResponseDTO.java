package com.delivery.api.service.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private Integer id;
    private String login;
    private String firstName;
    private String lastName;
    private Boolean ban;
    private String email;
}
