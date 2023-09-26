package com.phearun.needhelpAPI.mapper;

import com.phearun.needhelpAPI.config.security.AuthUser;
import com.phearun.needhelpAPI.dto.UsersDTO;
import com.phearun.needhelpAPI.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsersMapper {
    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);
    User toEntity(UsersDTO dto);
    UsersDTO toDTO(User entity);

   // UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    AuthUser toAuthUser(User user);
}
