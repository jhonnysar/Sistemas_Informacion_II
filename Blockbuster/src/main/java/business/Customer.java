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

		String result = "Rental Record for " + get_name() + "\n";
		for (Rental rentals : _rentals) {
			// show figures for this rental
			result += "\t" + rentals.getMovie().getTitle() + "\t" + String.valueOf(rentals.getCharge()) + "\n";
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrecuentRentPoints()) + " frequent rent points" + "\n";
		return result;
	}
	
	public double getTotalCharge() {
		double result = 0;
		for (Rental rentals : _rentals) {
			result += rentals.getCharge();
		}
		return result;
	}

	public int getTotalFrecuentRentPoints() {
		int result = 0;
		for (Rental rentals : _rentals) {
			result += rentals.getFrecuentRentPoints();
		}
		return result;
	}

	public String get_name() {
		return _name;
	}

}
