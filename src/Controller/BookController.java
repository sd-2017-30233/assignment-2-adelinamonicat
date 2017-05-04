package Controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import Model.Book;

public class BookController implements Serializable {
	private List<Book> bookList = new ArrayList<Book>();

	public void createBook(Book book, String bTitle, String bAuthor, String bGenre, int bQuantity, int bPrice) {

		book = new Book(bTitle, bAuthor, bGenre, bQuantity, bPrice);
		bookList.add(book);

	}

	public void readBook(String bTitle, JTextField aut, JTextField gen, JTextField qua, JTextField price) {

		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getTitle().equals(bTitle))
			{
				aut.setText(bookList.get(i).getAuthor());
				gen.setText(bookList.get(i).getGenre());
				int q = bookList.get(i).getQuantity();
				String qS = "" + q;
				qua.setText(qS);
				int p = bookList.get(i).getPrice();
				String pS = "" + p;
				price.setText(pS);
			}

		}

	}

	public void updateBook(String bTitle, String newTitle, String newAuthor, String newGenre, int newQuantity,
			int newPrice) {
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getTitle().equals(bTitle)) {
				bookList.get(i).setTitle(newTitle);
				bookList.get(i).setAuthor(newAuthor);
				bookList.get(i).setGenre(newGenre);
				bookList.get(i).setQuantity(newQuantity);
				bookList.get(i).setPrice(newPrice);
				break;
			}
		}
	}

	public void deleteBook(String bTitle) {
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getTitle().equals(bTitle))
				bookList.remove(bookList.get(i));
		}
	}

	public void serializeObj(BookController bookC) {
		try {
			FileOutputStream fileOut = new FileOutputStream("save.xml");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			out.writeObject(bookC);
			out.flush();
			out.close();
			fileOut.close();
			System.out.println("data was saved!");

		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public void deserializeObj() {
		// System.out.println("here 1");
		BookController bookC = new BookController();
		try {// System.out.println("here 2");
			FileInputStream fileIn = new FileInputStream("save.xml");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			bookC = (BookController) in.readObject();
			in.close();
			fileIn.close();
			bookList = bookC.bookList;
			System.out.println("data was recovered!");

		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {

			c.printStackTrace();
			return;
		}
	}

	public void sellBook(String bTitle, int quant) {
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getTitle().equals(bTitle)) {
				int qu = bookList.get(i).getQuantity();
				if (quant <= qu)
					if (qu == 1)
						bookList.remove(bookList.get(i));
					else
						bookList.get(i).setQuantity(qu - quant);
			}
		}
	}

	public boolean searchBook(String choice, String info) {
		boolean found = false;
		for (int i = 0; i < bookList.size(); i++) {
			if (choice.equals("genre")) {
				if (bookList.get(i).getGenre().equals(info)) {
					found = true;
					System.out.println("Title: " + bookList.get(i).getTitle());
					System.out.println("Author: " + bookList.get(i).getAuthor());
					System.out.println("Quantity: " + bookList.get(i).getQuantity());
					System.out.println("Price: " + bookList.get(i).getPrice());
				}

			} else if (choice.equals("title")) {
				if (bookList.get(i).getTitle().equals(info)) {
					found = true;
					// System.out.println("Search by title");

					System.out.println("Author: " + bookList.get(i).getAuthor());
					System.out.println("Genre: " + bookList.get(i).getGenre());
					System.out.println("Quantity: " + bookList.get(i).getQuantity());
					System.out.println("Price: " + bookList.get(i).getPrice());
				}

			} else if (choice.equals("author")) {
				if (bookList.get(i).getAuthor().equals(info)) {
					found = true;
					// System.out.println("Search by author");
					System.out.println("Title: " + bookList.get(i).getTitle());
					System.out.println("Genre: " + bookList.get(i).getGenre());
					System.out.println("Quantity: " + bookList.get(i).getQuantity());
					System.out.println("Price: " + bookList.get(i).getPrice());
				}

			}
		}
		return found;
	}

	public void fillComboBook(JComboBox combo) {
		for (int i = 0; i < bookList.size(); i++)
			combo.addItem(bookList.get(i).getTitle());

	}

}
