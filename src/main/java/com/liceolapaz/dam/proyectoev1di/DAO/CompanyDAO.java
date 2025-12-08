package com.liceolapaz.dam.proyectoev1di.DAO;

import com.liceolapaz.dam.proyectoev1di.DTO.CompanyDTO;

public interface CompanyDAO
{
    void createCompany(CompanyDTO backlog);
    void updateCompany(CompanyDTO backlog);
    void deleteCompany(CompanyDTO backlog);


    CompanyDTO getCompany(String companyname);
}
