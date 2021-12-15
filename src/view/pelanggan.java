package view;

import java.sql.SQLException;
import java.util.Scanner;
import models.*;
public class pelanggan extends account{

    public pelanggan(int id_akun) {
        super(id_akun);
    }

    public static void sewa_kendaraan() {
        Scanner sc = new Scanner(System.in);
        read_mobil.getAllUsers();
        System.out.print("Masukan ID mobil yang ingin disewa  : ");
        int id = sc.nextInt();
        read_mobil.getUserById(id);
        System.out.print("\nTanggal ambil (YYYY-MM-DD)         1  : ");
        String tanggal_ambil = sc.next();
        System.out.print("\nLama sewa (dalam hari)               : ");
        int lama_sewa = sc.nextInt();
        int total = lama_sewa*read_mobil.getHarga_sewa();
        sc.nextLine();
        System.out.print("\nJaminan                              : ");
        String jaminan = sc.nextLine();

        try {
            create_transaksi.insertRecord(tanggal_ambil,"null",total,jaminan,0,read_mobil.getId_mobil(),login.getLogin_session());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        progress_bar.ConsoleProgressBar();
        read_transaksi.getUserData(login.getLogin_session());
        System.out.println("Data berhasil ditambahkan, tekan enter untuk melanjutkan");
        sc.next();
        pelanggan.home_pelanggan();
    }
    public static void lihat_sewa() {
        Scanner sc = new Scanner(System.in);
        read_transaksi.getUserData(login.getLogin_session());
        System.out.println("\nTekan enter untuk melanjutkan");
        sc.next();
        home_pelanggan();
    }
    public static void lihat_profil() {
        Scanner sc = new Scanner(System.in);
        read_pelanggan.getUserById(login.getLogin_session());
        System.out.println("\nTekan enter untuk melanjutkan");
        sc.next();
        home_pelanggan();
    }
    public static void home_pelanggan() {
        System.out.println("-----------------------------------------");
        System.out.println("|            Selamat Datang             |");
        System.out.println("|          di Rental Barokah            |");
        System.out.println("-----------------------------------------");
        System.out.println("1. Sewa kendaraan");
        System.out.println("2. Lihat sewa");
        System.out.println("3. Lihat profil");
        System.out.println("4. Logout");
        System.out.print("Pilih   : ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input == 1) {
            sewa_kendaraan();
        } else if (input == 2) {
            lihat_sewa();
        } else if (input == 3) {
            lihat_profil();
        } else if (input == 4) {
            home.v_login_regis();
        } else {
            System.out.println("Input salah");
            home_pelanggan();
        }
    }
}
