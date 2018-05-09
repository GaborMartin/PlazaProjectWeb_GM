package com.codecool.web.service;

import com.codecool.web.model.Product;
import com.codecool.web.service.exception.ServiceException;

import java.util.List;

public interface ProductService {

    public List<Product> getAll() throws ServiceException;
    public Product getProductById(int id) throws ServiceException;
    public List<Product> getAllByShopId(int shopId) throws ServiceException;

}
