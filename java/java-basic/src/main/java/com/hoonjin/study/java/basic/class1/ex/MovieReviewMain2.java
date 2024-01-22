package com.hoonjin.study.java.basic.class1.ex;

public class MovieReviewMain2 {

    public static void main(String[] args) {
        MovieReview review0 = new MovieReview();
        review0.title = "inception";
        review0.review = "인생은 무한루프";

        MovieReview review1 = new MovieReview();
        review1.title = "About Time";
        review1.review = "인생 시간 영화";

        MovieReview[] movieReviews = {review0, review1};

        for (MovieReview review : movieReviews) {
            System.out.println("영화 제목 = " + review.title + ", 리뷰 = " + review.review);
        }
    }
}
