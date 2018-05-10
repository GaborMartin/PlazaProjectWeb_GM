package com.codecool.web.servlet;

import com.codecool.web.dao.ProductDao;
import com.codecool.web.dao.database.DatabaseProductImpl;
import com.codecool.web.model.Product;
import com.codecool.web.service.ProductService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleProductService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/protected/products")
public class ProductsServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            ProductDao productDao = new DatabaseProductImpl(connection);
            ProductService productService = new SimpleProductService(productDao);

            String id = req.getParameter("id");

            List<Product> products = productService.getAllByShopId(Integer.parseInt(id));

            sendMessage(resp, HttpServletResponse.SC_OK, products);
        } catch (SQLException e) {
            handleSqlError(resp, e);
        } catch (ServiceException e) {
            sendMessage(resp, HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }
    }
}
