import java.sql.*;

public class PostgreSqlExample {

    private Connection connection;

    PostgreSqlExample() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/top_sport", "postgres", "321");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void viewDataBase() {
        try {
            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            System.out.println("Reading car records...");
            System.out.printf("%-30.30s  %-30.30s %-30.30s %-30.30s %-30.30s%n", "email", "password", "nickname", "full_name", "profile_picture");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.user");
            while (resultSet.next()) {
                System.out.printf("%-30.30s  %-30.30s %-30.30s %-30.30s %-30.30s%n", resultSet.getString("email"), resultSet.getString("password"), resultSet.getString("nickname"),
                        resultSet.getString("full_name"), resultSet.getString("profile_picture"));
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}
