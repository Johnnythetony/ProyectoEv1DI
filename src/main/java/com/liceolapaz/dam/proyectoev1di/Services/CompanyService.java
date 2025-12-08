package com.liceolapaz.dam.proyectoev1di.Services;

import com.liceolapaz.dam.proyectoev1di.DAO.CompanyDAO;
import com.liceolapaz.dam.proyectoev1di.DBConnectivity.DBConnection;
import com.liceolapaz.dam.proyectoev1di.DTO.CompanyDTO;
import com.liceolapaz.dam.proyectoev1di.Entities.Company;
import com.liceolapaz.dam.proyectoev1di.Entities.Videogame;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;

public class CompanyService extends DBConnection implements CompanyDAO
{

    @Override
    public void createCompany(CompanyDTO backlog)
    {

    }

    @Override
    public void updateCompany(CompanyDTO backlog)
    {

    }

    @Override
    public void deleteCompany(CompanyDTO backlog)
    {

    }

    @Override
    public CompanyDTO getCompany(String companyname)
    {
        return null;
    }

    public ArrayList<String> getCompanies()
    {
        ArrayList<String> companies;

        initTransaction();

        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<String> cq = cb.createQuery(String.class);

        Root<Company> gameRoot = cq.from(Company.class);

        cq.select(gameRoot.get("nombre"));

        cq.distinct(true);

        companies = (ArrayList<String>) getSession().createQuery(cq).getResultList();

        commitTransaction();

        return companies;
    }
}
