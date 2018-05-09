package com.codecool.web.dao;

import com.codecool.web.model.Shop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ShopDao {

    public List<Shop> getAllShops() throws SQLException;
    public List<Shop> getAllShopsByPlazaId(int plazaId) throws SQLException;
    public Shop getShopById(int id) throws SQLException;
    public Shop fetchShop(ResultSet resultSet) throws SQLException;
}
