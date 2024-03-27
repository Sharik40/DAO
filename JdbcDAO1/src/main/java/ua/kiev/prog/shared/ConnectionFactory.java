package ua.kiev.prog.shared;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final ComboPooledDataSource dataSource = new ComboPooledDataSource();
    private static boolean inited;

    public static Connection getConnection() throws SQLException {
        initialize();
        return dataSource.getConnection();
    }

    private static void initialize() {
        if (inited) return;

        Properties props = new Properties();
        try {
            props.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties"));

            dataSource.setDriverClass(props.getProperty("db.driver"));
            dataSource.setJdbcUrl(props.getProperty("db.url"));
            dataSource.setUser(props.getProperty("db.user"));
            dataSource.setPassword(props.getProperty("db.password"));

            inited = true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
