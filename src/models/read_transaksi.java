package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class read_transaksi extends helper implements read_interface {
    private static final String SELECT_BY_ID_USER = "select id_transaksi, tgl_ambil, tgl_kembali, total_harga, jaminan, denda, id_mobil, id_pelanggan from transaksi where id_pelanggan = ?";
    private static final String QUERY = "select id_transaksi, tgl_ambil, tgl_kembali, total_harga, jaminan, denda, id_mobil, id_pelanggan from transaksi where id_transaksi = ?";
    private static final String SELECT_ALL_QUERY = "select * from transaksi";

    public static void getUserData(int x) {
        
        

        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_USER)) {
            preparedStatement.setInt(1,x);

            
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println(String.format("|%-6s", "ID") + String.format("|%-12s", "Tgl Ambil") + String.format("|%-12s", "Tgl Kembali") + String.format("|%-10s", "Total") + String.format("|%-20s", "Jaminan") + String.format("|%-10s", "Denda") + String.format("|%-10s", "ID Mobil") + String.format("|%-12s|", "ID Pelanggan"));
            System.out.println("-----------------------------------------------------------------------------------------------------");

            
            while (rs.next()) {
                int id = rs.getInt("id_transaksi");
                String tgl_ambil = rs.getString("tgl_ambil");
                String tgl_kembali = rs.getString("tgl_kembali");
                int total_harga = rs.getInt("total_harga");
                String jaminan = rs.getString("jaminan");
                int denda = rs.getInt("denda");
                int id_mobil = rs.getInt("id_mobil");
                int id_pelanggan = rs.getInt("id_pelanggan");
                System.out.println(String.format("|%-6d", id) + String.format("|%-12s", tgl_ambil) + String.format("|%-12s", tgl_kembali) + String.format("|%-10s", total_harga) + String.format("|%-20s", jaminan) + String.format("|%-10s", denda) + String.format("|%-10s", id_mobil) + String.format("|%-12s|", id_pelanggan));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    public static void getUserById(int x) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            preparedStatement.setInt(1,x);
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println(String.format("|%-6s", "ID") + String.format("|%-12s", "Tgl Ambil") + String.format("|%-12s", "Tgl Kembali") + String.format("|%-10s", "Total") + String.format("|%-20s", "Jaminan") + String.format("|%-10s", "Denda") + String.format("|%-10s", "ID Mobil") + String.format("|%-12s|", "ID Pelanggan"));
            System.out.println("-----------------------------------------------------------------------------------------------------");

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_transaksi");
                String tgl_ambil = rs.getString("tgl_ambil");
                String tgl_kembali = rs.getString("tgl_kembali");
                int total_harga = rs.getInt("total_harga");
                String jaminan = rs.getString("jaminan");
                int denda = rs.getInt("denda");
                int id_mobil = rs.getInt("id_mobil");
                int id_pelanggan = rs.getInt("id_pelanggan");
                System.out.println(String.format("|%-6d", id) + String.format("|%-12s", tgl_ambil) + String.format("|%-12s", tgl_kembali) + String.format("|%-10s", total_harga) + String.format("|%-20s", jaminan) + String.format("|%-10s", denda) + String.format("|%-10s", id_mobil) + String.format("|%-12s|", id_pelanggan));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static void getAllUsers() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println(String.format("|%-6s", "ID") + String.format("|%-12s", "Tgl Ambil") + String.format("|%-12s", "Tgl Kembali") + String.format("|%-10s", "Total") + String.format("|%-20s", "Jaminan") + String.format("|%-10s", "Denda") + String.format("|%-10s", "ID Mobil") + String.format("|%-12s|", "ID Pelanggan"));
            System.out.println("-----------------------------------------------------------------------------------------------------");

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_transaksi");
                String tgl_ambil = rs.getString("tgl_ambil");
                String tgl_kembali = rs.getString("tgl_kembali");
                int total_harga = rs.getInt("total_harga");
                String jaminan = rs.getString("jaminan");
                int denda = rs.getInt("denda");
                int id_mobil = rs.getInt("id_mobil");
                int id_pelanggan = rs.getInt("id_pelanggan");
                System.out.println(String.format("|%-6d", id) + String.format("|%-12s", tgl_ambil) + String.format("|%-12s", tgl_kembali) + String.format("|%-10s", total_harga) + String.format("|%-20s", jaminan) + String.format("|%-10s", denda) + String.format("|%-10s", id_mobil) + String.format("|%-12s|", id_pelanggan));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}
