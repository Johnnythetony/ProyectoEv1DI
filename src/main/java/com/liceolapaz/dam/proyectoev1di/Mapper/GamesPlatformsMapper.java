package com.liceolapaz.dam.proyectoev1di.Mapper;

import com.liceolapaz.dam.proyectoev1di.DTO.GamesPlatformsDTO;
import com.liceolapaz.dam.proyectoev1di.Entities.GamesPlatforms;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GamesPlatformsMapper
{
    GamesPlatformsMapper INSTANCE = Mappers.getMapper(GamesPlatformsMapper.class);

    GamesPlatformsDTO DAOtoDTO(GamesPlatforms platform );
    GamesPlatforms DTOtoDAO( GamesPlatformsDTO platform_dto );

    void updateFromModel( GamesPlatformsDTO platform_dto, @MappingTarget GamesPlatforms platform );
}
