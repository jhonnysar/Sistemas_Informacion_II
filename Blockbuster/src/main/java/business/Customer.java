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
		return new TextStatement().value(this);
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

	public String htmlStatement() {
		return new HtmlStatement().value(this);
	}
	
	public String get_name() {
		return _name;
	}

	public List<Rental> get_rentals() {
		return _rentals;
	}
	

}
