package imp_pack;
import java.util.*;

class Encryption
{
	StringBuilder main; int key;
	String plaintext = "abcdefghijklmnopqrstuvwxyz";
	Encryption(StringBuilder temp)
	{
		main = new StringBuilder(temp);
	} 
	void changer(int i)
	{
		int index; char c;
		if( (index = plaintext.indexOf( Character.toLowerCase(main.charAt(i)) )) != -1)
		{
			c = plaintext.charAt( (index+key)%26 );
			if( Character.isUpperCase(main.charAt(i)) )
				main.setCharAt(i, Character.toUpperCase(c));
			else
				main.setCharAt(i, c);
		}
	}
	void encryptText(int key, int choice)
	{		
		this.key = key;
		for(int i=0; i<main.length(); i++)
			changer(i);
		if(choice==1) System.out.println("Your Encrypted Text is:\n"+main);
		else System.out.println("Your Decrypted Text is:\n"+main);
	}
	void enhancedEncrypt(int key1, int key2)
	{		
		key = key1;
		for(int j=0; j<2; j++)
		{	
			for(int i=j; i<main.length(); i += 2)
				changer(i);
			key = key2;
		}
		System.out.println("Your Encrypted Text is:\n"+main);
	}
}
public class Ceaser_cipher {
	public static void main(String... args)
	{
		int key=0, choice, key2;
		String text;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your string:");
		text = sc.nextLine();
		try
		{	
			Encryption encrypt = new Encryption(new StringBuilder(text));
			System.out.println("*****Menu*****");
			System.out.println("1. Encryption\n2. Decryption\n3. Enhanced Encryption\nEnter your choice: ");
			switch((choice = sc.nextInt()) )
			{
			case 1:
				System.out.println("Enter the key:");
				key = (sc.nextInt())%26;		
				encrypt.encryptText(key, choice);
				break;
			case 2:
				System.out.println("Enter the key:");
				key = (sc.nextInt())%26;
				encrypt.encryptText(26-key, choice);
				break;
			case 3:
				System.out.println("Enter key1:");
				key = (sc.nextInt())%26;
				System.out.println("Enter key2:");
				key2 = (sc.nextInt())%26;
				encrypt.enhancedEncrypt(key, key2);
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Sorry! Your Entered key is not a number. Try Again!");
		}
		sc.close();
	}
}
