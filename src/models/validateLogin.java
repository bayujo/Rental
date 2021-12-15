package models;

import view.home;

import java.sql.*;

public abstract class validateLogin extends helper {
    public static int findID_admin(String username, String pw) {
        String QUERY = "select id_admin from admin where username = ? AND password = ?";
        int foundID = 0;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pw);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            foundID = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foundID;
    }

    public static int findID_pelanggan(String username, String pw) {
        String QUERY = "select id_pelanggan from pelanggan where username = ? AND password = ?";

        int foundID = 0;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pw);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            foundID = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foundID;
    }
    public static int findID_kasir(String username, String pw) {
        String QUERY = "select id_kasir from kasir where username = ? AND password = ?";

        int foundID = 0;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pw);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            foundID = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foundID;
    }
}