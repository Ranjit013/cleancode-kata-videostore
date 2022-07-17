package com.cleancode.martinfowler.videostore;

import static com.cleancode.martinfowler.videostore.MovieType.NEW_RELEASE;

public class NewReleaseMovie extends Movie {
    NewReleaseMovie(String title) {
        super(title, NEW_RELEASE);
    }

    @Override
    double calculatePrice(int daysRented) {
        return daysRented * 3;
    }
}
