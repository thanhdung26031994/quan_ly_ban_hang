package org.example.quan_ly_ban_hang.dto;

import org.example.quan_ly_ban_hang.model.Invoice;

public class DetailCreate {
    private Integer idInvoice;
    private Integer idProduct;
    private Integer quantity;
    public DetailCreate() {
    }

    public DetailCreate(Integer idInvoice, Integer idProduct, Integer quantity) {
        this.idInvoice = idInvoice;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public Integer getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(Integer idInvoice) {
        this.idInvoice = idInvoice;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
