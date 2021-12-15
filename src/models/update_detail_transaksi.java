package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

abstract public class update_detail_transaksi extends helper implements update_interface {

    private static final String UPDATE_ID_TRANSAKSI = "update detail_transaksi set id_transaksi = ? where id_detail = ?;";
    private static final String UPDATE_ID_SUPIR = "update detail_transaksi set id_supir = ? where id_detail = ?;";

    public static void updateRecord(int newRecord, int id, int option) throws SQLException {
        String query = null;
        switch (option) {
            case 1:
                query = UPDATE_ID_TRANSAKSI;
                break;
            case 2:
                query = UPDATE_ID_SUPIR;
                break;
        }
        System.out.println(query);
        try (Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, newRecord);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}