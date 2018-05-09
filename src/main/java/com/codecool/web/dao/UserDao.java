package com.codecool.web.dao;

import com.codecool.web.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDao {

    public User findByEmail(String email) throws SQLException;
    public User fetchUser(ResultSet resultSet) throws SQLException;

}
