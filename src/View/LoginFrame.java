package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;


import Controller.UserController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame {

	private JFrame frame;
	private JTextField uField;
	private JPasswordField passField;

	private Error err;
	private AdminFrame admin;
	private UserFrame user;
	private UserController uContr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
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
	public LoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		uContr = new UserController();
		
		uContr.deserializeObj();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(79, 54, 78, 23);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(79, 108, 78, 16);
		frame.getContentPane().add(lblPassword);
		
		uField = new JTextField();
		uField.setBounds(180, 54, 146, 22);
		frame.getContentPane().add(uField);
		uField.setColumns(10);
		
		passField = new JPasswordField();
		passField.setBounds(180, 105, 146, 23);
		frame.getContentPane().add(passField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = uField.getText();
				String pass = passField.getText();
				int mode = uContr.checkLogin(username, pass);
				if(mode == 0)
					{err = new Error();
					err.frame.setVisible(true);
					}
				
				else if (mode == 1)
					{admin = new AdminFrame();
					admin.frame.setVisible(true);
					}
				else 
					{user = new UserFrame();
					user.frame.setVisible(true);
					}
				uField.setText("");
				passField.setText("");
				
			}
		});
		btnLogin.setBounds(135, 185, 97, 25);
		frame.getContentPane().add(btnLogin);
	}
}
