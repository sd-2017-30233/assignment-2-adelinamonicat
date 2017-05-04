package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NotFoundMessageBox implements Message{

	JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NotFoundMessageBox window = new NotFoundMessageBox();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public NotFoundMessageBox() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 351, 183);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBookNotFound = new JLabel("Book not found !");
		lblBookNotFound.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBookNotFound.setBounds(79, 49, 153, 25);
		frame.getContentPane().add(lblBookNotFound);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(103, 98, 97, 25);
		frame.getContentPane().add(btnBack);
	}

	@Override
	public JFrame getFrameMessage() {
		// TODO Auto-generated method stub
		return frame;
		
	}

}
