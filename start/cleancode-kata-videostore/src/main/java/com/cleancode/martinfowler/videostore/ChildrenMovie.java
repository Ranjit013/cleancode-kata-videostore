package com.cleancode.martinfowler.videostore;

import static com.cleancode.martinfowler.videostore.MovieType.CHILDRENS;

public class ChildrenMovie extends Movie {
    public ChildrenMovie(String title) {
        super(title, CHILDRENS);
    }

    @Override
    double calculatePrice(int daysRented) {
        double thisAmount = 1.5;
        if (daysRented > 3)
            thisAmount += (daysRented - 3) * 1.5;
        return thisAmount;
    }
}
