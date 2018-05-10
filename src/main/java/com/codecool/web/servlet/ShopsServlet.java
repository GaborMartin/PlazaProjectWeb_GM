package com.codecool.web.servlet;

import com.codecool.web.dao.ShopDao;
import com.codecool.web.dao.database.DatabaseShopImpl;
import com.codecool.web.model.Shop;
import com.codecool.web.service.ShopService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleShopService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/protected/shops")
public class ShopsServlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (Connection connection = getConnection(req.getServletContext())) {
            ShopDao shopDao = new DatabaseShopImpl(connection);
            ShopService shopService = new SimpleShopService(shopDao);

            String plazaId = req.getParameter("id");

            List<Shop> shops = shopService.getAllShopsByPlazaId(Integer.parseInt(plazaId));

            sendMessage(resp, HttpServletResponse.SC_OK, shops);
        } catch (SQLException e) {
            handleSqlError(resp, e);
        } catch (ServiceException e) {
            sendMessage(resp, HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }
    }
}
