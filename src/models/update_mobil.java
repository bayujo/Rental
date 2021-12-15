package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

abstract public class update_mobil extends helper implements update_interface{

    private static final String UPDATE_NO_MOBIL = "update mobil set no_mobil = ? where id_mobil = ?;";
    private static final String UPDATE_MERK = "update mobil set merk = ? where id_mobil = ?;";
    private static final String UPDATE_NAMA_MOBIL = "update mobil set nama_mobil = ? where id_mobil = ?;";
    private static final String UPDATE_HARGA = "update mobil set harga = ? where id_mobil = ?;";
    private static final String UPDATE_ID_JENIS = "update mobil set id_jenis = ? where id_mobil = ?;";

    public static void updateRecord(String newRecord, int id, int option) throws SQLException {
        String query = null;
        switch (option) {
            case 1:
                query = UPDATE_NO_MOBIL;
                break;
            case 2:
                query = UPDATE_MERK;
                break;
            case 3:
                query = UPDATE_NAMA_MOBIL;
                break;
            case 4:
                query = UPDATE_HARGA;
                break;
            case 5:
                query = UPDATE_ID_JENIS;
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