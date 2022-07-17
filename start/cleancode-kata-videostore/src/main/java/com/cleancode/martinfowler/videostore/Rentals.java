package com.cleancode.martinfowler.videostore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Rentals implements Iterable<Rental> {
    private final List<Rental> rentals = new ArrayList<>();

    public Rentals(Rental... rental) {
        rentals.addAll(Arrays.asList(rental));
    }

    public int calculateFrequentRenterPoints() {
        return rentals.stream().mapToInt(rental -> rental.getMovie().getFrequentRenterPoints(rental.getDaysRented())).sum();
    }

    public double calculateTotalPrice() {
        return rentals.stream().mapToDouble(rental -> rental.getMovie().calculatePrice(rental.getDaysRented())).sum();
    }

    @Override
    public Iterator<Rental> iterator() {
        return rentals.iterator();
    }

    public List<Rental> getRentals() {
        return rentals;
    }
}
