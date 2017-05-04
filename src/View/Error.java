package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Error implements Message {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Error window = new Error();
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
	public Error() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 384, 207);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsernameInvalid = new JLabel("Username invalid !");
		lblUsernameInvalid.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsernameInvalid.setBounds(86, 39, 183, 35);
		frame.getContentPane().add(lblUsernameInvalid);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(121, 102, 97, 25);
		frame.getContentPane().add(btnBack);
	}

	@Override
	public JFrame getFrameMessage() {
		return frame;
		// TODO Auto-generated method stub
		
	}

}
