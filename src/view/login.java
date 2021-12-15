package view;
import models.*;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class login {
    private static int login_session;
    public static void setLogin_session(int ID) {
        login_session = ID;
    }
    public static int getLogin_session() {
        return login_session;
    }
    public static void showFormLogin(String role) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Username:  ");
        String username = sc.next();
        System.out.print("Password:  ");
        String password = sc.next();
        if (Objects.equals(role, "admin")) {
            if (validateLogin.findID_admin(username, password) != 0) {
                setLogin_session(validateLogin.findID_admin(username, password));
                admin admin = new admin(login.getLogin_session());
                admin.home_admin();
            } else {
                home.v_login_regis();
            }
        } else if (Objects.equals(role, "pelanggan")) {
            if (validateLogin.findID_pelanggan(username, password) != 0) {
                setLogin_session(validateLogin.findID_pelanggan(username, password));
                pelanggan pelanggan = new pelanggan(login.getLogin_session());
                pelanggan.home_pelanggan();
            } else {
                home.v_login_regis();
            }
        } else if (Objects.equals(role, "kasir")) {
            if (validateLogin.findID_kasir(username, password) != 0) {
                setLogin_session(validateLogin.findID_kasir(username, password));
                kasir kasir = new kasir(login.getLogin_session());
                kasir.home_kasir();
            } else {
                home.v_login_regis();
            }
        }
    }
    public static void v_pilihan_login() {
        Scanner sc = new Scanner(System.in);
        int pilihan = 0;
        System.out.println("1. Admin");
        System.out.println("2. Pelanggan");
        System.out.println("3. Kasir");
        System.out.print("\nPilih peran  : ");
        try {
            pilihan = sc.nextInt();
        }
        catch (InputMismatchException i) {
            i.printStackTrace();
        }
        if (pilihan == 1) {
            showFormLogin("admin");
        }
        else if (pilihan == 2) {
            showFormLogin("pelanggan");
        }
        else if (pilihan == 3) {
            showFormLogin("kasir");
        } else {
            System.out.println("Input salah");
            v_pilihan_login();
        }
    }
}
