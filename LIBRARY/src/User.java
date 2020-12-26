import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;
public class User {

	protected String name;
	protected String password;
    private ArrayList<Book> BorrowedBook = new ArrayList<Book>();
	private ArrayList<Book> BoughtBook = new ArrayList<Book>();
	private Integer balance = 0;
	
	public User() {
		
	}
	
	public User(String name) {
		this.setName(name);
	}
	
	public User(String name,String password) {
		this.setName(name);
		this.setPassword(password);
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}
	
	public Integer getBalance() {
		return this.balance;
	}
	
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	/**
	 * 
	 * @param name | set the name of the user
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @param password | set the password of the user
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Print the user
	 */
	public void printUser() {
		System.out.println("User " + this.name);
	}
	/**
	 * 
	 * @return a string containing all the purchases
	 */
	public String MyPurchases() {
		System.out.println("Your purchases :");
		String str = "Book Price\n";
		for (int i = 0; i < this.BoughtBook.size();i++) {
			str = str + BoughtBook.get(i).getName() +" $" + BoughtBook.get(i).getPrice() + "\n" ;
		}
		return str;
	}
	
	public String MyDueDates() {
		System.out.println("Your Due Dates :");
		String str = "Books Due-Date\n\n";
		for (int i = 0; i < this.BorrowedBook.size();i++) {
			str = str + BorrowedBook.get(i).getName() + " " + BorrowedBook.get(i).getDueDate() +  "\n";
		}
		return str;
	}

	/**
	 * 
	 * @return true if the purchases section is empty, false otherwise
 	 */
	public Boolean isPurchasesEmpty() {
		if(this.BoughtBook.isEmpty()) {
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @param name | name of the user
	 * @param lib  | library where you borrow
	 */
	public void BorrowB(String name, Library lib) {
		name = name.toUpperCase();
		if(lib.getBook(name).getAvailability()) {
			this.BorrowedBook.add(lib.getBook(name));
			lib.getBook(name).setAvailable(false);
			Receipt r = new Receipt();
			lib.getBook(name).setDueDate(r.BringBackDate());
			System.out.println("Book sucessfully borrowed.");
		}
		else {
		
			System.out.println("This book is not available");
		}
	}
	
	/**
	 * 
	 * @param name | name of the user
	 * @param lib  | library where you buy
	 */
	public void BuyB(String name, Library lib) throws FileNotFoundException {
		/*
		 * If the book is available
		 * 1- we add it in the purchase list
		 * 2- we set its availability to false
		 * 3- we remove the book from the library
		 * 
		 *  else we print that the book is not available
		 */
		if(lib.getBook(name).getAvailability()) {
			Book book = lib.getBook(name);
			this.BoughtBook.add(lib.getBook(name));
			book.setAvailable(false);
			book.setBoughtDate(LocalDate.now());
			lib.removeB(name, lib);
			Receipt r = new Receipt();
			r.generateReceiptP(book, this.name);
			System.out.println("\nBook sucessfully bought! you can take out your receipt");
		}
		else {
			System.out.println("\nThis book is not available");
		}
		
	}
	
	/**
	 * 
	 * @param name | name of the book
	 * @param lib  | library where you search
	 */
	public Boolean SearchForBook(String name, Library lib) {
		if(lib.getBook(name) == null) {
			System.out.println("this book is not in our database");
			return false;
		}
		else if(lib.getBook(name).getAvailability()) {
			lib.getBook(name).printBook();
			return true;
		}
		else {
			System.out.println("this book has been borrowed or bought");
			return false;
		}
	}
	
	/**
	 * 
	 * @param name | name of the book you bring back
	 * @param lib  | library where you bring your book back
	 */
	public void BringB(String name, Library lib) {
		lib.getBook(name).setAvailable(true);
		this.BorrowedBook.remove(lib.getBook(name));
		System.out.println("this book is available now!");
	}
	
	}
	

