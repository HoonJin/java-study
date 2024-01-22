package com.hoonjin.study.java.basic.class1.ex;

public class MovieReviewMain1 {

    public static void main(String[] args) {
        MovieReview review = new MovieReview();
        review.title = "inception";
        review.review = "인생은 무한루프";

        MovieReview review1 = new MovieReview();
        review1.title = "About Time";
        review1.review = "인생 시간 영화";

        System.out.println("영화 제목 = " + review.title + ", 리뷰 = " + review.review);
        System.out.println("영화 제목 = " + review1.title + ", 리뷰 = " + review1.review);
    }
}
