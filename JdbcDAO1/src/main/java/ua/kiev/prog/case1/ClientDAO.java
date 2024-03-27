package ua.kiev.prog.case1;

import ua.kiev.prog.shared.Client;

import java.util.List;

// CRUD
public interface ClientDAO {
    void createTable();
    void addClient(String name, int age);
    List<Client> getAll();
    long count();
}
