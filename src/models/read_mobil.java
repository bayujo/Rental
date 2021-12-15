package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class read_mobil extends helper {
    private static int id_mobil = 0;
    private static int harga_sewa = 0;
    private static final String QUERY = "select id_mobil,  no_mobil , merk, nama_mobil, harga, id_jenis from mobil where id_mobil = ?";
    private static final String SELECT_ALL_QUERY = "select * from mobil";

    public static int getHarga_sewa() {
        return harga_sewa;
    }

    public static int getId_mobil() {
        return id_mobil;
    }

    public static void getUserById(int x) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            preparedStatement.setInt(1,x);
            
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println(String.format("|%-6s", "ID") + String.format("|%-12s", "No. Mobil") + String.format("|%-20s", "Merk") + String.format("|%-30s", "Nama") + String.format("|%-10s", "Harga") + String.format("|%-10s|", "ID Jenis"));
            System.out.println("-----------------------------------------------------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id_mobil");
                String no_mobil = rs.getString("no_mobil");
                String merk = rs.getString("merk");
                String nama_mobil = rs.getString("nama_mobil");
                int harga = rs.getInt("harga");
                int id_jenis = rs.getInt("id_jenis");
                harga_sewa = harga;
                id_mobil = id;
                System.out.println(String.format("|%-6s", id) + String.format("|%-12s", no_mobil) + String.format("|%-20s", merk) + String.format("|%-30s", nama_mobil) + String.format("|%-10s", harga) + String.format("|%-10s|", id_jenis));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static void getAllUsers() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println(String.format("|%-6s", "ID") + String.format("|%-12s", "No. Mobil") + String.format("|%-20s", "Merk") + String.format("|%-30s", "Nama") + String.format("|%-10s", "Harga") + String.format("|%-10s|", "ID Jenis"));
            System.out.println("-----------------------------------------------------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id_mobil");
                String no_mobil = rs.getString("no_mobil");
                String merk = rs.getString("merk");
                String nama_mobil = rs.getString("nama_mobil");
                int harga = rs.getInt("harga");
                int id_jenis = rs.getInt("id_jenis");
                System.out.println(String.format("|%-6s", id) + String.format("|%-12s", no_mobil) + String.format("|%-20s", merk) + String.format("|%-30s", nama_mobil) + String.format("|%-10s", harga) + String.format("|%-10s|", id_jenis));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}
