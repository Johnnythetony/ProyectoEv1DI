package com.liceolapaz.dam.proyectoev1di.Mapper;

import com.liceolapaz.dam.proyectoev1di.DTO.RegisterUserDTO;
import com.liceolapaz.dam.proyectoev1di.Entities.User;
import com.liceolapaz.dam.proyectoev1di.DTO.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper
{
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    UserDTO DAOtoDTO( User user );
    User DTOtoDAO( UserDTO user_dto );
    User RegisterDTOtoDAO (RegisterUserDTO reg_user_dto);

    void updateFromModel( UserDTO user_dto, @MappingTarget User user );
}
