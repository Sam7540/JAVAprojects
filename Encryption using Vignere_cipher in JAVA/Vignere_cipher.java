package imp_pack;
import java.util.*;

class Textencryptor
{
	StringBuilder main;
	Textencryptor(String temp)
	{
		main = new StringBuilder(temp);
	}
	void Encryptor(String key, int choice)
	{
		String plaintext = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder keystring = new StringBuilder(key);
		while(keystring.length() < main.length())
			keystring.append(key);
		keystring.replace(0, keystring.length(), keystring.substring(0));
		for(int i=0,j=0; i<main.length(); i++)
		{
			int x,y; char c = '\0';
			if( (x = plaintext.indexOf( Character.toLowerCase(main.charAt(i)) )) != -1 && (y = plaintext.indexOf( Character.toLowerCase(keystring.charAt(j)) )) != -1)
			{	
				if(choice == 1) c = plaintext.charAt( (x+y)%26 );
				else c = plaintext.charAt( (x-y+26)%26 );
				if( Character.isUpperCase(main.charAt(i)) )
					main.setCharAt(i, Character.toUpperCase(c));
				else
					main.setCharAt(i, c);
				j++;
			}
		}
		if(choice == 1) System.out.println("Your Encrypted Text is:\n"+main);
		else System.out.println("Your Decrypted Text is:\n"+main);
	}
}
public class Vignere_cipher {
	public static void main(String...strings)
	{
		String main, key;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your text:");
		main = sc.nextLine();
		System.out.println("Enter your key:");
		key = sc.nextLine();
		Textencryptor enc = new Textencryptor(main);
		System.out.println("*****Menu****\n1. Encryption\n2. Decryption\nEnter your choice: ");
		enc.Encryptor(key, sc.nextInt());
		sc.close();
	}
}
