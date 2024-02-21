package org.example.quan_ly_ban_hang.service.invoice;

import org.example.quan_ly_ban_hang.model.Invoice;

import java.util.List;

public interface IInvoiceService {
    List<Invoice> getAllInvoice();

    void updateInvoice(Invoice invoice);

    void addInvoice(Invoice invoice);

    Invoice findById(Integer id);

    void moveById(Integer id);
}
