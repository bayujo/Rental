package view;
import java.sql.SQLException;
import java.util.Scanner;

import models.*;
public class admin extends account {

    public admin(int id_akun) {
        super(id_akun);
    }
    public static void kelola_akun_kasir() {
        System.out.println("1. Tambah kasir");
        System.out.println("2. Lihat kasir");
        System.out.println("3. Edit kasir");
        System.out.println("4. Hapus kasir");
        System.out.println("5. Kembali");
        System.out.print("Pilih   : ");
        Scanner sc = new Scanner(System.in);
        int input2 = sc.nextInt();
        sc.nextLine();
        if (input2 == 1) {
            System.out.println("--------------Tambah Kasir---------------\n");
            System.out.print("Nama         : ");
            String nama = sc.nextLine();
            System.out.print("\nNomor Telpon : ");
            String no_telp = sc.next();
            System.out.print("\nEmail        : ");
            String email = sc.next();
            sc.nextLine();
            System.out.print("\nAlamat       : ");
            String alamat = sc.nextLine();
            System.out.print("\nUsername     : ");
            String username = sc.next();
            System.out.print("\nPassword     : ");
            String password = sc.next();
            try {
                create_kasir.insertRecord(nama, no_telp, email, alamat, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            progress_bar.ConsoleProgressBar();
            read_kasir.getAllUsers();
            System.out.println("Data berhasil ditambahkan, tekan enter untuk melanjutkan");
            sc.next();
            kelola_akun_kasir();
        } else if (input2 == 2) {
            read_kasir.getAllUsers();
            System.out.println("\nTekan enter untuk melanjutkan");
            sc.next();
            kelola_akun_kasir();
        } else if (input2 == 3) {
            read_kasir.getAllUsers();
            System.out.print("\nMasukan ID data yang ingin diedit : ");
            int id = sc.nextInt();
            read_kasir.getUserById(id);
            System.out.println("\n1. Nama");
            System.out.println("2. No. Telpon");
            System.out.println("3. Email");
            System.out.println("4. Alamat");
            System.out.println("5  Username");
            System.out.println("6. Password");
            System.out.print("Pilih data yang ingin diedit    : ");
            int input3 = sc.nextInt();
            sc.nextLine();
            System.out.print("Masukan data baru               : ");
            String newData = sc.nextLine();
            try {
                update_kasir.updateRecord(newData,id,input3);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            progress_bar.ConsoleProgressBar();
            read_kasir.getUserById(id);
            System.out.println("Data yang dipilih berhasil diedit, tekan enter untuk melanjutkan");
            sc.next();
            kelola_akun_kasir();

        } else if (input2 == 4) {
            read_kasir.getAllUsers();
            System.out.print("\nMasukan ID data yang ingin dihapus : ");
            int id = sc.nextInt();
            try {
                delete_kasir.deleteRecord(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            progress_bar.ConsoleProgressBar();
            read_kasir.getAllUsers();
            System.out.println("\nData yang dipilih berhasil dihapus, tekan enter untuk melanjutkan");
            sc.next();
            kelola_akun_kasir();
        } else if (input2 == 5) {
            admin.home_admin();
        } else {
            System.out.println("Input salah");
            kelola_akun_supir();
        }
    }
    public static void kelola_akun_supir() {
        System.out.println("1. Tambah supir");
        System.out.println("2. Lihat supir");
        System.out.println("3. Edit supir");
        System.out.println("4. Hapus supir");
        System.out.println("5. Kembali");
        System.out.print("Pilih   : ");
        Scanner sc = new Scanner(System.in);
        int input2 = sc.nextInt();
        if (input2 == 1) {
            System.out.println("--------------Tambah Supir---------------\n");
            System.out.print("Nama         : ");
            String nama = sc.next();
            System.out.print("\nNomor Telpon : ");
            String no_telp = sc.next();
            System.out.print("\nAlamat       : ");
            String alamat = sc.next();
            System.out.print("\nUsername     : ");
            String username = sc.next();
            System.out.print("\nPassword     : ");
            String password = sc.next();
            try {
                create_supir.insertRecord(nama, no_telp, alamat, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            progress_bar.ConsoleProgressBar();
            read_supir.getAllUsers();
            System.out.println("Data berhasil ditambahkan, tekan enter untuk melanjutkan");
            sc.next();
            kelola_akun_supir();
        } else if (input2 == 2) {
            read_supir.getAllUsers();
            System.out.println("\nTekan enter untuk melanjutkan");
            sc.next();
            kelola_akun_supir();
        } else if (input2 == 3) {
            read_supir.getAllUsers();
            System.out.print("\nMasukan ID data yang ingin diedit : ");
            int id = sc.nextInt();
            read_supir.getUserById(id);
            System.out.println("\n1. Nama");
            System.out.println("2. No. Telpon");
            System.out.println("3. Email");
            System.out.println("4. Alamat");
            System.out.println("5  Username");
            System.out.println("6. Password");
            System.out.print("Pilih data yang ingin diedit    : ");
            int input3 = sc.nextInt();
            sc.nextLine();
            System.out.print("Masukan data baru               : ");
            String newData = sc.nextLine();
            try {
                update_supir.updateRecord(newData,id,input3);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            progress_bar.ConsoleProgressBar();
            read_supir.getUserById(id);
            System.out.println("Data yang dipilih berhasil diedit, tekan enter untuk melanjutkan");
            sc.next();
            kelola_akun_supir();

        } else if (input2 == 4) {
            read_supir.getAllUsers();
            System.out.print("\nMasukan ID data yang ingin dihapus : ");
            int id = sc.nextInt();
            try {
                delete_supir.deleteRecord(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            progress_bar.ConsoleProgressBar();
            read_supir.getAllUsers();
            System.out.println("\nData yang dipilih berhasil dihapus, tekan enter untuk melanjutkan");
            sc.next();
            kelola_akun_supir();
        } else if (input2 == 5) {
            admin.home_admin();
        } else {
            System.out.println("Input salah");
            kelola_akun_supir();
        }
    }
    public static void kelola_mobil() {
        System.out.println("1. Tambah mobil");
        System.out.println("2. Lihat mobil");
        System.out.println("3. Edit mobil");
        System.out.println("4. Hapus mobil");
        System.out.println("5. Kembali");
        System.out.print("Pilih   : ");
        Scanner sc = new Scanner(System.in);

        int input2 = sc.nextInt();
        if (input2 == 1) {
            System.out.println("--------------Tambah Mobil---------------\n");
            System.out.print("Nomor mobil    : ");
            String plat = sc.next();
            System.out.print("\nMerk           : ");
            String merk = sc.next();
            System.out.print("\nNama mobil   : ");
            String nama = sc.next();
            System.out.print("\nHarga        : ");
            int harga = sc.nextInt();
            System.out.print("\nID Jenis     : ");
            int id_jenis = sc.nextInt();

            try {
                create_mobil.insertRecord(plat, merk, nama, harga, id_jenis);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            progress_bar.ConsoleProgressBar();
            read_mobil.getAllUsers();
            System.out.println("Data berhasil ditambahkan, tekan enter untuk melanjutkan");
            sc.next();
            kelola_mobil();
        } else if (input2 == 2) {
            read_mobil.getAllUsers();
            System.out.println("\nTekan enter untuk melanjutkan");
            sc.next();
            kelola_mobil();
        } else if (input2 == 3) {
            read_mobil.getAllUsers();
            System.out.print("\nMasukan ID data yang ingin diedit : ");
            int id = sc.nextInt();
            read_mobil.getUserById(id);
            System.out.println("\n1. No. Mobil");
            System.out.println("2. Merk");
            System.out.println("3. Nama_mobil");
            System.out.println("4. Harga");
            System.out.println("5  ID Jenis mobil");
            System.out.print("Pilih data yang ingin diedit    : ");
            int input3 = sc.nextInt();
            sc.nextLine();
            System.out.print("Masukan data baru               : ");
            String newData = sc.nextLine();
            try {
                update_mobil.updateRecord(newData,id,input3);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            progress_bar.ConsoleProgressBar();
            read_mobil.getUserById(id);
            System.out.println("Data yang dipilih berhasil diedit, tekan enter untuk melanjutkan");
            sc.next();
            kelola_mobil();

        } else if (input2 == 4) {
            read_mobil.getAllUsers();
            System.out.print("\nMasukan ID data yang ingin dihapus : ");
            int id = sc.nextInt();
            try {
                delete_mobil.deleteRecord(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            progress_bar.ConsoleProgressBar();
            read_mobil.getAllUsers();
            System.out.println("\nData yang dipilih berhasil dihapus, tekan enter untuk melanjutkan");
            sc.next();
            kelola_mobil();
        } else if (input2 == 5) {
            admin.home_admin();
        } else {
            System.out.println("Input salah");
            kelola_mobil();
        }
    }
    public static void home_admin() {
        System.out.println("-----------------------------------------");
        System.out.println("|           MENU ADMINISTRATOR          |");
        System.out.println("-----------------------------------------");
        System.out.println("1. Kelola akun kasir");
        System.out.println("2. Kelola akun supir");
        System.out.println("3. Kelola kendaraan");
        System.out.println("4. Logout");
        System.out.print("Pilih   : ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input == 1) {
            kelola_akun_kasir();
        } else if (input == 2) {
            kelola_akun_supir();
        } else if (input == 3) {
            kelola_mobil();
        } else if (input == 4) {
            home.v_login_regis();
        } else {
            System.out.println("Input salah");
            admin.home_admin();

        }
    }
}
