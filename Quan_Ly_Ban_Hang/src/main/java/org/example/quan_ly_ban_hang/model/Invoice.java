package org.example.quan_ly_ban_hang.model;

import java.util.Date;

public class Invoice {
    private Integer id;
    private Date sale;
    private Float total;
    private Client client;

    public Invoice() {
    }

    public Invoice(Integer id, Date sale, Float total, Client client) {
        this.id = id;
        this.sale = sale;
        this.total = total;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSale() {
        return sale;
    }

    public void setSale(Date sale) {
        this.sale = sale;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
