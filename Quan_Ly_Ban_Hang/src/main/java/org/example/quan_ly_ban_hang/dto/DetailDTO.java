package org.example.quan_ly_ban_hang.dto;

public class DetailDTO {
    private Integer id;
    private String code;
    private String name;
    private String nameClient;
    private Integer quantity;
    private Float price;
    private Float totalAmount;


    public DetailDTO() {
    }

    public DetailDTO(String name, String nameClient, Integer quantity) {
        this.name = name;
        this.nameClient = nameClient;
        this.quantity = quantity;
    }

    public DetailDTO(Integer id, String code, String name, String nameClient, Integer quantity, Float price, Float totalAmount) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.nameClient = nameClient;
        this.quantity = quantity;
        this.price = price;
        this.totalAmount = totalAmount;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }
}
