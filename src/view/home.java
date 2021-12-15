package view;

import java.util.Scanner;

public class home {
    public static void v_login_regis() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------------------------");
        System.out.println("|    Selamat Datang di Rental Barokah   |");
        System.out.println("-----------------------------------------");
        System.out.println("      Silakan Login atau Registrasi      ");
        System.out.println("terlebih dahulu untuk mulai menyewa mobil");
        System.out.println("1. Login");
        System.out.println("2. Registrasi");
        System.out.print(  "\nPilih  :   ");
        int input = sc.nextInt();
            if (input == 1) {
                login.v_pilihan_login();
        }
            else if (input == 2) {
                registrasi.v_registrasi();
        }
    }
}