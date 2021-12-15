package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class create_supir extends helper implements create_interface{

    private static final String HIGHEST_VALUE_ID = "select max(id_supir) from supir;";
    private static final String INSERT_USERS_SQL = "INSERT INTO supir" +
            "  (id_supir, nama ,no_telp , alamat, username, password) VALUES " +
            " (?, ?, ?, ?, ?, ?);";


    public static void insertRecord(String nama, String no_telp, String alamat, String username, String password) throws SQLException {
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, readHighestID(HIGHEST_VALUE_ID)+1);
            preparedStatement.setString(2, nama);
            preparedStatement.setString(3, no_telp);
            preparedStatement.setString(4, alamat);
            preparedStatement.setString(5, username);
            preparedStatement.setString(6, password);

            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}