package com.codecool.web.dao;

import com.codecool.web.model.Plaza;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface PlazaDao {

    public List<Plaza> getAll() throws SQLException;
    public Plaza getPlazaById(int id) throws SQLException;
    public Plaza addPlaza(String name) throws SQLException;
    public Plaza fetchPlaza(ResultSet resultSet) throws SQLException;

}
