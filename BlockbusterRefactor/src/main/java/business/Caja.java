package business;

import java.util.ArrayList;
import java.util.List;

public class Caja {

	double totalAmount = 0;

	int frequentRentPoints = 0;

	private List<Customer> customers;

	public Caja() {
		customers = new ArrayList<>();
	}
	//maquetar mejor los dats y lanzarlos a partir del to String 
	public String statement(Customer customer) {
		String result = "The name does not exist in the system";
		if (customers.contains(customer)) {
			result = "Rental Record for " + customer.getName() + "\n";
			for (Rental rentals : customer.getRentals()) {
				// determinate amounts for each movie
				double amount = calculatePrice(rentals);
				// Add frequent points
				frequentRentPoints++;

				// Add bonus for a two day new release rental
				if ((rentals.get_movie().getPriceCode() == Movie.NEW_RELEASE) && rentals.get_daysRented() > 1)
					frequentRentPoints++;

				// show figures for this rental
				result += "\t" + rentals.get_movie().getTitle() + "\t" + String.valueOf(amount) + "\n";
				totalAmount += amount;
			}
			// add footer lines
			result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
			result += "You earned " + String.valueOf(frequentRentPoints) + " frequent rent points" + "\n";

		}
		return result;
	}

	private double calculatePrice(Rental rentals) {
		// agregar una lista de precios relacionado con el tipo de pelicula
		// A de mas agregar la condicion de los dias
		double amount = 0;
		switch (rentals.get_movie().getPriceCode()) {
		case Movie.REGULAR:
			amount += 2;
			if (rentals.get_daysRented() > 2) {
				amount += (rentals.get_daysRented() - 2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			amount += rentals.get_daysRented() * 3;
			break;
		case Movie.CHILDRENS:
			amount += 1.5;
			if (rentals.get_daysRented() > 3) {
				amount += (rentals.get_daysRented() - 3) * 1.5;
			}
			break;
		}
		return amount;

	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
}
