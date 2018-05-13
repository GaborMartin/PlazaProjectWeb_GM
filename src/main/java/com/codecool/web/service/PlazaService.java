package com.codecool.web.service;

import com.codecool.web.model.Plaza;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface PlazaService {

    public List<Plaza> getAll() throws ServiceException, SQLException;
    public Plaza getPlazaById(int id) throws ServiceException, SQLException;
    public Plaza addNewPlaza(String name) throws ServiceException, SQLException;
    public void modifyPlazaById(int id, String name) throws ServiceException, SQLException;
    public void deletePlazaById(int id) throws ServiceException, SQLException;

}
