package business;

class Rental {

	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	// determinate amounts for each movie

	public double getCharge() {
		double result = 0;
		switch (movie.getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (daysRented > 2) {
				result += (daysRented - 2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			result += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (daysRented > 3) {
				result += (daysRented - 3) * 1.5;
			}
			break;
		}
		return result;
	}
	
	public int getFrecuentRentPoints() {
		int result =0;
		result++;
		// Add bonus for a two day new release rental
		if ((movie.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
			result++;
		return result;
	}
	
	public Movie getMovie() {
		return movie;
	}

	public int getDaysRented() {
		return daysRented;
	}
}