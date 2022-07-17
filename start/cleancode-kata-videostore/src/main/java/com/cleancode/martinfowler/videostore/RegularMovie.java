package com.cleancode.martinfowler.videostore;

import static com.cleancode.martinfowler.videostore.MovieType.REGULAR;

public class RegularMovie extends Movie {
    RegularMovie(String title) {
        super(title, REGULAR);
    }

    @Override
    double calculatePrice(int daysRented) {
        double thisAmount = 2;
        if (daysRented > 2)
            thisAmount += (daysRented - 2) * 1.5;
        return thisAmount;
    }
}
