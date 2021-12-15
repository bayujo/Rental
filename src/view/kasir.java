package view;

import java.sql.SQLException;
import java.util.Scanner;
import models.*;
public class kasir extends account {

    public kasir(int id_akun) {
        super(id_akun);
    }

    public static void lihat_transaksi() {
        Scanner sc = new Scanner(System.in);
        read_transaksi.getAllUsers();
        System.out.println("\nTekan enter untuk melanjutkan");
        sc.next();
        home_kasir();
    }
    public static void edit_transaksi() {
        Scanner sc = new Scanner(System.in);
        read_transaksi.getAllUsers();
        System.out.print("\nMasukan ID data yang ingin diedit : ");
        int id = sc.nextInt();
        read_kasir.getUserById(id);
        System.out.println("\n1. Tgl ambil");


        System.out.println("2. Tgl kembali");
        System.out.println("3. Total harga");
        System.out.println("4. Jaminan");
        System.out.println("5  Denda");
        System.out.println("6. ID Mobil");
        System.out.println("6. ID Pelanggan");

        System.out.print("Pilih data yang ingin diedit    : ");
        int input3 = sc.nextInt();
        sc.nextLine();
        System.out.print("Masukan data baru               : ");
        String newData = sc.nextLine();
        try {
            update_transaksi.updateRecord(newData,id,input3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        progress_bar.ConsoleProgressBar();
        read_transaksi.getUserById(id);
        System.out.println("Data yang dipilih berhasil diedit, tekan enter untuk melanjutkan");
        sc.next();
        home_kasir();
    }
    public static void hapus_transaksi() {
        Scanner sc = new Scanner(System.in);
        read_transaksi.getAllUsers();
        System.out.print("\nMasukan ID data yang ingin dihapus : ");
        int id = sc.nextInt();
        try {
            delete_transaksi.deleteRecord(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        progress_bar.ConsoleProgressBar();
        read_transaksi.getAllUsers();
        System.out.println("\nData yang dipilih berhasil dihapus, tekan enter untuk melanjutkan");
        sc.next();
        home_kasir();
    }
    public static void lihat_pelanggan() {
        Scanner sc = new Scanner(System.in);
        read_pelanggan.getAllUsers();
        System.out.println("\nTekan enter untuk melanjutkan");
        sc.next();
        home_kasir();
    }
    public static void hapus_pelanggan() {
        Scanner sc = new Scanner(System.in);
        read_pelanggan.getAllUsers();
        System.out.print("\nMasukan ID data yang ingin dihapus : ");
        int id = sc.nextInt();
        try {
            delete_pelanggan.deleteRecord(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        progress_bar.ConsoleProgressBar();
        read_pelanggan.getAllUsers();
        System.out.println("\nData yang dipilih berhasil dihapus, tekan enter untuk melanjutkan");
        sc.next();
        home_kasir();
    }
    public static void home_kasir() {
        System.out.println("-----------------------------------------");
        System.out.println("|               MENU KASIR              |");
        System.out.println("-----------------------------------------");
        System.out.println("1. Lihat transaksi");
        System.out.println("2. Edit transaksi");
        System.out.println("3. Hapus transaksi");
        System.out.println("4. Lihat akun pelanggan");
        System.out.println("5. Hapus akun pelanggan");
        System.out.println("6. Logout");
        System.out.print("Pilih   : ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input == 1) {
            lihat_transaksi();
        } else if (input == 2) {
            edit_transaksi();
        } else if (input == 3) {
            hapus_transaksi();
        } else if (input == 4) {
            lihat_pelanggan();
        } else if (input == 5) {
            hapus_pelanggan();
        }else if (input == 6) {
            home.v_login_regis();
        } else {
            System.out.println("Input salah");
            kasir.home_kasir();

        }
    }
}
