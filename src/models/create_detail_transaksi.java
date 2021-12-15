package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class create_detail_transaksi extends helper implements create_interface{

    private static final String HIGHEST_VALUE_ID = "select max(id_detail) from detail_transaksi;";
    private static final String INSERT_USERS_SQL = "INSERT INTO detail_transaksi" +
            "  (id_detail, id_transaksi, id_supir) VALUES " +
            " (?, ?, ?);";


    public static void insertRecord(int HIGHEST_VALUE_ID, String nama) throws SQLException {
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, HIGHEST_VALUE_ID+1);
            preparedStatement.setString(2, nama);

            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}