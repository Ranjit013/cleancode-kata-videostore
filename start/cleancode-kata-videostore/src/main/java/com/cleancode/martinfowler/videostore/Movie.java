package com.cleancode.martinfowler.videostore;

import static com.cleancode.martinfowler.videostore.MovieType.NEW_RELEASE;

public class Movie
{
	private final String title;
	private final MovieType movieType;

	Movie(String title, MovieType movieType) {
		this.title 		= title;
		this.movieType = movieType;
	}

	public static Movie createMovie(String title, MovieType movieType) {
		switch (movieType) {
			case REGULAR:
				return new RegularMovie(title);
			case NEW_RELEASE:
				return new NewReleaseMovie(title);
			case CHILDRENS:
				return new ChildrenMovie(title);
			default:
				return new Movie(title, movieType);
		}

	}

	public String getTitle () {
		return title;
	}


	 double calculatePrice(int daysRented) {
		 return 0;
	}

	int getFrequentRenterPoints(int daysRented) {
		int frequentRenterPoints = 0;
		frequentRenterPoints++;
		if (movieType == NEW_RELEASE && daysRented > 1) {
			frequentRenterPoints++;
		}
		return frequentRenterPoints;
	}
}