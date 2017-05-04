package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.itextpdf.text.log.SysoLogger;

import javax.swing.JButton;

import Controller.BookController;

import Controller.UserController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserFrame {

	JFrame frame;
	private JFrame frame1;
	private JTextField textField;
	private JButton btnSearch;
	private JLabel lblSellBook;
	private JComboBox sellCombo;
	private JButton btnSell;
	private JLabel lblTitle;
	private JLabel lblQuantity;
	private JTextField quaField;
	private JButton btnSaveData;
	private MessageFactory messageFactory = new MessageFactory();
	private FoundMessageBox found;
	private NotFoundMessageBox notFound;
	private JButton btnBack;
	private BookController bookC;
	private UserController userC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame window = new UserFrame();
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
	public UserFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		
		userC = new UserController();
		userC.deserializeObj();
		
		bookC = new BookController();
		bookC.deserializeObj();

		
		frame = new JFrame();
		frame.setBounds(100, 100, 717, 337);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSearchBooksBy = new JLabel("Search books by");
		lblSearchBooksBy.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSearchBooksBy.setBounds(12, 34, 169, 33);
		frame.getContentPane().add(lblSearchBooksBy);
		
		JComboBox searchCombo = new JComboBox();
		searchCombo.setBounds(69, 145, 169, 33);
		frame.getContentPane().add(searchCombo);
		
		searchCombo.addItem("genre");
		searchCombo.addItem("title");
		searchCombo.addItem("author");
		
		textField = new JTextField();
		textField.setBounds(69, 80, 169, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String choice = searchCombo.getSelectedItem().toString();
					String info = textField.getText();
					
					if(bookC.searchBook(choice, info))
						{
//							System.out.println("1");
//							Message message1= messageFactory.getMessage("Found");
//							System.out.println(2);
//							frame1 = message1.getFrameMessage();
//							frame1.setVisible(true);
							found = new FoundMessageBox();
							found.frame.setVisible(true);
						
						}
					else
						{
						System.out.println("1");
						Message message1= messageFactory.getMessage("Found");
						System.out.println(2);
						frame1 = message1.getFrameMessage();
						frame1.setVisible(true);
						//message1.frame.setVisible(true);
						//	notFound = new NotFoundMessageBox();
							//notFound.frame.setVisible(true);
						}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//System.out.println("Completati corect campul !");
				}
				
			}
		});
		btnSearch.setBounds(97, 214, 97, 25);
		frame.getContentPane().add(btnSearch);
		
		lblSellBook = new JLabel("Sell book");
		lblSellBook.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSellBook.setBounds(387, 39, 143, 23);
		frame.getContentPane().add(lblSellBook);
		
		sellCombo = new JComboBox();
		sellCombo.setBounds(435, 80, 177, 33);
		frame.getContentPane().add(sellCombo);
		
		bookC.fillComboBook(sellCombo);
		
		btnSell = new JButton("Sell");
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sellB = sellCombo.getSelectedItem().toString();
				int qua = Integer.parseInt(quaField.getText());
				
				bookC.sellBook(sellB, qua);
				
			}
		});
		btnSell.setBounds(433, 214, 97, 25);
		frame.getContentPane().add(btnSell);
		
		lblTitle = new JLabel("Title:");
		lblTitle.setBounds(341, 88, 56, 16);
		frame.getContentPane().add(lblTitle);
		
		lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(341, 153, 56, 16);
		frame.getContentPane().add(lblQuantity);
		
		quaField = new JTextField();
		quaField.setBounds(435, 150, 177, 33);
		frame.getContentPane().add(quaField);
		quaField.setColumns(10);
		
		btnSaveData = new JButton("Save data");
		btnSaveData.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSaveData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookC.serializeObj(bookC);
			}
		});
		btnSaveData.setBounds(183, 252, 108, 25);
		frame.getContentPane().add(btnSaveData);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(331, 253, 97, 25);
		frame.getContentPane().add(btnBack);
	}
}
