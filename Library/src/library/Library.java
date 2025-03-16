package library;

import book.Book;
import borrower.Borrower;

import java.util.ArrayList;

public class Library {

    ArrayList<Book> book_list = new ArrayList<>();

    public void addBook(Book book) {
        book_list.add(book);
        System.out.println("Book added to library: " + book.title);
    }

    public void borrowBook(Borrower borrower, Book book) {
        book_list.remove(book);
        Borrower.book_list.add(book);
        System.out.println(borrower.name + " borrowed: " + book.title);
    }

    public void returnBook(Borrower borrower, Book book) {
        book_list.add(book);
        borrower.book_list.remove(book);
        System.out.println(borrower.name + " returned: " + book.title);
    }

    public void displayLibraryBooks() {
        System.out.println("Books in Library:");
        for (Book book: book_list) {
            System.out.println("Title: " + book.title);
            System.out.println("ISBN: " + book.isbn);
            System.out.println("Author: " + book.book_author.name);
            System.out.println("Biography: " + book.book_author.desc);
            System.out.println("------------------------");
        }
    }
}
