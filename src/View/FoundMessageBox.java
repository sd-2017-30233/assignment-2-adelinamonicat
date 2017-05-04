package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FoundMessageBox implements Message {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoundMessageBox window = new FoundMessageBox();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public JFrame getFrameMessage() {
		return frame;

	}

	/**
	 * Create the application.
	*/
	public FoundMessageBox() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 233, 164);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblBookFound = new JLabel("Book found !");
		lblBookFound.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBookFound.setBounds(38, 24, 189, 32);
		frame.getContentPane().add(lblBookFound);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(48, 69, 97, 25);
		frame.getContentPane().add(btnBack);
	}

}
