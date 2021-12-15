package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class create_jenis extends helper implements create_interface{

    private static final String HIGHEST_VALUE_ID = "select max(id_jenis) from jenis;";
    private static final String INSERT_USERS_SQL = "INSERT INTO jenis" +
            "  (id_jenis, nama) VALUES " +
            " (?, ?);";


    public static void insertRecord(String nama) throws SQLException {
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, readHighestID(HIGHEST_VALUE_ID)+1);
            preparedStatement.setString(2, nama);

            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}