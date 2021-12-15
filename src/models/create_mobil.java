package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class create_mobil extends helper implements create_interface{

    private static final String HIGHEST_VALUE_ID = "select max(id_mobil) from mobil;";
    private static final String INSERT_USERS_SQL = "INSERT INTO mobil" +
            "  (id_mobil, no_mobil , merk, nama_mobil, harga, id_jenis) VALUES " +
            " (?, ?, ?, ?, ?, ?);";

    public static void insertRecord(String no_mobil, String merk, String nama_mobil, int harga, int id_jenis) throws SQLException {
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, readHighestID(HIGHEST_VALUE_ID)+1);
            preparedStatement.setString(2, no_mobil);
            preparedStatement.setString(3, merk);
            preparedStatement.setString(4, nama_mobil);
            preparedStatement.setInt(5, harga);
            preparedStatement.setInt(6, id_jenis);

            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}