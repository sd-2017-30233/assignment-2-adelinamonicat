package View;

public class MessageFactory {
	public Message getMessage(String message) {
		System.out.println(message+ "mesajulllllll");
		if(message == null){
			System.out.println("oare aici?");
	         return null;
	      }	
		if (message.equalsIgnoreCase("Not Found")) {
			System.out.println("message  not found");
			return new NotFoundMessageBox();
		}
		else if(message.equalsIgnoreCase("Error")){
			System.out.println("message error found");
			return new Error();
		}
		else if(message.equalsIgnoreCase("Found")){
			System.out.println("message found");
			return new FoundMessageBox();
		}
		
		return null;

	}

}
