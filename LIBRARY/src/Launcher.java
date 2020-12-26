import java.io.*;

import java.util.*;
public class Launcher {
	public void loadLibrary() {
		
	}
	
	public void LaunchService() throws FileNotFoundException {
		InputStream in = new FileInputStream("library.txt");
		Scanner sc = new Scanner(in);
		Library lib = new Library();
		Scanner scK = new Scanner(System.in);
		
		while(sc.hasNext()) {
			String name = sc.next();
			Integer price = sc.nextInt();
			Boolean ok = true;
			Book book = new Book(name, price, ok);
			lib.addBook(book);
		}
		
		
		/*
		 * Greetings!
		 */
		
		System.out.print("Create your user account!\n");
		System.out.print("name: ");
		String userName = scK.next();
		System.out.print("password: ");
		String userPassword = scK.next();
		User user = new User(userName, userPassword);
		System.out.println("Welcome to the Library service!!");
		
	do {
		
		String str = "Your balance: $" + user.getBalance() + "\n"
		+ "Choose an option:  \n"
		+ "\t1. Buy a book\n"
		+ "\t2. Borrow a book\n"
		+ "\t3. Charge my balance\n"
		+ "\t4. See my purchases\n"
		+ "\t5. See my due date\n"
		+ "\t6. Exit\n";
		System.out.println(str);
		
		/*
		 *  Option BUY
		 */
		int numb = scK.nextInt();
		if(numb == 1) {
			
			System.out.println("What book do you want to buy?");
			String Bname = scK.next();
			
			
			if(user.SearchForBook(Bname, lib)){
				Book book = lib.getBook(Bname);
				if(user.getBalance() > book.getPrice()) {
					user.BuyB(lib.getBookname(Bname), lib);
					user.setBalance(user.getBalance()-book.getPrice());
				}
				else {
					System.out.println("\nSorry you don't have enough money");
				}
				
			}
		
		}
		
		/*
		 *  Option BORROW
		 */
		
		else if (numb == 2) {
			
			System.out.println("What book do you want to borrow?");
			String Bname = scK.next();
			if(user.SearchForBook(Bname, lib)){
				Book book = lib.getBook(Bname);
				user.BorrowB(lib.getBookname(Bname), lib);
			}
			
		}
		else if (numb == 3) {
			System.out.println("Enter the amount in the card");
			Integer money = scK.nextInt();
			user.setBalance(money);
			System.out.println("Money sucessfully upload!");
		}
		else if (numb == 4) {
			if(user.isPurchasesEmpty()) {
				System.out.println("No purchase");
			}
			else {
				System.out.println(user.MyPurchases());
			}
		}
		else if (numb == 5){
			System.out.println(user.MyDueDates());
		}
	}while(true);
	}
	public static void main(String[] args) throws FileNotFoundException {
		
		Launcher laun = new Launcher();
		
		
			laun.LaunchService();
		
}
}