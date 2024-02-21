package org.example.quan_ly_ban_hang.service.client;

import org.example.quan_ly_ban_hang.model.Client;

import java.util.List;

public interface IClientService {
    List<Client> getAllClient();

    void addClient(Client client);

    void updateClient(Client client);

    Client findById(Integer id);

    void moveById(Integer id);

    List<Client> searchByName(String name);

    List<Client> arrangeByName(String arrange);
}
