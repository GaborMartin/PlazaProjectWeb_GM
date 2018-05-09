package com.codecool.web.model;

import java.util.Objects;

public class Shop extends AbstractModel {
    private String name;
    private String ownerName;


    public Shop(int id, String name, String ownerName) {
        super(id);
        this.name = name;
        this.ownerName = ownerName;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shop shop = (Shop) o;
        return Objects.equals(name, shop.name) &&
                Objects.equals(ownerName, shop.ownerName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name, ownerName);
    }
}
