package org.alphabet.nexorder.mapper;

import org.alphabet.nexorder.dto.UserDto;
import org.alphabet.nexorder.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UseMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
