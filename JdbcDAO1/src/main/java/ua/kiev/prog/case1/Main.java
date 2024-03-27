package ua.kiev.prog.case1;

import ua.kiev.prog.shared.Client;
import ua.kiev.prog.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

// DB > JDBC (H) > DAO > App

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection();
             Scanner sc = new Scanner(System.in))
        {
            ClientDAO dao = new ClientDAOImpl(conn);
            dao.createTable();

            while (true) {
                System.out.println("1: add client");
                System.out.println("2: view clients");
                System.out.println("3: view count");
                System.out.print("-> ");

                String s = sc.nextLine();
                switch (s) {
                    case "1":
                        System.out.print("Enter client name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter client age: ");
                        String sAge = sc.nextLine();
                        int age = Integer.parseInt(sAge);

                        dao.addClient(name, age);
                        break;
                    case "2":
                        List<Client> list = dao.getAll();
                        for (Client client : list) {
                            System.out.println(client);
                        }
                        break;
                    case "3":
                        System.out.println("Count: " + dao.count());
                        break;
                    default:
                        return;
                }
            }
        }
    }
}
