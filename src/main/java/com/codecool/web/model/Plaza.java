package com.codecool.web.model;

import java.util.Objects;

public class Plaza extends AbstractModel {
    private String name;

    public Plaza(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Plaza plaza = (Plaza) o;
        return Objects.equals(name, plaza.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "Plaza{" +
                "name='" + name + '\'' +
                '}';
    }
}
