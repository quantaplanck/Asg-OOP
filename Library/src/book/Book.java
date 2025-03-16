package book;

import author.Author;

public class Book {

    public String title;
    public String isbn;
    public Author book_author;

    public Book(String title, String isbn, Author book_author) {
        this.title = title;
        this.isbn = isbn;
        this.book_author = book_author;
    }
}
