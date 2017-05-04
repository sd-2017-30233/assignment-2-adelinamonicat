package Model;

import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5865854328548352616L;
	private String name;
	private String pass;

	public User(String name, String pass){
		this.name = name;
		this.pass = pass;
	}
	
	public String getName() {
		return name;
	}


	public String getPass() {
		return pass;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}

}
