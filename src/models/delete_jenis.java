package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class delete_jenis extends helper implements delete_interface{
    private static final String DELETE_RECORDS = "delete from jenis where id_jenis = ?;";

    public static void deleteRecord(int id) throws SQLException {
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_RECORDS);) {
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}