package org.example.quan_ly_ban_hang.model;

public class Detail {
    private Integer id;
    private Integer quantityDetail;
    private Invoice invoice;
    private Product product;



    public Detail(Integer id, Integer quantityDetail, Invoice invoice, Product product) {
        this.id = id;
        this.quantityDetail = quantityDetail;
        this.invoice = invoice;
        this.product = product;
    }

    public Detail(Invoice invoice, Product product) {
        this.invoice = invoice;
        this.product = product;
    }

    public Detail(Integer id, Invoice invoice, Product product) {
        this.id = id;
        this.invoice = invoice;
        this.product = product;
    }

    public Integer getQuantityDetail() {
        return quantityDetail;
    }

    public void setQuantityDetail(Integer quantityDetail) {
        this.quantityDetail = quantityDetail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
