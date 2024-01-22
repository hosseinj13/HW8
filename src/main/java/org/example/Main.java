package org.example;

import menu.Menu;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();
        menu.userMenu();
        System.out.println("**********");
        menu.categoryMenu();
        System.out.println("**********");
        menu.brandMenu();
        System.out.println("**********");
        menu.productMenu();
        System.out.println("**********");
        menu.shareholderMenu();
        System.out.println("**********");
        menu.shareholderBrandMenu();
    }
}