package com.cleancode.martinfowler.videostore;

import static java.util.stream.Collectors.joining;

public class StatementFormatter {

    public String formatStatement(String name, Rentals rentals) {
        return formatHeader(name) + formatBody(rentals) + formatFooter(rentals);
    }

    private String formatFooter(Rentals rentals) {
        String result = "You owed " + rentals.calculateTotalPrice() + "\n";
        result += "You earned " + rentals.calculateFrequentRenterPoints() + " frequent renter points\n";
        return result;
    }


    private String formatBody(Rentals rentals) {
        return rentals.getRentals().stream().map(rental -> "\t" + rental.getMovie().getTitle() + "\t"
                + rental.getMovie().calculatePrice(rental.getDaysRented()) + "\n").collect(joining());
    }

    private String formatHeader(String customerName) {
        return "Rental Record for " + customerName + "\n";
    }
}
