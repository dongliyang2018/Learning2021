package com.dong.model;

import java.io.Serializable;

public class Book implements Serializable {

    private Long id;
    private String name;
    private String vendor;

    public Book() { }

    public Book(String name, String vendor) {
        this.name = name;
        this.vendor = vendor;
    }

    public Book(Long id, String name, String vendor) {
        this.id = id;
        this.name = name;
        this.vendor = vendor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vendor='" + vendor + '\'' +
                '}';
    }
}
