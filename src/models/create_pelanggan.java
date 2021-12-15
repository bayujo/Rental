package models;

import java.sql.*;

public abstract class create_pelanggan extends helper implements create_interface {

    public static final String HIGHEST_VALUE_ID = "select max(id_pelanggan) from pelanggan;";
    private static final String INSERT_USERS_SQL = "INSERT INTO pelanggan" +
            "  (id_pelanggan, no_ktp, nama, email, no_telp, alamat, username, password) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?);";


    public static void insertRecord(String no_ktp, String nama, String email, String no_telp, String alamat, String username, String password) throws SQLException {
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1,readHighestID(HIGHEST_VALUE_ID)+1);
            preparedStatement.setString(2, no_ktp);
            preparedStatement.setString(3, nama);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, no_telp);
            preparedStatement.setString(6, alamat);
            preparedStatement.setString(7, username);
            preparedStatement.setString(8, password);


            

            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            printSQLException(e);
        }
    }
}
