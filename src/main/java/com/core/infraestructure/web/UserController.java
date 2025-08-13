package com.core.infraestructure.web;


import com.core.application.dto.request.UserRequestDTO;
import com.core.application.dto.response.UserResponseDTO;
import com.core.application.mappers.UserMapper;
import com.core.application.usecases.UserRegistrationCase;
import com.core.domain.model.User;

import jakarta.validation.Valid;

import io.swagger.annotations.Api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

//@Api( tags= { "Users" })
@Slf4j
@RestController
@RequestMapping(value = "${api-prefix}/users")
@RequiredArgsConstructor
public class UserController {


    private final UserRegistrationCase registerUserCasePort;
    private final UserMapper mapper;


    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody UserRequestDTO userDTO) {
        log.info("Registrando usuario: {}", userDTO);

        User user = mapper.toUser(userDTO);
        user  = registerUserCasePort.registerUser(user);
        UserResponseDTO userResponseDTO = mapper.toResponseDto(user);

        log.info("Usuario registrado exitosamente: {}", userResponseDTO);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }
}
