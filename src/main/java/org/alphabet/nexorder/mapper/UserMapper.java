package org.alphabet.nexorder.mapper;

import org.alphabet.nexorder.dto.UserDto;
import org.alphabet.nexorder.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    List<UserDto> toDto(List<User> users);
    User toEntity(UserDto userDto);

}
