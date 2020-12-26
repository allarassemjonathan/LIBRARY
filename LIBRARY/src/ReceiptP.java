import java.time.LocalDateTime;
import java.io.*;

public class ReceiptP {

	private Book book;
	private String user;
	private LocalDateTime date = LocalDateTime.now();
	private Integer i = 0;
	
	/**
	 * 
	 * @param book | book bought
	 * @param user | name of the purchaser
	 */
	public ReceiptP(Book book,String user) {
		this.book = book;
		this.user= user;
	}
	
	
	/**
	 * 
	 * @return the content of the receipt
	 */
	public String returnReceiptP() {
		
		 String str = "Purchase Receipt " + "\n\n" 
					+"Book Name: " + this.book.getName() + "\n"
					+"Price:  $" + this.book.getPrice() + "\n"
					+"Username: " + this.user + "\n"
					+"Date: " + this.date + "\n";

		return str;
	}
	
	/**
	 * 
	 * @return the Object book bought
	 */
	public Book getBook() {
		return this.book;
	}
	
	/**
	 * 
	 * @return the name of the user
	 */
	public String getUser() {
		return this.user;
	}

	/**
	 * 
	 * @return Object date and time when you bought
	 */
	public LocalDateTime getDate() {
		return this.date;
	}
	
	/**
	 * 
	 * @param book | set the book you want to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}
	
	/**
	 * 
	 * @param user | set the name of the purchaser
	 */
	public void setUser(String user) {
		this.user = user;
	}
	
	/**
	 * 
	 * @param date | set the date and time of the purchase
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	/**
	 * 
	 * @param book                   | the book you want to generate the receipt of
	 * @param user                   | the name of the user that bought the book
	 * @throws FileNotFoundException | in the case the file to generate is not found
	 */
	public void generateReceipt(Book book, String user) throws FileNotFoundException {
		ReceiptP r = new ReceiptP(book,user);
		OutputStream ou = new FileOutputStream("PurchaseReceipt" + i + ".txt");
		PrintWriter pen = new PrintWriter(ou);
		pen.print(this.returnReceiptP());
		i++;		
		pen.close();
	}
}
