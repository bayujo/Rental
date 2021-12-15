package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class create_kasir extends helper implements create_interface{

    private static final String HIGHEST_VALUE_ID = "select max(id_kasir) from kasir;";
    private static final String INSERT_USERS_SQL = "INSERT INTO kasir" +
            "  (id_kasir, nama, no_telp, email, alamat,  username, password) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?);";


    public static void insertRecord(String nama, String no_telp, String email, String alamat, String username, String password) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, readHighestID(HIGHEST_VALUE_ID)+1);
            preparedStatement.setString(2, nama);
            preparedStatement.setString(5, no_telp);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, alamat);
            preparedStatement.setString(6, username);
            preparedStatement.setString(7, password);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}