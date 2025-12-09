package com.liceolapaz.dam.proyectoev1di.Mapper;

import com.liceolapaz.dam.proyectoev1di.DTO.PrivateVideogameDTO;
import com.liceolapaz.dam.proyectoev1di.DTO.VideogameDTO;
import com.liceolapaz.dam.proyectoev1di.Entities.Videogame;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VideogameMapper
{
    VideogameMapper INSTANCE = Mappers.getMapper( VideogameMapper.class );

    Videogame DTOtoDAO( VideogameDTO videogame_dto );
    VideogameDTO DAOtoDTO( Videogame videogame );
    Videogame privateDTOtoDAO( PrivateVideogameDTO videogame_dto );
    PrivateVideogameDTO DAOtoPrivateDTO( Videogame videogame );

    void updateFromModel( VideogameDTO videogame_dto, @MappingTarget Videogame videogame );
}
