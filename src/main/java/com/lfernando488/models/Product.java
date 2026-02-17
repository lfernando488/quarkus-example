package com.lfernando488.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Product extends PanacheEntity {

    //PanacheEntity gera id automaticamente
    public String name;
    public Double price;

}
