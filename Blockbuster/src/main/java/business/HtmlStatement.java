package business;

public class HtmlStatement extends Statement{

	public String header(Customer aCustomer) {
		return "<h1>Rentals for <em>" + aCustomer.get_name() + "</h1></em><p>\n";
	}

	public String body(Rental rentals) {

		return rentals.getMovie().getTitle() + ": " + String.valueOf(rentals.getCharge()) + "<br>\n";
	}

	public String footer(Customer aCustomer) {
		return "<p>You owe <em>" + String.valueOf(aCustomer.getTotalCharge()) + "</em> <p>\n"
				+ "On this rental you earned <em>" + String.valueOf(aCustomer.getTotalFrecuentRentPoints())
				+ "</em> frequent rent points<p>";
	}
}
