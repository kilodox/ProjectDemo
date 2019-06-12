package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private final Connection connection;
    private static DBConnection instance = null;

    private DBConnection() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/top_sport", "postgres", "321");

    }

    public static synchronized DBConnection getInstance()throws SQLException{
        if(instance == null){
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
