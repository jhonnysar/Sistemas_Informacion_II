package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CajaTest {

	Movie movie1 = new Movie("Lord of the rings", 0);
	Movie movie2 = new Movie("Spider Man", 0);
	Movie movie3 = new Movie("Toy Story", 2);
	Movie movie4 = new Movie("The Wicher: Sirens of the deep", 1);
	Movie movie5 = new Movie("The Wicher: Sirens of the deep", 1);

	Rental rental1 = new Rental(movie1, 4);
	Rental rental2 = new Rental(movie2, 5);
	Rental rental3 = new Rental(movie3, 3);
	Rental rental4 = new Rental(movie4, 1);
	Rental rental5 = new Rental(movie5, 3);

	Customer customer1 = new Customer("Juan Espinoza");
	Customer customer2 = new Customer("Anabel Williams");
	Customer customer3 = new Customer("Mohamed");

	Caja caja = new Caja();
	
	@Test
	void statementTest() {
		addCustomers();
		assertEquals("Rental Record for Juan Espinoza\n" + "	Lord of the rings	5.0\n" + "	Spider Man	6.5\n"
				+ "	The Wicher: Sirens of the deep	9.0\n" + "Amount owed is 20.5\n"
				+ "You earned 4 frequent rent points\n",caja.statement(customer1));
	}
	
	@Test
	void notExistTest() {
		addCustomers();
		assertEquals("The name does not exist in the system",caja.statement(customer3));
	}

	void addRentals() {
		customer1.addRental(rental1);
		customer1.addRental(rental2);
		customer1.addRental(rental5);
		customer2.addRental(rental3);
		customer2.addRental(rental4);
	}
	
	void addCustomers() {
		addRentals();
		caja.addCustomer(customer1);
		caja.addCustomer(customer2);
	}

}
