package abc;
import java.util.*;

/* Author: Soumyajit */

class logic
{
	private int x1=1,x2,x3,x4;
    private final int temp;
    private boolean b1=true,b2=true;
	public logic(int temp)
	{
		this.temp=temp;
	}
	public void setdata()
	{
		x3=65+temp+(temp-3);
		x2=65+((temp-1)/2);
		x4=x2+1;
	}
	public void getdata()
	{
		for(int j=0;j<temp;j++)
		{
			for(int i=0;i<temp;i++)
			{
				if( (j<=(temp-1)/2 && i==0) || (j==(temp-1)/2 && i>0 && i<(temp-1)/2) || (j==(temp-1)/2 && i>(temp-1)/2 && i<=(temp-1)) )
				{
					System.out.print(x1+" ");
					x1++;
				}
                else if((j>(temp-1)/2 && i==(temp-1)))
                {  
                	if(b1 && x1>15)
                	{
                		System.out.print("     ");
                		b2=false;
                	}    
                	else if(b2 && x1>12)
                	{
                		System.out.print("  ");
                		b1=false;
                	}
                	System.out.print(x1);
                	x1++;
                }   
				else if( (j==0 && i>=(temp-1)/2) || (j==(temp-1) && i<=(temp-1)/2) )
				{
					if(j==0)
					{
						System.out.print((char)x2+" ");
						x2--;
					}
					else
					{
						System.out.print((char)x3+" ");
						x3--;
					}
				}
				else if( (j>0 && j<(temp-1)/2 && i==(temp-1)/2) || (j>(temp-1)/2 && j<(temp-1) && i==(temp-1)/2) )
				{
					System.out.print((char)x4+" ");
					x4++;
				}
				else if(j==(temp-1)/2)
					System.out.print("* ");
				else 
					System.out.print("  ");
			}
			System.out.print("\n");
		}
	}
}
public class pattern 
{
	@SuppressWarnings("resource")
	public static void main(String... arg)
	{
		int i;
		System.out.println("Enter the size of the pattern (Only in odd numbers):");
		try
		{
			Scanner sc=new Scanner(System.in);
			i=sc.nextInt();
			logic l1=new logic(i);
			if(i>11)
				throw new Exception("Your entered number is out of range");
			System.out.println("Your structure formed of "+i+" size is:\n***Processing data***\n");
			Thread.sleep(1000);
			l1.setdata();
			l1.getdata();
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:"+e.getMessage());
		}
	}
}
