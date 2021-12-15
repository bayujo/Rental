package models;

import java.sql.*;

public abstract class read_pelanggan extends helper {
    private static final String QUERY = "select id_pelanggan, no_ktp, nama, email, no_telp, alamat, username, password from pelanggan where id_pelanggan = ?";
    private static final String SELECT_ALL_QUERY = "select * from pelanggan";

    public static void getUserById(int x) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            preparedStatement.setInt(1,x);
            
            
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(String.format("|%-6s", "ID") + String.format("|%-20s","NO KTP") + String.format("|%-30s", "Nama") + String.format("|%-13s", "No. Telpon") + String.format("|%-30s", "Email") + String.format("|%-50s", "Alamat") + String.format("|%-15s", "Username") + String.format("|%-15s|", "Password"));
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            
            while (rs.next()) {
                int id = rs.getInt("id_pelanggan");
                String ktp = rs.getString("no_ktp");
                String nama = rs.getString("nama");
                String email = rs.getString("email");
                String no_telp = rs.getString("no_telp");
                String alamat = rs.getString("alamat");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(String.format("|%-6d", id) + String.format("|%-20s",ktp) + String.format("|%-30s", nama) + String.format("|%-13s", no_telp) + String.format("|%-30s", email) + String.format("|%-50s", alamat) + String.format("|%-15s", username) + String.format("|%-15s|", password));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static void getAllUsers() {
        
        

        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            
            
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(String.format("|%-6s", "ID") + String.format("|%-20s","NO KTP") + String.format("|%-30s", "Nama") + String.format("|%-13s", "No. Telpon") + String.format("|%-30s", "Email") + String.format("|%-50s", "Alamat") + String.format("|%-15s", "Username") + String.format("|%-15s|", "Password"));
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            
            while (rs.next()) {
                int id = rs.getInt("id_pelanggan");
                String ktp = rs.getString("no_ktp");
                String nama = rs.getString("nama");
                String email = rs.getString("email");
                String no_telp = rs.getString("no_telp");
                String alamat = rs.getString("alamat");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(String.format("|%-6d", id) + String.format("|%-20s",ktp) + String.format("|%-30s", nama) + String.format("|%-13s", no_telp) + String.format("|%-30s", email) + String.format("|%-50s", alamat) + String.format("|%-15s", username) + String.format("|%-15s|", password));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}
