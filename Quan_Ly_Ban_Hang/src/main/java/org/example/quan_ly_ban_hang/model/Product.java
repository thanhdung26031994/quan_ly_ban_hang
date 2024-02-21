package org.example.quan_ly_ban_hang.model;

public class Product {
    private Integer id;
    private String code;
    private String name;
    private Float price;
    private Integer quantity;

    public Product() {
    }

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;

    }

    public Product(Integer id, String code, String name, Float price, Integer quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
