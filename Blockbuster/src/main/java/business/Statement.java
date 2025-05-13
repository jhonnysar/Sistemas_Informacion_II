package business;

public abstract class Statement {
	public String value(Customer aCustomer) {
		//show the header
		String result = header(aCustomer);
		for (Rental rentals : aCustomer.get_rentals()) {
			// show figures for this rental
			result += body(rentals);
		}
		// add footer lines
		result += footer(aCustomer);
		return result;
	}
	abstract String header(Customer aCustomer);
	abstract String body(Rental rentlas);
	abstract String footer(Customer aCustomer);
}
