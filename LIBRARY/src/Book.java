import java.time.LocalDate;

public class Book {

	private String name;
	private Integer price;
	private Boolean Available;
	private LocalDate bbdate;
	private LocalDate pdate;
	
	public Book(String name, Integer price, Boolean isthere ) {
		this.name = name;
		this.price = price;
		this.Available = isthere;
	}
	/**
	 * 
	 * @return the name of the book
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @return the price of the book
	 */
	public Integer getPrice() {
		return this.price;
	}
	
	/**
	 * 
	 * @return the availability of the book
	 */
	public Boolean getAvailability() {
		return this.Available;
	}
	
	/**
	 * 
	 * @param name the name of the book
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @param price the price of the book
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	/**
	 * 
	 * @param ok it's the parameter for the availability 
	 * of the book
	 */
	public void setAvailable(Boolean ok) {
		this.Available= ok;
	}
	
	/**
	 * 
	 * @param bbdate it's the date to bring back 
	 * the book
	 */
	public void setDueDate(LocalDate bbdate) {
		this.bbdate =bbdate;
	}
	
	/**
	 * 
	 * @return bbdate the date to bring the book back
	 */
	public LocalDate getDueDate() {
		return this.bbdate;
	}
	
	/**
	 * 
	 * @param pdate the date the book is purchased
	 */
	public void setBoughtDate(LocalDate pdate) {
		this.pdate = pdate;
	}
	
	/**
	 * 
	 * @return the date when the book was bought
	 */
	public LocalDate getBoughtDate() {
		return this.pdate;
	}
	/**
	 *  this is just a quick short cut to print elements
	 *  of the book
	 */
	
	public void printBook() {
		System.out.println(this.getName() + " $" + this.getPrice());
	}
}
