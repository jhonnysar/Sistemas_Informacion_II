package business;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		rentals = new ArrayList<Rental>();
	};

	public void addRental(Rental arg) {
		rentals.add(arg);

	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public String getName() {
		return name;
	}
}
