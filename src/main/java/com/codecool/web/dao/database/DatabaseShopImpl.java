package com.codecool.web.dao.database;

import com.codecool.web.dao.ShopDao;
import com.codecool.web.model.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseShopImpl extends AbstractDao implements ShopDao {

    public DatabaseShopImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Shop> getAllShops() throws SQLException {
        List<Shop> shops = new ArrayList<>();
        String sql = "SELECT * FROM shops";
        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                shops.add(fetchShop(resultSet));
            }

        }
        return shops;
    }

    @Override
    public List<Shop> getAllShopsByPlazaId(int plazaId) throws SQLException {
        List<Shop> shops = new ArrayList<>();
        String sql = "SELECT * FROM shops WHERE plaza_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, plazaId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    shops.add(fetchShop(resultSet));
                }
            }
        }
        return shops;
    }

    @Override
    public Shop getShopById(int id) throws SQLException {
        String sql = "SELECT * FROM shops WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchShop(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public Shop fetchShop(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String ownerName = resultSet.getString("owner_name");
        return new Shop(id,name,ownerName);
    }
}
