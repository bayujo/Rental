package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class read_detail_transaksi extends helper implements read_interface {
    private static final String QUERY = "select id_detail, id_transaksi, id_supir from detail_transaksi where id_detail = ?";
    private static final String SELECT_ALL_QUERY = "select * from detail_transaksi";

    public static void getUserById(int x) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            preparedStatement.setInt(1,x);
            
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id_detail = rs.getInt("id_detail");
                int id_transaksi = rs.getInt("id_transaksi");
                int id_supir = rs.getInt("id_supir");
                System.out.println(id_detail + "," + id_transaksi + "," + id_supir);
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
                int id_detail = rs.getInt("id_detail");
                int id_transaksi = rs.getInt("id_transaksi");
                int id_supir = rs.getInt("id_supir");
                System.out.println(id_detail + "," + id_transaksi + "," + id_supir);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}
