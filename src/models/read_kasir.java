package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class read_kasir extends helper {
    private static final String QUERY = "select id_kasir, nama, no_telp, email, alamat, username, password from kasir where id_kasir = ?";
    private static final String SELECT_ALL_QUERY = "select * from kasir";

    public static void getUserById(int x) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            preparedStatement.setInt(1,x);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(String.format("|%-6s", "ID") + String.format("|%-30s", "Nama") + String.format("|%-13s", "No. Telpon") + String.format("|%-30s", "Email") + String.format("|%-50s", "Alamat") + String.format("|%-15s", "Username") + String.format("|%-15s|", "Password"));
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            while (rs.next()) {
                int id = rs.getInt("id_kasir");
                String nama = rs.getString("nama");
                String no_telp = rs.getString("no_telp");
                String email = rs.getString("email");
                String alamat = rs.getString("alamat");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(String.format("|%-6d", id) + String.format("|%-30s", nama) + String.format("|%-13s", no_telp) + String.format("|%-30s", email) + String.format("|%-50s", alamat) + String.format("|%-15s", username) + String.format("|%-15s|", password));
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static void getAllUsers() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(String.format("|%-6s", "ID") + String.format("|%-30s", "Nama") + String.format("|%-13s", "No. Telpon") + String.format("|%-30s", "Email") + String.format("|%-50s", "Alamat") + String.format("|%-15s", "Username") + String.format("|%-15s|", "Password"));
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            while (rs.next()) {
                int id = rs.getInt("id_kasir");
                String nama = rs.getString("nama");
                String no_telp = rs.getString("no_telp");
                String email = rs.getString("email");
                String alamat = rs.getString("alamat");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(String.format("|%-6d", id) + String.format("|%-30s", nama) + String.format("|%-13s", no_telp) + String.format("|%-30s", email) + String.format("|%-50s", alamat) + String.format("|%-15s", username) + String.format("|%-15s|", password));
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}
