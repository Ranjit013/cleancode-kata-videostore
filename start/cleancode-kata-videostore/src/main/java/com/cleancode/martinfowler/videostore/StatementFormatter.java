package com.cleancode.martinfowler.videostore;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class StatementFormatter {


    public String formatStatement(String name, List<Rental> rentals) {
        return formatHeader(name) + formatBody(rentals) + formatFooter(rentals);
    }

    private String formatFooter(List<Rental> rentals) {
        String result = "You owed " + rentals.stream().mapToDouble(rental -> rental.getMovie().calculatePrice(rental.getDaysRented())).sum() + "\n";
        result += "You earned " + rentals.stream().mapToInt(rental -> rental.getMovie().getFrequentRenterPoints(rental.getDaysRented())).sum() + " frequent renter points\n";
        return result;
    }

    private String formatBody(List<Rental> rentals) {
        return rentals.stream().map(rental -> "\t" + rental.getMovie().getTitle() + "\t"
                + rental.getMovie().calculatePrice(rental.getDaysRented()) + "\n").collect(joining());
    }

    private String formatHeader(String customerName) {
        return "Rental Record for " + customerName + "\n";
    }
}
