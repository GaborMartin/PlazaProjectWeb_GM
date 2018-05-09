package com.codecool.web.model;

import java.util.Objects;

public class Product extends AbstractModel {
    private String name;
    private long barcode;
    private String manufacturer;
    private float price;

    public Product(int id, String name, long barcode, String manufacturer, float price) {
        super(id);
        this.name = name;
        this.barcode = barcode;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public long getBarcode() {
        return barcode;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", barcode=" + barcode +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return barcode == product.barcode &&
                Float.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(manufacturer, product.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, barcode, manufacturer, price);
    }
}
