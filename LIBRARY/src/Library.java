import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {

	private ArrayList<Book> library = new ArrayList<Book>();
	
	public Library() {
		
	}
	public Library(ArrayList<Book>library) {
		this.library = library;
	}
	
	public void printNames() {
		for (int i =0; i < this.library.size(); i++) {
			System.out.println(library.get(i).getName());
		}
	}
	
	public void printPrices() {
		for (int i =0; i < this.library.size(); i++) {
			System.out.println(library.get(i).getPrice());
		}
	}
	
	public void printAvailability() {
		for (int i =0; i < this.library.size(); i++) {
			System.out.println(library.get(i).getAvailability());
		}
	}
	
	public void addBook(Book book) {
		this.library.add(book);
	}
	
	public Integer LibrarySize() {
		return this.library.size();
	}
	
	public Book getBook(String name) {
		name = name.toUpperCase();
		for (int i = 0; i < this.LibrarySize(); i++) {
			if(this.library.get(i).getName().equals(name.toUpperCase())){
				return this.library.get(i);
			}
	}
		return null;
	}
	public String getBookname(String name) {
		return this.getBook(name).getName();
		
	} 
	public void removeB(String name, Library lib) {
		this.library.remove(lib.getBook(name));
	}
	}
