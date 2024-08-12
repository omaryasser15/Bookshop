/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.book_shop;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yomar
 */
public class Book {
    
    static ArrayList<Book> bookList = new ArrayList();
    
    double price;
    String name;
    String author;
    
    public Book() {
    }
    
    public Book(int prise, String name, String author) {
        this.price = prise;
        this.name = name;
        this.author = author;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public static void displayAllBook() {
        ArrayList<Book> listBook = Book.bookList;
        if (listBook.isEmpty()) {
            System.out.println("There Is No Books !!");
        } else {
            for (Book book : listBook) {
                System.out.println("Name           Author           Price");
                System.out.println(book.getName() + "              " + book.getAuthor()
                        + "               " + book.getPrice());
            }
        }
    }
    
    public static void addBook(Scanner scanner) {
        System.out.println("Enter The Count Of Book");
        int count = scanner.nextInt();
        if (count < 0) {
            System.out.println("Wrong Enter, The Count Must > 0");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println("Enter Book " + (i + 1) + " Name :");
                String bookName = scanner.next();
                System.out.println("Enter Book " + (i + 1) + " Author :");
                String bookAuthor = scanner.next();
                System.out.println("Enter Book " + (i + 1) + " Price :");
                int bookPrice = scanner.nextInt();
                Book b = new Book();
                b.setName(bookName);
                b.setAuthor(bookAuthor);
                b.setPrice(bookPrice);
                Book.bookList.add(b);
                
            }
            
        }
    }
    
    static void updateBook(Scanner scanner) {
        boolean isMenu = true;
        while (isMenu) {
            System.out.println("------ Update Menu ------");
            System.out.println("1- Update Book Name");
            System.out.println("2- Update Book Auther");
            System.out.println("3- Update Book Price");
            System.out.println("4- Back To Main Menu");
            System.out.println("5- Exit");
            System.out.println("Enter Your Choise :");
            int choise = scanner.nextInt();
            switch (choise) {
                case 1 -> {
                    System.out.println("Enter Book Name :");
                    String bookName = scanner.next();
                    Book oldBook = Book.getBookByName(bookName);
                    Book newBook = Book.getBookByName(bookName);
                    if (oldBook == null) {
                        System.out.println("No Book With This Name !");
                    } else {
                        System.out.println("Enter Book New Name :");
                        String newName = scanner.next();
                        newBook.setName(newName);
                        if (Book.updateBooks(newBook, oldBook)) {
                            System.out.println("Updated Successfully");
                        } else {
                            System.out.println("Updated Fails");
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Enter Book Name :");
                    String bookName1 = scanner.next();
                    Book oldBook1 = Book.getBookByName(bookName1);
                    Book newBook1 = Book.getBookByName(bookName1);
                    if (oldBook1 == null) {
                        System.out.println("No Book With This Name !");
                    } else {
                        System.out.println("Enter Book New Author :");
                        String newAuthor = scanner.next();
                        newBook1.setAuthor(newAuthor);
                        if (Book.updateBooks(newBook1, oldBook1)) {
                            System.out.println("Updated Successfully");
                        } else {
                            System.out.println("Updated Fails");
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Enter Book Name :");
                    String bookName2 = scanner.next();
                    Book oldBook2 = Book.getBookByName(bookName2);
                    Book newBook2 = Book.getBookByName(bookName2);
                    if (oldBook2 == null) {
                        System.out.println("No Book With This Name !");
                    } else {
                        System.out.println("Enter Book New Price :");
                        int newPrice = scanner.nextInt();
                        newBook2.setPrice(newPrice);
                        if (Book.updateBooks(newBook2, oldBook2)) {
                            System.out.println("Updated Successfully");
                        } else {
                            System.out.println("Updated Fails");
                        }
                    }
                }
                case 4 -> isMenu = false;
                case 5 -> exitFromApp();
            }
            
        }
    }
    
    public static Book getBookByName(String name) {
        for (Book book : bookList) {
            if (book.name.equals(name)) {
                return book;
            }
        }
        return null;
    }
    
    public static boolean updateBooks(Book newBook, Book oldBook) {
        if (!bookList.isEmpty()) {
            int index = -1;
            for (int i = 0; i < bookList.size(); i++) {
                if (bookList.get(i).getName().equals(oldBook.getName())) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                bookList.get(index).setName(newBook.getName());
                bookList.get(index).setAuthor(newBook.getAuthor());
                bookList.get(index).setPrice(newBook.getPrice());
                return true;
            }
        }
        return false;
    }
    
    static void deleteBook(Scanner scanner) {
        System.out.println("Enter Book Name :");
        String bookName = scanner.next();
        Book book = Book.getBookByName(bookName);
        if (book == null) {
            System.out.println("No Books Founded !!");
        } else {
            if (Book.deletedBook(book)) {
                System.out.println("Deleted Successfully");
            } else {
                System.out.println("Deleted Fails");
            }
        }
    }
    
    static boolean deletedBook(Book book) {
        if (!bookList.isEmpty()) {
            bookList.remove(book);
            return true;
        }
        return false;
    }
    
    static void searchBook(Scanner scanner) {
        System.out.println("Enter Book ( Name / Author ) :");
        String bookName = scanner.next();
        Book book = Book.getBook(bookName, bookName);
        if (book == null) {
            System.out.println("Book Not Founded !!");
        } else {
            if (Book.searchBooks(book)) {
                System.out.println("Book Founded");
                System.out.println("Name           Author           Price");
                System.out.println(book.getName() + "              " + book.getAuthor()
                        + "               " + book.getPrice());
            }
        }
    }
    
    static boolean searchBooks(Book book) {
        if (!bookList.isEmpty()) {
            book.getName();
            return true;
        }
        return false;
    }
    
    public static Book getBook(String name, String author) {
        for (Book book : bookList) {
            if (book.name.equals(name)) {
                return book;
            }
            if (book.author.equals(author)) {
                return book;
            }
        }
        return null;
    }
    
    public static void exitFromApp() {
        System.exit(0);
    }    
}
