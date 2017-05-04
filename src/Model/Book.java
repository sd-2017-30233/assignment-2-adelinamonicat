package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5865854328548352616L;
	private String title;
	private String author;
	private String genre;
	private int quantity;
	private int price;
	private List<Book> bookList = new ArrayList<Book>();
	
	
	public Book(String title, String author, String genre, int quantity, int price){
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.quantity = quantity;
		this.price = price;
	}
	
	


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
}
