package hackerrank;
import java.util.*;
 
/* Author: Soumyajit */

class Difference {
  	private int[] elements;
  	public int maximumDifference;
    int first, tempdiff, tempmax=0;
    public Difference(int[] x)
    {
        elements = x;
    }
    public void computeDifference()
    {
        for(int i=0; i<elements.length-1; i++)
        {
            first = elements[i];
            for(int j=i+1; j<elements.length; j++)
            {
            	tempdiff = Math.abs(first - elements[j]);
                if( tempdiff > tempmax)  tempmax = tempdiff;
            }
        }
        maximumDifference = tempmax;
    }

} // End of Difference class

public class Makedif {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}
