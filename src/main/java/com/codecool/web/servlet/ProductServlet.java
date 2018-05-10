package com.codecool.web.servlet;

import com.codecool.web.dao.ProductDao;
import com.codecool.web.dao.database.DatabaseProductImpl;
import com.codecool.web.model.Product;
import com.codecool.web.service.ProductService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/protected/product")
public class ProductServlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            ProductDao productDao = new DatabaseProductImpl(connection);
            ProductService productService = new SimpleProductService(productDao);

            String id = req.getParameter("id");

            Product product = productService.getProductById(Integer.parseInt(id));

            sendMessage(resp, HttpServletResponse.SC_OK, product);
        } catch (SQLException e) {
            handleSqlError(resp,e);
        } catch (ServiceException e) {
            sendMessage(resp, HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }
    }
}
