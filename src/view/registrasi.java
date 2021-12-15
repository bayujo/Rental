package view;

import java.sql.SQLException;
import java.util.Scanner;
import models.*;
public class registrasi {
    public static void v_registrasi() {
        System.out.println("-------------------------------------------");
        System.out.println("           Registrasi Pelanggan            ");
        System.out.println("-------------------------------------------\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("No. KTP             : ");
        String ktp = sc.next();
        sc.nextLine();
        System.out.print("\nNama                : ");
        String nama = sc.nextLine();
        System.out.print("\nEmail               : ");
        String email = sc.nextLine();
        System.out.print("\nNo. Telpon          : ");
        String no_telp = sc.nextLine();
        System.out.print("\nAlamat              : ");
        String alamat = sc.nextLine();
        System.out.print("\nUsername            : ");
        String username = sc.next();
        System.out.print("\nPassword            : ");
        String password = sc.next();
        try {
            create_pelanggan.insertRecord(nama, ktp, email, no_telp, alamat, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        read_pelanggan.getUserById(create_pelanggan.readHighestID(create_pelanggan.HIGHEST_VALUE_ID));
        System.out.println("Registrasi berhasil, tekan enter untuk kembali ke menu login");
        sc.next();
        home.v_login_regis();
    }
}

