package newpack1;
import java.util.*;

public class Anagrams 
{
	static boolean isAnagram(String a,String b)
	{
		int length,numdec = 0,po = 1,no = 1;
		char temp;
		
		ArrayList<Character> l1 = new ArrayList<>();
		ArrayList<String> l2= new ArrayList<>();
		ArrayList<String> l3= new ArrayList<>();
				
		if( (a.length() != b.length()) || ((a == "" && b == "")))
			return false;
		
		for(int i=0; i<a.length(); i++)
			l1.add(a.charAt(i));
		
		length = a.length();
		for(int j=0; j<length-numdec; j++)
		{
			temp = l1.get(j);
			StringBuffer z1 = new StringBuffer();
			z1.insert(0, temp);
			z1.append("->"+po);
			String q = z1.toString();
			l2.add(q);

			for(int i=j+1; i<length-numdec; i++)
			{
				if(temp == l1.get(i))
				{
					po++;
					StringBuffer z2 = new StringBuffer();
					z2.insert(0, temp);
					z2.append("->"+po);
					String q1 = z2.toString();
					l2.set(j, q1);
					l1.remove(i);
					numdec++;
					i--;
				}
			}
			po = 1;
		}
		
		System.out.println("****Characters found are****");
		for(int x=0; x<a.length()-numdec; x++)
		{
			String temp1 = l2.get(x);
			System.out.print(temp1+" ");
			if(x==10)
				System.out.println("");
		}
		
		System.out.println("");
		l1.clear();
		numdec = 0;
		
		for(int i=0; i<b.length(); i++)
			l1.add(b.charAt(i));

		for(int j=0; j<length-numdec; j++)
		{
			temp = l1.get(j);
			StringBuffer z1 = new StringBuffer();
			z1.insert(0, temp);
			z1.append("->"+no);
			String q = z1.toString();
			l3.add(q);
			for(int i=j+1; i<length-numdec; i++)
			{
				if(temp == l1.get(i))
				{
					no++;
					StringBuffer z2 = new StringBuffer();
					z2.insert(0, temp);
					z2.append("->"+no);
					String q1 = z2.toString();
					l3.set(j, q1);
					l1.remove(i);
					numdec++;
					i--;
				}
			}
			no = 1;
		}
		
		for(int x=0; x<a.length()-numdec; x++)
		{
			if(l2.contains(l3.get(x))) { }
			else return false;
				
		}
		
		return true;
	}
		
	public static void main(String... args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your first string:");
		String a = sc.nextLine();
		System.out.println("Enter your second string");
		String b = sc.nextLine();
		
		if(isAnagram(a,b))
			System.out.println("It is an Anagrams");
		else
			System.out.println("It is not an Anagrams");
		sc.close();
	}
}
