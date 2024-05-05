/**
 * The My Product Class
 * 
 * This is the subclass of the Product
 * class as it extends the Product class
 * 
 * @author Fatima Syeda
 *
 */

public class MyProduct extends Product {

	protected String colour = "";
	protected int qty = 0;
	protected String description = "";
	protected String origin = "";
	protected int JIT = 0;

	/**
	 * Constructor method for CSV entry
	 * 
	 * Constructor which takes a line of CSV text, splits it up, and
	 * populates the data of my Person object. Delimiter used in the
	 * file is a pipe symbol ("|")
	 * 
	 * @param csvLine Line containing the person's info in CSV format
	 *
	 */

	public MyProduct(String CSVLine) {

		String[] data = CSVLine.split("\\|");
		this.name = data[0];
		this.price = Double.parseDouble(data[1]);
		this.colour = data[2];
		this.qty = Integer.parseInt(data[3]);
		this.description = data[4];
		this.origin = data[5];
		this.JIT = Integer.parseInt(data[6]);

	}// MyProduct(String)

	/**
	 * Method to write data back to CSV
	 * 
	 * 
	 * @return line with data separated by the pipe "|" symbol
	 *
	 */
	public String toCSV() {

		return this.name + "|" + this.price + "|" + this.colour + "|" + this.qty + "|" + this.description
				+ "|" + this.origin + "|" + this.JIT;

	}// String toCSV(void)

	/**
	 * Constructor with name, price and quantity
	 * 
	 * @param name     Name of item
	 * @param price    Price of item
	 * @param quantity Number of items
	 */
	public MyProduct(String name, double price, int quantity) {

		this.name = name;
		this.price = price;
		this.qty = quantity;

	}// MyProduct(String,double,int)

	/**
	 * The toString method
	 * 
	 * Returns values of variables in object
	 * 
	 * @return String String of values in object
	 * 
	 */
	public String toString() {

		return "Name: " + this.name + "\nPrice: " + String.format("%.2f", this.price) + "\nColour: " + this.colour
				+ "\nIn Stock: " +
				this.qty + "\nDescription: " + this.description + "\nOrigin: " + this.origin;

	}// String toString(void)

	public String toStringAdmin() {

		return "Name: " + this.name + "\nPrice: " + String.format("%.2f", this.price) + "\nColour: " + this.colour
				+ "\nIn Stock: " +
				this.qty + "\nDescription: " + this.description + "\nOrigin: " + this.origin + "\nJIT Trigger: "
				+ this.JIT;

	}// String toString(void)

	/**
	 * Returns if the objects in MyProduct contains a string
	 * 
	 * @param item String to search for in the items
	 * @return True or False if item is found
	 */

	public boolean contains(String item) {
		boolean found = false;
		if ((this.name.toLowerCase()).indexOf(item.toLowerCase()) > -1) {
			found = true;

		} // end if

		return found;
	}// boolean contains(String)

	// Create the setter for all variables

	public void setColour(String colour) {
		this.colour = colour;
	}// void setColour(String)

	public void setQty(int qty) {
		this.qty = qty;
	}// void setQty(String)

	public void setDescription(String description) {
		this.description = description;
	}// void setDescription(String)

	public void setOrigin(String origin) {
		this.origin = origin;
	}// void setOrigin(String)

	public void setJIT(int JIT) {
		this.JIT = JIT;
	}// void setJIT(String)

	// Create getter for all variables

	public String getColour() {
		return colour;
	}// String getColour

	public int getQty() {
		return qty;
	}// String getQty

	public String getDescription() {
		return description;
	}// String getDescription

	public String getOrigin() {
		return colour;
	}// String getOrigin

	public int getJIT() {
		return JIT;
	}// String getJIT

}// end class