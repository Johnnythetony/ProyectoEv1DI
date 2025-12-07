package com.liceolapaz.dam.proyectoev1di.Mapper;

import com.liceolapaz.dam.proyectoev1di.DTO.BacklogDTO;
import com.liceolapaz.dam.proyectoev1di.Entities.Backlog;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BacklogMapper
{
    BacklogMapper INSTANCE = Mappers.getMapper(BacklogMapper.class);

    BacklogDTO DAOtoDTO(Backlog backlog );
    Backlog DTOtoDAO( BacklogDTO backlog_dto );

    void updateFromModel( BacklogDTO backlog_dto, @MappingTarget Backlog backlog );
}
