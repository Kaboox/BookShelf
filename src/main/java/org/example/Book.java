package org.example;

public class Book {
    private String title;
    private String author;
    private String genre;
    private int release_year;


    public Book() {

    }
    public Book(String title) {
        this.title = title;
    }
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
    public Book(String title, String author, String genre, int release_year) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.release_year = release_year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getRelease_year() {
        return release_year;
    }


}
