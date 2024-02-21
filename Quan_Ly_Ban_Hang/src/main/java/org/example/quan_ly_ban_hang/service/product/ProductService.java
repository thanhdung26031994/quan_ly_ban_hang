package org.example.quan_ly_ban_hang.service.product;

import org.example.quan_ly_ban_hang.config.DBConnection;
import org.example.quan_ly_ban_hang.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductService implements IProductService {
    @Override
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("select * from san_pham;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                 Integer id = rs.getInt("id");
                 String code = rs.getString("ma");
                 String name = rs.getString("ten");
                 Float price = rs.getFloat("gia");
                 Integer quantity = rs.getInt("so_luong");
                 products.add(new Product(id, code,name,price, quantity));
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
        return products;
    }
}
