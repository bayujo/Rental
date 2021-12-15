package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public abstract class create_transaksi extends helper implements create_interface{

    private static final String HIGHEST_VALUE_ID = "select max(id_transaksi) from transaksi;";
    private static final String INSERT_USERS_SQL = "INSERT INTO transaksi" +
            "  (id_transaksi, tgl_ambil, tgl_kembali, total_harga, jaminan, denda, id_mobil, id_pelanggan) VALUES " +
            " ( ?, ?, ?, ?, ?, ?, ?, ?);";

    public static void insertRecord(String tgl_ambil, String tgl_kembali, int total_harga, String jaminan, int denda, int id_mobil, int id_pelanggan) throws SQLException {
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, readHighestID(HIGHEST_VALUE_ID)+1);
            preparedStatement.setString(2, tgl_ambil);
            preparedStatement.setString(3, tgl_kembali);
            preparedStatement.setInt(4, total_harga);
            preparedStatement.setString(5, jaminan);
            preparedStatement.setInt(6, denda);
            preparedStatement.setInt(7, id_mobil);
            preparedStatement.setInt(8, id_pelanggan);

            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}