package com.codecool.web.service;

import com.codecool.web.model.Plaza;
import com.codecool.web.service.exception.ServiceException;

import java.util.List;

public interface PlazaService {

    public List<Plaza> getAll() throws ServiceException;
    public Plaza getPlazaById(int id) throws ServiceException;

}
