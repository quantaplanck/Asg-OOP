package borrower;

import book.Book;

import java.util.ArrayList;

public class Borrower {

    public String name;
    public static ArrayList<Book> book_list = new ArrayList<>();

    public Borrower(String name) {
        this.name = name;
    }

    public void displayBorrowedBooks() {
        System.out.println(this.name + "'s Borrowed Books:");
        for (Book book: book_list) {
            System.out.println("Title: " + book.title);
            System.out.println("ISBN: " + book.isbn);
            System.out.println("Author: " + book.book_author.name);
            System.out.println("Biography: " + book.book_author.desc);
            System.out.println("------------------------");
        }
    }
}
