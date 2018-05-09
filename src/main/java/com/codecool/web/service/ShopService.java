package com.codecool.web.service;

import com.codecool.web.model.Shop;
import com.codecool.web.service.exception.ServiceException;

import java.util.List;

public interface ShopService {

    public List<Shop> getAllShops() throws ServiceException;
    public List<Shop> getAllShopsByPlazaId(int plazaId) throws ServiceException;
    public Shop getShopById(int id) throws ServiceException;

}
