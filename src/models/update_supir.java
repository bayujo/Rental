package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

abstract public class update_supir extends helper implements update_interface{

    private static final String UPDATE_NAME = "update supir set nama = ? where id_supir = ?;";
    private static final String UPDATE_NO_TELP = "update supir set no_telp = ? where id_supir = ?;";
    private static final String UPDATE_ALAMAT = "update supir set alamat = ? where id_supir = ?;";
    private static final String UPDATE_USERNAME = "update supir set username = ? where id_supir = ?;";
    private static final String UPDATE_PASSWORD = "update supir set password = ? where id_supir = ?;";

    public static void updateRecord(String newRecord, int id, int option) throws SQLException {
        String query = null;
        switch (option) {
            case 1:
                query = UPDATE_NAME;
                break;
            case 2:
                query = UPDATE_NO_TELP;
                break;
            case 3:
                query = UPDATE_ALAMAT;
                break;
            case 4:
                query = UPDATE_USERNAME;
                break;
            case 5:
                query = UPDATE_PASSWORD;
                break;
        }
        System.out.println(query);
        try (Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newRecord);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}