package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

abstract public class update_transaksi extends helper implements update_interface{

    private static final String UPDATE_TGL_AMBIL = "update transaksi set tgl_ambil = ? where id_transaksi = ?;";
    private static final String UPDATE_TGL_KEMBALI = "update transaksi set tgl_kembali = ? where id_transaksi = ?;";
    private static final String UPDATE_TOTAL_HARGA = "update transaksi set total_harga = ? where id_transaksi = ?;";
    private static final String UPDATE_JAMINAN = "update transaksi set jaminan = ? where id_transaksi = ?;";
    private static final String UPDATE_DENDA = "update transaksi set denda = ? where id_transaksi = ?;";
    private static final String UPDATE_ID_MOBIL = "update transaksi set id_mobil = ? where id_transaksi = ?;";
    private static final String UPDATE_ID_PELANGGAN = "update transaksi set id_pelanggan = ? where id_transaksi = ?;";
    private static final String UPDATE_ID_KASIR = "update transaksi set id_kasir = ? where id_transaksi = ?;";

    public static void updateRecord(String newRecord, int id, int option) throws SQLException {
        String query = null;
        switch (option) {
            case 1:
                query = UPDATE_TGL_AMBIL;
                break;
            case 2:
                query = UPDATE_TGL_KEMBALI;
                break;
            case 3:
                query = UPDATE_TOTAL_HARGA;
                break;
            case 4:
                query = UPDATE_JAMINAN;
                break;
            case 5:
                query = UPDATE_DENDA;
                break;
            case 6:
                query = UPDATE_ID_MOBIL;
                break;
            case 7:
                query = UPDATE_ID_PELANGGAN;
                break;
            case 8:
                query = UPDATE_ID_KASIR;
                break;

        }
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