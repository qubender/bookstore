package hh.bookstore.bookstore.domain;

public class Book {

    private String title;
    private String author;
    private int publicationYear;
    private long isbn;
    private double price;

    public Book(String title, String author, int publicationYear, long isbn, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public long getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

}
