package business;

public class Movie {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
	private Price _price;

	public Movie(String title, int price) {
		_title = title;
		setPriceCode(price);;
	}

	public int getFrecuentRentPoints(int daysRented) {
		int result = 0;
		result++;
		// Add bonus for a two day new release rental
		if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
			result++;
		return result;
	}

	public double getCharge(int daysRented) {
		return _price.getCharge(daysRented);
	}

	public int getPriceCode() {
		return _price.getPriceCode();
	}

	public void setPriceCode(int arg) {
		switch (arg) {
		case REGULAR:
			_price = new RegularPrice();
			break;
		case NEW_RELEASE:
			_price = new NewReleasePrice();
			break;
		case CHILDRENS:
			_price = new ChildrensPrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price code");

		}
	}

	public String getTitle() {
		return _title;
	}
}
