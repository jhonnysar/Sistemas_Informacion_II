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
		return movie.getCharge(daysRented);
	}
	
	public int getFrecuentRentPoints() {
		return movie.getFrecuentRentPoints(daysRented);
	}
	
	public Movie getMovie() {
		return movie;
	}

	public int getDaysRented() {
		return daysRented;
	}
}