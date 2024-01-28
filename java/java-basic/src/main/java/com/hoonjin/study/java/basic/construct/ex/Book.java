package com.hoonjin.study.java.basic.construct.ex;

public class Book {
    String title;
    String author;
    int page;

    Book(String title, String author, int page) {
        this.title = title;
        this.author = author;
        this.page = page;
    }

    Book(String title, String author) {
        this(title, author, 0);
    }

    Book() {
        this("", "");
    }

    void displayInfo() {
        System.out.println("title = " + title + ", author = " + author + ", page = " + page);
    }
}
