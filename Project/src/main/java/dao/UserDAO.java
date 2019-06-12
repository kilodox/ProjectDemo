package dao;

import model.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDAO {
   private static Connection connection;

   static {
       try {
           connection = DBConnection.getInstance().getConnection();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
    public void addUser(User user) throws SQLException {
        connection.createStatement().executeUpdate("INSERT INTO users values (" +
                "'"+user.getEmail()+"', "+user.getPassword()+"," +
                " '"+user.getNickName()+"', '"+user.getName()+"', '"+user.getPicture()+"')");
    }

}
