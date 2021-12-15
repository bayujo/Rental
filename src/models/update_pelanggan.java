package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

abstract public class update_pelanggan extends helper implements update_interface{

    private static final String UPDATE_NAME = "update pelanggan set nama = ? where id_pelanggan = ?;";
    private static final String UPDATE_KTP = "update pelanggan set no_ktp = ? where id_pelanggan = ?;";
    private static final String UPDATE_EMAIL = "update pelanggan set email = ? where id_pelanggan = ?;";
    private static final String UPDATE_NO_TELP = "update pelanggan set no_telp = ? where id_pelanggan = ?;";
    private static final String UPDATE_ALAMAT = "update pelanggan set alamat = ? where id_pelanggan = ?;";
    private static final String UPDATE_USERNAME = "update pelanggan set username = ? where id_pelanggan = ?;";
    private static final String UPDATE_PASSWORD = "update pelanggan set password = ? where id_pelanggan = ?;";

    public static void updateRecord(String newRecord, int id, int option) throws SQLException {
        String query = null;
        switch (option) {
            case 1:
                query = UPDATE_KTP;
                break;
            case 2:
                query = UPDATE_NAME;
                break;
            case 3:
                query = UPDATE_EMAIL;
                break;
            case 4:
                query = UPDATE_NO_TELP;
                break;
            case 5:
                query = UPDATE_ALAMAT;
                break;
            case 6:
                query = UPDATE_USERNAME;
                break;
            case 7:
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

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState:   " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message:    " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
