package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class read_jenis extends helper {
    private static final String QUERY = "select id_jenis, nama from jenis where id_jenis = ?";
    private static final String SELECT_ALL_QUERY = "select * from jenis";

    public static void getUserById(int x) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            preparedStatement.setInt(1,x);
            
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_jenis");
                String nama = rs.getString("nama");
                System.out.println(id + "," + nama);
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
                int id = rs.getInt("id_jenis");
                String nama = rs.getString("nama");
                System.out.println(id + "," + nama);
            }
        } catch (SQLException e) {
            printSQLException(e);

        }
    }
}
