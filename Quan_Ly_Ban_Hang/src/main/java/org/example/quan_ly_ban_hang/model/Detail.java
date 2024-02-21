package org.example.quan_ly_ban_hang.model;

public class Detail {
    private Integer id;
    private Client client;
    private Product product;

    public Detail() {
    }

    public Detail(Integer id, Client client, Product product) {
        this.id = id;
        this.client = client;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
