package com.codecool.web.servlet;

import com.codecool.web.dao.PlazaDao;
import com.codecool.web.dao.database.DatabasePlazaImpl;
import com.codecool.web.model.Plaza;
import com.codecool.web.service.PlazaService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimplePlazaService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/protected/plazas")
public class PlazasServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            PlazaDao plazaDao = new DatabasePlazaImpl(connection);
            PlazaService plazaService = new SimplePlazaService(plazaDao);

            List<Plaza> plazas = plazaService.getAll();

            sendMessage(resp, HttpServletResponse.SC_OK, plazas);
        } catch (SQLException e) {
            handleSqlError(resp, e);
        } catch (ServiceException e) {
            sendMessage(resp, HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            PlazaDao plazaDao = new DatabasePlazaImpl(connection);
            PlazaService plazaService = new SimplePlazaService(plazaDao);

            String plazaName = req.getParameter("name");

            Plaza newPlaza = plazaService.addNewPlaza(plazaName);

            sendMessage(resp,HttpServletResponse.SC_OK, newPlaza);
        } catch (SQLException e) {
            handleSqlError(resp, e);
        } catch (ServiceException e) {
            sendMessage(resp, HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            PlazaDao plazaDao = new DatabasePlazaImpl(connection);
            PlazaService plazaService = new SimplePlazaService(plazaDao);

            String id = req.getParameter("id");

            plazaService.deletePlazaById(Integer.parseInt(id));

            sendMessage(resp, 200, "Plaza has been deleted!");
        } catch (SQLException e) {
            handleSqlError(resp, e);
        } catch (ServiceException e) {
            sendMessage(resp, HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }
    }
}
