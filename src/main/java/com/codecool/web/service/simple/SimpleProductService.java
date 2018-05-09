package com.codecool.web.service.simple;

import com.codecool.web.dao.ProductDao;
import com.codecool.web.model.Product;
import com.codecool.web.service.ProductService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class SimpleProductService implements ProductService {
    ProductDao productDao;

    public SimpleProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() throws ServiceException {
        try {
            List<Product> products = productDao.getAll();
            if (products.size() == 0) {
                throw new ServiceException("There's no any product yet!");
            }
            return products;
        } catch (SQLException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Product getProductById(int id) throws ServiceException {
        try {
            Product product = productDao.getProductById(id);
            if (product == null) {
                throw new ServiceException("There's no product with this ID!");
            }
            return product;
        } catch (SQLException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Product> getAllByShopId(int shopId) throws ServiceException {
        try {
            List<Product> products = productDao.getAllByShopId(shopId);
            if (products.size() == 0) {
                throw new ServiceException("There's no any product for this shop!");
            }
            return products;
        } catch (SQLException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
