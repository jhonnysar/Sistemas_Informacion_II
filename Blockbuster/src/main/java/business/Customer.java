package business;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String _name;
	private List<Rental> _rentals = new ArrayList<Rental>();

	public Customer(String name) {
		_name = name;
	};

	public void addRental(Rental arg) {
		_rentals.add(arg);

	}

	public String statement() {

		double totalAmount = 0;
		int frequentRentPoints = 0;
		String result = "Rental Record for " + get_name() + "\n";
		for (Rental rentals : _rentals) {
			double thisAmount = 0;

			// determinate amounts for each movie
			switch (rentals.get_movie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (rentals.get_daysRented() > 2) {
					thisAmount += (rentals.get_daysRented() - 2) * 1.5;
				}
				break;
			case Movie.NEW_RELEASE:
				thisAmount += rentals.get_daysRented() * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (rentals.get_daysRented() > 3) {
					thisAmount += (rentals.get_daysRented() - 3) * 1.5;
				}
				break;
			}

			// Add frequent points
			frequentRentPoints++;

			// Add bonus for a two day new release rental
			if ((rentals.get_movie().getPriceCode() == Movie.NEW_RELEASE) && rentals.get_daysRented() > 1)
				frequentRentPoints++;

			// show figures for this rental
			result += "\t" + rentals.get_movie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRentPoints) + " frequent rent points" + "\n";

		return result;
	}

	public String get_name() {
		return _name;
	}

}
