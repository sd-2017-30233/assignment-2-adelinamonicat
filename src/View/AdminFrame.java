package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

import Controller.BookController;

import Controller.UserController;
import Model.Book;
import Model.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminFrame {

	JFrame frame;
	private JTextField inTitle;
	private JTextField inAut;
	private JTextField inGen;
	private JTextField inQu;
	private JTextField inPrice;
	private JTextField uAut;
	private JTextField uGen;
	private JTextField uQu;
	private JTextField uPrice;
	private JTextField inName;
	private JPasswordField inPass;
	private JPasswordField uPass;
	private JTextField uName;
	private Book book;
	private User user;
	//private LibraryController contr;
	private JTextField uTitle;
	private BookController bookC;
	private UserController userC;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame window = new AdminFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//contr = new LibraryController();
		userC = new UserController();
		bookC = new BookController();
		
		userC.deserializeObj();
		bookC.deserializeObj();
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1124, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBooks = new JLabel("Books");
		lblBooks.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBooks.setBounds(12, 25, 56, 16);
		frame.getContentPane().add(lblBooks);
		
		JLabel lblCreatNewBook = new JLabel("Creat new book");
		lblCreatNewBook.setBounds(22, 54, 101, 21);
		frame.getContentPane().add(lblCreatNewBook);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(48, 88, 56, 16);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(48, 117, 56, 16);
		frame.getContentPane().add(lblAuthor);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setBounds(48, 146, 56, 16);
		frame.getContentPane().add(lblGenre);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(48, 175, 56, 16);
		frame.getContentPane().add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(48, 204, 56, 16);
		frame.getContentPane().add(lblPrice);
		
		inTitle = new JTextField();
		inTitle.setBounds(115, 88, 116, 22);
		frame.getContentPane().add(inTitle);
		inTitle.setColumns(10);
		
		inAut = new JTextField();
		inAut.setColumns(10);
		inAut.setBounds(115, 117, 116, 22);
		frame.getContentPane().add(inAut);
		
		inGen = new JTextField();
		inGen.setColumns(10);
		inGen.setBounds(115, 143, 116, 22);
		frame.getContentPane().add(inGen);
		
		inQu = new JTextField();
		inQu.setColumns(10);
		inQu.setBounds(115, 172, 116, 22);
		frame.getContentPane().add(inQu);
		
		inPrice = new JTextField();
		inPrice.setColumns(10);
		inPrice.setBounds(115, 201, 116, 22);
		frame.getContentPane().add(inPrice);
		
		JComboBox uTitleCombo = new JComboBox();
		uTitleCombo.setBounds(337, 85, 116, 22);
		frame.getContentPane().add(uTitleCombo);
		
		
		JComboBox dTitleCombo = new JComboBox();
		dTitleCombo.setBounds(100, 350, 116, 22);
		frame.getContentPane().add(dTitleCombo);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String title = inTitle.getText();
					String aut = inAut.getText();
					String gen = inGen.getText();
					String qu = inQu.getText();
					String price = inPrice.getText();
					
					int quI = Integer.parseInt(qu);
					int priceI = Integer.parseInt(price);
					
					
					bookC.createBook(book, title, aut, gen, quI, priceI);
					
					uTitleCombo.removeAllItems();
					dTitleCombo.removeAllItems();
					bookC.fillComboBook(uTitleCombo);
					bookC.fillComboBook(dTitleCombo);
					
					
					inTitle.setText("");
					inAut.setText("");
					inGen.setText("");
					inQu.setText("");
					inPrice.setText("");
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("Completati corect toate campurile !");
				}
				
								
				
				
			}
		});
		btnInsert.setBounds(73, 283, 97, 25);
		frame.getContentPane().add(btnInsert);
		
		JLabel lblSearchAndUpdate = new JLabel("Search and Update");
		lblSearchAndUpdate.setBounds(259, 56, 116, 16);
		frame.getContentPane().add(lblSearchAndUpdate);
		
		JLabel label = new JLabel("Title:");
		label.setBounds(269, 85, 56, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Author:");
		label_1.setBounds(269, 143, 56, 16);
		frame.getContentPane().add(label_1);
		
		uAut = new JTextField();
		uAut.setColumns(10);
		uAut.setBounds(337, 140, 116, 22);
		frame.getContentPane().add(uAut);
		
		JLabel label_2 = new JLabel("Genre:");
		label_2.setBounds(269, 172, 56, 16);
		frame.getContentPane().add(label_2);
		
		uGen = new JTextField();
		uGen.setColumns(10);
		uGen.setBounds(337, 166, 116, 22);
		frame.getContentPane().add(uGen);
		
		JLabel label_3 = new JLabel("Quantity:");
		label_3.setBounds(269, 201, 56, 16);
		frame.getContentPane().add(label_3);
		
		uQu = new JTextField();
		uQu.setColumns(10);
		uQu.setBounds(337, 195, 116, 22);
		frame.getContentPane().add(uQu);
		
		JLabel label_4 = new JLabel("Price:");
		label_4.setBounds(269, 230, 56, 16);
		frame.getContentPane().add(label_4);
		
		uPrice = new JTextField();
		uPrice.setColumns(10);
		uPrice.setBounds(337, 224, 116, 22);
		frame.getContentPane().add(uPrice);
		
		uTitle = new JTextField();
		uTitle.setColumns(10);
		uTitle.setBounds(337, 114, 116, 22);
		frame.getContentPane().add(uTitle);

		
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = uTitleCombo.getSelectedItem().toString();
				uTitle.setText(title);
				bookC.readBook(title, uAut, uGen, uQu, uPrice);
			}
		});
		btnView.setBounds(256, 283, 97, 25);
		frame.getContentPane().add(btnView);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String title = uTitleCombo.getSelectedItem().toString();
					
					String newTitle = uTitle.getText();
					String newAuthor = uAut.getText();
					String newGenre = uGen.getText();
					String uQuS = uQu.getText();
					String uPrS = uPrice.getText();
					int newQuantity = Integer.parseInt(uQuS);
					int newPrice = Integer.parseInt(uPrS);
					
					
					bookC.updateBook(title, newTitle, newAuthor, newGenre, newQuantity, newPrice);
					
					uTitleCombo.removeAllItems();
					dTitleCombo.removeAllItems();
					bookC.fillComboBook(uTitleCombo);
					bookC.fillComboBook(dTitleCombo);
					
					uTitle.setText("");
					uAut.setText("");
					uGen.setText("");
					uQu.setText("");
					uPrice.setText("");
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println("Completati corect toate campurile !");
				}
			}
		});
		btnUpdate.setBounds(390, 283, 97, 25);
		frame.getContentPane().add(btnUpdate);
		
		JLabel label_5 = new JLabel("Delete");
		label_5.setBounds(22, 321, 56, 16);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Title:");
		label_6.setBounds(32, 350, 56, 16);
		frame.getContentPane().add(label_6);
		

		
		JButton button = new JButton("Delete");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = dTitleCombo.getSelectedItem().toString();
				
				bookC.deleteBook(title);
				uTitleCombo.removeAllItems();
				dTitleCombo.removeAllItems();
				bookC.fillComboBook(uTitleCombo);
				bookC.fillComboBook(dTitleCombo);
				
				
			}
		});
		button.setBounds(73, 409, 97, 25);
		frame.getContentPane().add(button);
		
		JLabel lblUsers = new JLabel("Users");
		lblUsers.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsers.setBounds(498, 25, 56, 16);
		frame.getContentPane().add(lblUsers);
		
		JLabel lblCreatNewUser = new JLabel("Creat new user");
		lblCreatNewUser.setBounds(517, 59, 101, 16);
		frame.getContentPane().add(lblCreatNewUser);
		
		JLabel lblSearchAndUpdate_1 = new JLabel("Search and Update");
		lblSearchAndUpdate_1.setBounds(752, 55, 150, 19);
		frame.getContentPane().add(lblSearchAndUpdate_1);
		
		JLabel lblDelete = new JLabel("Delete");
		lblDelete.setBounds(601, 321, 56, 16);
		frame.getContentPane().add(lblDelete);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(544, 88, 56, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(544, 117, 74, 16);
		frame.getContentPane().add(lblPassword);
		
		inName = new JTextField();
		inName.setBounds(622, 85, 116, 22);
		frame.getContentPane().add(inName);
		inName.setColumns(10);
		
		inPass = new JPasswordField();
		inPass.setBounds(622, 117, 116, 21);
		frame.getContentPane().add(inPass);
		
		
		JComboBox uNameCombo = new JComboBox();
		uNameCombo.setBounds(910, 81, 116, 22);
		frame.getContentPane().add(uNameCombo);
		
		JComboBox dNameCombo = new JComboBox();
		dNameCombo.setBounds(703, 350, 116, 22);
		frame.getContentPane().add(dNameCombo);
		
	
		JButton btnInsert_1 = new JButton("Insert");
		btnInsert_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					String name = inName.getText();
					String pass = inPass.getText();

					userC.createUser(user, name, pass);
					
					uNameCombo.removeAllItems();
					dNameCombo.removeAllItems();
					userC.fillComboUser(uNameCombo);
					userC.fillComboUser(dNameCombo);
					//System.out.println("Blaaaa");
					inName.setText("");
					inPass.setText("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println("Completati corect toate campurile !");
				}
			}
		});
		btnInsert_1.setBounds(599, 283, 97, 25);
		frame.getContentPane().add(btnInsert_1);
		
		JLabel lblNewName = new JLabel("New name:");
		lblNewName.setBounds(795, 120, 74, 16);
		frame.getContentPane().add(lblNewName);
		
		JLabel lblNewPassword = new JLabel("New password:");
		lblNewPassword.setBounds(795, 149, 103, 16);
		frame.getContentPane().add(lblNewPassword);
		
		uPass = new JPasswordField();
		uPass.setBounds(910, 144, 116, 21);
		frame.getContentPane().add(uPass);
		
		uName = new JTextField();
		uName.setColumns(10);
		uName.setBounds(910, 114, 116, 22);
		frame.getContentPane().add(uName);
		
		JLabel label_7 = new JLabel("Name:");
		label_7.setBounds(795, 88, 56, 16);
		frame.getContentPane().add(label_7);
		
		
		
		
		JButton btnView_1 = new JButton("View");
		btnView_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = uNameCombo.getSelectedItem().toString();
				uName.setText(name);
				userC.readUser(name, uPass);
			}
		});
		btnView_1.setBounds(772, 283, 97, 25);
		frame.getContentPane().add(btnView_1);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String name = uNameCombo.getSelectedItem().toString();
					String newName = uName.getText();
					String newPass = uPass.getText();
					
					userC.updateUser(name, newName, newPass);
					uNameCombo.removeAllItems();
					dNameCombo.removeAllItems();
					userC.fillComboUser(uNameCombo);
					userC.fillComboUser(dNameCombo);
					
					uName.setText("");
					uPass.setText("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println("Completati corect toate campurile !");
				}
				
			}
		});
		btnUpdate_1.setBounds(929, 283, 97, 25);
		frame.getContentPane().add(btnUpdate_1);
		

		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(635, 350, 56, 16);
		frame.getContentPane().add(lblName_1);
		
		JButton button_1 = new JButton("Delete");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = dNameCombo.getSelectedItem().toString();
				userC.deleteUser(name);
				
				dNameCombo.removeAllItems();
				uNameCombo.removeAllItems();
				userC.fillComboUser(uNameCombo);
				userC.fillComboUser(dNameCombo);
			}
		});
		button_1.setBounds(676, 409, 97, 25);
		frame.getContentPane().add(button_1);
	/*	btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contr.deserializeObj();
				contr.fillComboBook(uTitleCombo);
				contr.fillComboBook(dTitleCombo);
				
				
				
			}
		});*/
		
		//contr.deserializeObj();
		bookC.fillComboBook(uTitleCombo);
		bookC.fillComboBook(dTitleCombo);
		
		userC.fillComboUser(uNameCombo);
		userC.fillComboUser(dNameCombo);
		
		JButton btnSaveData = new JButton("Save data");
		btnSaveData.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSaveData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userC.serializeObj(userC);
				bookC.serializeObj(bookC);
			}
		});
		btnSaveData.setBounds(315, 461, 116, 25);
		frame.getContentPane().add(btnSaveData);
		
		JLabel lblTitle_1 = new JLabel("New title:");
		lblTitle_1.setBounds(267, 117, 74, 16);
		frame.getContentPane().add(lblTitle_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(503, 462, 97, 25);
		frame.getContentPane().add(btnBack);
		
	
	}

}
