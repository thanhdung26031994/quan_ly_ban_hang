package org.example.quan_ly_ban_hang.service.invoice;

import org.example.quan_ly_ban_hang.config.DBConnection;
import org.example.quan_ly_ban_hang.model.Client;
import org.example.quan_ly_ban_hang.model.Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class InvoiceService implements IInvoiceService{
    @Override
    public List<Invoice> getAllInvoice() {
        List<Invoice> invoiceList = new ArrayList<>();
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("select hoa_don.*, khach_hang.ten, khach_hang.sdt\n" +
                    "from hoa_don\n" +
                    "join khach_hang on khach_hang.id = hoa_don.id_kh;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                Date sale = rs.getDate("ngay_ban");
                Float total = rs.getFloat("tong_tien");
                Integer idClient = rs.getInt("id_kh");
                String name = rs.getString("ten");
                String phone = rs.getString("sdt");
                Client client = new Client(idClient, name, phone);
                invoiceList.add(new Invoice(id, sale, total, client));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return invoiceList;
    }
}
