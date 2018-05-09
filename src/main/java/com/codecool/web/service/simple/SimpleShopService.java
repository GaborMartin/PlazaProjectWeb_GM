package com.codecool.web.service.simple;

import com.codecool.web.dao.ShopDao;
import com.codecool.web.dao.database.DatabaseShopImpl;
import com.codecool.web.model.Shop;
import com.codecool.web.service.ShopService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class SimpleShopService implements ShopService {

    ShopDao shopDao;

    public SimpleShopService(ShopDao shopDao) {
        this.shopDao = shopDao;
    }

    @Override
    public List<Shop> getAllShops() throws ServiceException {
        try {
            List<Shop> result = shopDao.getAllShops();
            if (result.size() == 0) {
                throw new ServiceException("There's no shop yet!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Shop> getAllShopsByPlazaId(int plazaId) throws ServiceException {
        try {
            List<Shop> result = shopDao.getAllShopsByPlazaId(plazaId);
            if (result.size() == 0) {
                throw new ServiceException("There's no shop for this plaza yet!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Shop getShopById(int id) throws ServiceException {
        try {
            Shop result = shopDao.getShopById(id);
            if (result == null) {
                throw new ServiceException("There's no shop with this ID!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
