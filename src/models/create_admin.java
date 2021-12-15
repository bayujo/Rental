package models;

import java.sql.*;

public abstract class create_admin extends helper implements create_interface {

    private static final String HIGHEST_VALUE_ID = "select max(id_admin) from admin;";
    private static final String INSERT_USERS_SQL = "INSERT INTO admin" +
            "  (id_admin, nama, email, alamat, no_telp, username, password) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?);";

    public static void insertRecord(String nama, String email, String alamat, String no_telp, String username, String password) throws SQLException {
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, readHighestID(HIGHEST_VALUE_ID)+1);
            preparedStatement.setString(2, nama);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, alamat);
            preparedStatement.setString(5, no_telp);
            preparedStatement.setString(6, username);
            preparedStatement.setString(7, password);

            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}