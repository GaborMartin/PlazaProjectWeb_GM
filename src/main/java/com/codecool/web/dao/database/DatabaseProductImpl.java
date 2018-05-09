package com.codecool.web.dao.database;

import com.codecool.web.dao.ProductDao;
import com.codecool.web.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseProductImpl extends AbstractDao implements ProductDao {

    DatabaseProductImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Product> getAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
             while (resultSet.next()) {
                 products.add(fetchProduct(resultSet));
             }
        }
        return products;
    }

    @Override
    public Product getProductById(int id) throws SQLException {
        String sql = "SELECT * FROM products WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchProduct(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public Product fetchProduct(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        long barcode = resultSet.getLong("barcode");
        String manufacturer = resultSet.getString("manufacturer");
        float price = resultSet.getFloat("price");
        return new Product(id, name, barcode,manufacturer, price);

    }

    @Override
    public List<Product> getAllByShopId(int shopId) throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE shop_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, shopId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    products.add(fetchProduct(resultSet));
                }
            }
        }
        return products;
    }
}
