package org.example.quan_ly_ban_hang.service.client;

import org.example.quan_ly_ban_hang.config.DBConnection;
import org.example.quan_ly_ban_hang.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService implements IClientService{
    @Override
    public List<Client> getAllClient() {
        List<Client> clients = new ArrayList<>();
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("select * from khach_hang;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("ten");
                String phone = rs.getString("sdt");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                clients.add(new Client(id, name, phone, email, address));
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
        return clients;
    }

    @Override
    public void addClient(Client client) {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("insert into khach_hang(ten, sdt, email, dia_chi) values (?,?,?,?);");
            statement.setString(1, client.getName());
            statement.setString(2, client.getPhone());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void updateClient(Client client) {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("update khach_hang set ten = ?, sdt = ?, email = ?, dia_chi = ? where id = ?;");
            statement.setString(1, client.getName());
            statement.setString(2, client.getPhone());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getAddress());
            statement.setInt(5, client.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Client findById(Integer id) {
        Client client = null;
        Connection connection;
        PreparedStatement statement =null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("select ten, sdt, email, dia_chi from khach_hang where id = ?;");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String name = rs.getString("ten");
                String phone = rs.getString("sdt");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                client = new Client(name, phone, email, address);
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
        return client;
    }

    @Override
    public void moveById(Integer id) {
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("delete from khach_hang where id = ?;");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
