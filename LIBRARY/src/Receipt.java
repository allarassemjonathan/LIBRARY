import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;


public class Receipt {

	private LocalDate date = LocalDate.now();
	private Integer i = 0;
	
	/**
	 * 
	 * @param book the book bought
	 * @param user the person that bought the book
	 * @return the text printed on the receipt
	 */ 
	public String toStringP(Book book, String user) {
		String str = "Purchase Receipt\n"
				+ "Book name: " + book.getName() + "\n"
				+ "Book price: $" + book.getPrice() + "\n"
				+ "Username: " + user + "\n"
				+ "Date and time: " + date + "\n";
		
		return str;
	}
	/**
	 * 
	 * @param book the book borrowed
	 * @param user the person that borrowed the book
	 * @return the text printed on the receipt
	 */
	public String toStringB(Book book, String user) {
		String str = "Borrow Receipt\n"
				+ "Book name: " + book.getName() + "\n"
				+ "Book price: $" + book.getPrice() + "\n"
				+ "Username: " + user + "\n"
				+ "Date and time: " + date + "\n"
				+ "Due Date : " + this.BringBackDate();
		
		return str;
	}
	/**
	 * 
	 * @param book the book you purchased
	 * @param user the user that bough the book
	 * @throws FileNotFoundException if ever an error occurred
	 */
	public void generateReceiptP(Book book, String user) throws FileNotFoundException {
		OutputStream ou = new FileOutputStream("Purchase Receipt" + i + ".txt");
		PrintWriter pen = new PrintWriter(ou);
		pen.print(this.toStringP(book,user));
		i++;		
		pen.close();
	}
	
	/**
	 * 
	 * @param book the book you borrow
	 * @param user the user that borrowed the book
	 * @throws FileNotFoundException if an error ever occurred
	 */
	public void generateReceiptB(Book book, String user) throws FileNotFoundException {
		OutputStream ou = new FileOutputStream("Borrow Receipt" + i + ".txt");
		PrintWriter pen = new PrintWriter(ou);
		pen.print(this.toStringB(book,user));
		i++;		
		pen.close();
	}
	
	/**
	 * @return the date you must bring back the book
	 */
	public LocalDate BringBackDate() {
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		int day = ld.getDayOfMonth();
		int month = ld.getMonthValue();
		int year = ld.getYear();
		day +=7;
		if(day>31) {
			day-=31;
			month+=1;
			if(month>12) {
				month-=12;
				year+=1;
			}
		}
		LocalDate ldb = LocalDate.of(year, month, day);
		return ldb;
	}
	public static void main(String[] args) {
		

	}

}
