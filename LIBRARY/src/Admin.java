
public class Admin extends User{

	public Admin() {
		super();
	}
	
	public Admin(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public void addBook(Book book, Library library) {
		library.addBook(book);
	}
	
	
}
