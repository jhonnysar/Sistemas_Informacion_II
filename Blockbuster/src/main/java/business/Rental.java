package business;

class Rental {

	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	// determinate amounts for each movie

	public double getCharge() {
		double result = 0;
		switch (get_movie().getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (get_daysRented() > 2) {
				result += (get_daysRented() - 2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			result += get_daysRented() * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (get_daysRented() > 3) {
				result += (get_daysRented() - 3) * 1.5;
			}
			break;
		}
		return result;
	}
	
	public int getFrecuentRentPoints() {
		int result =0;
		result++;

		// Add bonus for a two day new release rental
		if ((get_movie().getPriceCode() == Movie.NEW_RELEASE) && get_daysRented() > 1)
			result++;
		return result;
	}
	
	public Movie get_movie() {
		return _movie;
	}

	public int get_daysRented() {
		return _daysRented;
	}
}