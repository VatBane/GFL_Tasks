package com.example.converter.entities;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name = "convertation")
public class Convertation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "from_quantity")
    private String fromQuantity;

    @Column(name = "to_quantity")
    private String toQuantity;
    private float multiplier;

    @Column(name = "category_id")
    private Integer categoryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromQuantity() {
        return fromQuantity;
    }

    public void setFromQuantity(String from_quantity) {
        this.fromQuantity = from_quantity;
    }

    public String getToQuantity() {
        return toQuantity;
    }

    public void setToQuantity(String to_quantity) {
        this.toQuantity = to_quantity;
    }

    public float getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(float multiplier) {
        this.multiplier = multiplier;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
