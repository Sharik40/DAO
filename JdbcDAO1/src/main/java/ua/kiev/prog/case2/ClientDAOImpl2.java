package ua.kiev.prog.case2;

import ua.kiev.prog.shared.Client;

import java.sql.Connection;

public class ClientDAOImpl2 extends AbstractDAO<Client> {
    public ClientDAOImpl2(Connection conn, String table) {
        super(conn, table);
    }
}
