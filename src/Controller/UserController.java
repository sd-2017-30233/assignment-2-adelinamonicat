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

import Model.User;

public class UserController implements Serializable{
	private List<User> userList = new ArrayList<User>();
	
	public void createUser(User user, String uName, String uPass){
		user = new User(uName, uPass);
		userList.add(user);
	}
	
	public void readUser(String uName, JTextField pass){
		
		for (int i = 0; i < userList.size(); i++)
		{
			if (userList.get(i).getName().equals(uName))
				//System.out.println(user.getName() + " " + user.getPass());
			{
				pass.setText(userList.get(i).getPass());
				
			}
		}
				
		
	}
	
	public void updateUser(String oldName, String newName, String newPass){
		
		for (int i = 0; i < userList.size(); i++)
		{
			if (userList.get(i).getName().equals(oldName))
				{
				userList.get(i).setName(newName);
				userList.get(i).setPass(newPass);
				break;
				}
			
		}
		
	}
	
	public void deleteUser(String uName){
		for (int i = 0; i < userList.size(); i++)
		{
			if (userList.get(i).getName().equals(uName))
				userList.remove(userList.get(i));
		}
	}
	
	
	public void fillComboUser(JComboBox combo)
	{for (int i = 0; i < userList.size();i++){
		System.out.println("ade");
		combo.addItem(userList.get(i).getName());
	}}
	
	public boolean foundUser(String name, String pass){
		boolean found = false;
		System.out.println(userList.size());
		for (int i = 0; i < userList.size(); i++){
			
			if (userList.get(i).getName().equals(name) && userList.get(i).getPass().equals(pass))
				{found = true;
				break;
				}
		}	

		System.out.println("hereeeeeeee"+found);
		return found;
	}
	
	public int checkLogin(String userName, String pass){
		int mode = 0;
		
		if (userName.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin"))
			mode = 1;
		else 
			{System.out.println("start");
			
				if (foundUser(userName, pass))
					{
					System.out.println("Gasiiit");
					mode = 2;	
					
					}}
			
		
		return mode;
	}
	public void serializeObj(UserController userC){
		try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream("saveUser.xml");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         
	         out.writeObject(userC);
	         out.flush();
	         out.close();
	         fileOut.close();
	         System.out.println("data was saved!");
	         
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	
	public void deserializeObj(){
		UserController userC = new UserController();
	      try
	      {
	         FileInputStream fileIn = new FileInputStream("saveUser.xml");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         userC = (UserController) in.readObject();
	         in.close();
	         fileIn.close();
	         userList = userC.userList;
	       
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         
	         c.printStackTrace();
	         return;
	      }	      
	}
	
	
}
