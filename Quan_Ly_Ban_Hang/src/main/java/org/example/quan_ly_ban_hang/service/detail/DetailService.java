package org.example.quan_ly_ban_hang.service.detail;

import org.example.quan_ly_ban_hang.config.DBConnection;
import org.example.quan_ly_ban_hang.dto.DetailDTO;
import org.example.quan_ly_ban_hang.model.Detail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetailService implements IDetailService{
    @Override
    public List<DetailDTO> getAllDetail() {
        List<DetailDTO> details = new ArrayList<>();
        Connection connection;
        CallableStatement statement = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareCall("call get_all_cthd();");
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                 Integer id = rs.getInt("stt");
                 String code = rs.getString("masp");
                 String name = rs.getString("ten");
                 Integer quantity = rs.getInt("soluong");
                 Float price = rs.getFloat("giaban");
                 Float totalAmount = rs.getFloat("tien");
                 details.add(new DetailDTO(id, code, name, quantity, price, totalAmount));
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
        return details;
    }
}
