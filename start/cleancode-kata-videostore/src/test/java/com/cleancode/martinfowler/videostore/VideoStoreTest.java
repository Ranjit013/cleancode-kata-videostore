package com.cleancode.martinfowler.videostore;


import org.junit.Before;
import org.junit.Test;

import static com.cleancode.martinfowler.videostore.MovieType.*;
import static org.junit.Assert.*;

public class VideoStoreTest {

    private StatementFormatter statementFormatter;


    @Before
    public void setUp() {
        statementFormatter = new StatementFormatter();
    }

    @Test
    public void testSingleNewReleaseStatement() {
        String name = "Fred";
        Rentals rentals = new Rentals(new Rental(Movie.createMovie("The Cell", NEW_RELEASE), 3));
        assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n", statementFormatter.formatStatement(name, rentals));
    }

    @Test
    public void testDualNewReleaseStatement() {
        String name = "Fred";
        Rentals rentals = new Rentals(new Rental(Movie.createMovie("The Cell", NEW_RELEASE), 3), new Rental(Movie.createMovie("The Tigger Movie", NEW_RELEASE), 3));
        assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n", statementFormatter.formatStatement(name, rentals));
    }

    @Test
    public void testSingleChildrensStatement() {
        String name = "Fred";
        Rentals rentals = new Rentals(new Rental(Movie.createMovie("The Tigger Movie", CHILDRENS), 3));
        assertEquals("Rental Record for Fred\n\tThe Tigger Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n", statementFormatter.formatStatement(name, rentals));
    }

    @Test
    public void testMultipleRegularStatement() {
        String name = "Fred";
        Rentals rentals = new Rentals(new Rental(Movie.createMovie("Plan 9 from Outer Space", REGULAR), 1), new Rental(Movie.createMovie("8 1/2", REGULAR), 2), new Rental(Movie.createMovie("Eraserhead", REGULAR), 3));
        assertEquals("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n", statementFormatter.formatStatement(name, rentals));
    }
}