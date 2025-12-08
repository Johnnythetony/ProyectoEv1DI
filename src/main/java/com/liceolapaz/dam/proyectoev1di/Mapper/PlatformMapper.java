package com.liceolapaz.dam.proyectoev1di.Mapper;

import com.liceolapaz.dam.proyectoev1di.DTO.PlatformDTO;
import com.liceolapaz.dam.proyectoev1di.Entities.Platform;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlatformMapper
{
    PlatformMapper INSTANCE = Mappers.getMapper(PlatformMapper.class);

    PlatformDTO DAOtoDTO(Platform platform );
    Platform DTOtoDAO( PlatformDTO platform_dto );

    void updateFromModel( PlatformDTO platform_dto, @MappingTarget Platform platform );
}
