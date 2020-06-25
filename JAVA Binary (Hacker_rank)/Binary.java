package hackerrank;
import java.util.*;

public class Binary {

	public static void main(String[] args) {
		
		int remainder=0,count=0,max=0,once=0;
		long temp=0;
		boolean con=false;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n!=0)
		{
			remainder = n%2;
			if(once==0 && remainder==0)
			{
				temp=1;
				con = true;
			}
			if(remainder == 1) count++;
			else
			{
				if(count>max)
					max = count;
				count = 0;
			}
			temp = (temp*10)+remainder;
			n = n/2;
			once++;
		}
		if(remainder == 1 )
		{
			if(count>max)
				max = count;
		}
		StringBuffer s2 = new StringBuffer(Long.toString(temp));
		if(con) s2.replace(0, 1, "");
		s2 = s2.reverse();
		System.out.println(s2+" "+max);
		sc.close();
	}

}
