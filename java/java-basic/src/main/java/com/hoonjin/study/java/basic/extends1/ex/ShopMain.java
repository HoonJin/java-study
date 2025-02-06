package com.hoonjin.study.java.basic.extends1.ex;

public class ShopMain {

    public static void main(String[] args) {
        Book book = new Book("JAVA", 1000, "han", "12345");
        Album album = new Album("ALBUM", 1000, "han");
        Movie movie = new Movie("MOVIE", 1000, "han", "young");

        book.print();
        album.print();
        movie.print();

        int sum = book.getPrice() + album.getPrice() + movie.getPrice();
        System.out.println("sum = " + sum);
    }
}
