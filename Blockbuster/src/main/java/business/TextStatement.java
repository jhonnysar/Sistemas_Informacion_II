package business;

public class TextStatement extends Statement{

	public String header(Customer aCustomer) {
		return "Rental Record for " + aCustomer.get_name() + "\n";
	}

	public String body(Rental rentals) {

		return "\t" + rentals.getMovie().getTitle() + "\t" + String.valueOf(rentals.getCharge()) + "\n";
	}

	public String footer(Customer aCustomer) {
		return "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n" + "You earned "
				+ String.valueOf(aCustomer.getTotalFrecuentRentPoints()) + " frequent rent points" + "\n";
	}
	
}
