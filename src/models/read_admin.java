package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class read_admin extends helper implements read_interface {
    private static final String QUERY = "select id_admin, nama, email, alamat, no_telp, username, password from admin where id_admin = ?";
    private static final String SELECT_ALL_QUERY = "select * from admin";

    public static void getUserById(int x) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            preparedStatement.setInt(1,x);
            
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_admin");
                String nama = rs.getString("nama");
                String email = rs.getString("email");
                String alamat = rs.getString("alamat");
                String no_telp = rs.getString("no_telp");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(id + "," + nama + "," + email + "," + alamat + "," + no_telp + "," + username + "," + password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static void getAllUsers() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_admin");
                String nama = rs.getString("nama");
                String email = rs.getString("email");
                String alamat = rs.getString("alamat");
                String no_telp = rs.getString("no_telp");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(id + "," + nama + "," + email + "," + alamat + "," + no_telp + "," + username + "," + password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}
