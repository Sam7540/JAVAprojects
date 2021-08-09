package sys.main;

import java.util.*;
import java.util.regex.*;

public class EmailValidator {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your e-mail: ");
		String email = sc.nextLine();
		
		Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
		Matcher m = p.matcher(email);
		
		if(m.matches()) 
			System.out.println("It is a valid email-id");
		else
			System.out.println("It is an invalid email");
		
		sc.close();
	}
}
