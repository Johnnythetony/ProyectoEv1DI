package com.liceolapaz.dam.proyectoev1di.Mapper;

import com.liceolapaz.dam.proyectoev1di.DTO.CompanyDTO;
import com.liceolapaz.dam.proyectoev1di.Entities.Company;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper
{
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    CompanyDTO DAOtoDTO(Company company );
    Company DTOtoDAO( CompanyDTO company_dto );

    void updateFromModel( CompanyDTO company_dto, @MappingTarget Company company );
}
