package com.example.converter.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer count = 0;

    //    @OneToMany
//    @JoinColumn(name = "category_id")
//    private List<Convertation> convertations;
//
//    public List<Convertation> getConvertations() {
//        return convertations;
//    }
//
//    public void setConvertations(List<Convertation> convertations) {
//        this.convertations = convertations;
//    }

    public Category(String title) {
        this.title = title;
    }

    public Category() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
