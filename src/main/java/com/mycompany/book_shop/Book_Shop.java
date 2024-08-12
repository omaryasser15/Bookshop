/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.book_shop;

import java.util.Scanner;

/**
 *
 * @author yomar
 */
public class Book_Shop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1- Display All Book");
            System.out.println("2- Add Book");
            System.out.println("3- Update Book");
            System.out.println("4- Delete Book");
            System.out.println("5- Search Book");
            System.out.println("6- Exit");
            System.out.println("Enter Your Choise :");
            int choiseNumber = scanner.nextInt();
            switch (choiseNumber) {
                
                case 1 -> Book.displayAllBook();                    
                    
                case 2 -> Book.addBook(scanner);
                                        
                case 3 -> Book.updateBook(scanner);
                                        
                case 4 -> Book.deleteBook(scanner);
                    
                case 5 -> Book.searchBook(scanner);
                                        
                case 6 -> Book.exitFromApp();                   
                    
            }
        }
    }
}
