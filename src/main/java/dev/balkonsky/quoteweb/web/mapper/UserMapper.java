package dev.balkonsky.quoteweb.web.mapper;

import dev.balkonsky.quoteweb.model.entity.User;
import dev.balkonsky.quoteweb.web.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto> {
}
