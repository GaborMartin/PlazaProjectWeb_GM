package com.codecool.web.dao.database;

import com.codecool.web.dao.PlazaDao;
import com.codecool.web.model.Plaza;
import com.codecool.web.service.exception.ServiceException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabasePlazaImpl extends AbstractDao implements PlazaDao  {

    public DatabasePlazaImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Plaza> getAll() throws SQLException {
        List<Plaza> plazas = new ArrayList<>();
        String sql = "SELECT * FROM plazas";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                plazas.add(fetchPlaza(resultSet));
            }
        }
        return plazas;
    }

    @Override
    public Plaza getPlazaById(int id) throws SQLException {
        String sql = "SELECT * FROM plazas WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchPlaza(resultSet);
                }
            }
        }
        return null;
    }

    public Plaza addPlaza(String name) throws SQLException {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO plazas (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            executeInsert(statement);
            int id = fetchGeneratedId(statement);
            return new Plaza(id, name);
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(autoCommit);
        }
    }

    @Override
    public void updatePlazaById(int id, String newName) throws SQLException {
        if (newName == null || newName.equals("")) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql = "UPDATE public.plazas SET name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, newName);
            statement.setInt(2, id);
            executeInsert(statement);
            connection.commit();
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(autoCommit);
        }
    }

    @Override
    public void deletePlazaById(int id) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql = "DELETE FROM public.plazas WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            executeInsert(statement);
            connection.commit();
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(autoCommit);
        }
    }

    @Override
    public Plaza fetchPlaza(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        return new Plaza(id, name);
    }
}
