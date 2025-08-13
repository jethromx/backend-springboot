package com.core.application.mappers;


import com.core.application.dto.request.UserRequestDTO;
import com.core.application.dto.response.UserResponseDTO;
import com.core.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toUser(UserRequestDTO userDto);

    UserResponseDTO toResponseDto(User user);
}
