package com.codecool.web.dao;

import com.codecool.web.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ProductDao {

    public List<Product> getAll() throws SQLException;
    public Product getProductById(int id) throws SQLException;
    public List<Product> getAllByShopId(int shopId) throws SQLException;
    public Product fetchProduct(ResultSet resultSet) throws SQLException;
}
