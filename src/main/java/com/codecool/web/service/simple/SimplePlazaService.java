package com.codecool.web.service.simple;

import com.codecool.web.dao.PlazaDao;
import com.codecool.web.model.Plaza;
import com.codecool.web.service.PlazaService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class SimplePlazaService implements PlazaService {

    PlazaDao plazaDao;

    public SimplePlazaService(PlazaDao plazaDao) {
        this.plazaDao = plazaDao;
    }

    @Override
    public List<Plaza> getAll() throws ServiceException {
        try {
            List<Plaza> plazas = plazaDao.getAll();
            if (plazas.size() == 0) {
                throw new ServiceException("There's no plaza yet!");
            }
            return plazas;
        } catch (SQLException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Plaza getPlazaById(int id) throws ServiceException {
        try {
            Plaza plaza = plazaDao.getPlazaById(id);
            if (plaza == null) {
                throw new ServiceException("There's no plaza with this ID!");
            }
            return plaza;
        } catch (SQLException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
