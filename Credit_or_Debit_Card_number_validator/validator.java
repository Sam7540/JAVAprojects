package pack01;
import java.util.*;

class validator {
    public static void main(String[] args) {
        int sum1=0, sum2=0, temp;
        String cardno = new String();
        Scanner sc = new Scanner(System.in);
        try {
        System.out.print("Enter card number: ");
        cardno = sc.nextLine();
        if(cardno.length() == 13 || cardno.length() == 15 || cardno.length() == 16) { }
        else throw new RuntimeException();
        for(int i=cardno.length()-2; i>=0; i-=2) {
            temp = Character.getNumericValue(cardno.charAt(i))*2;
            sum1 += temp%10 + temp/10;     
        }
        for(int i=cardno.length()-1; i>=0; i-=2) 
            sum2 += Character.getNumericValue(cardno.charAt(i));
        if( (sum1+sum2)%10 != 0) throw new RuntimeException();
        temp = Integer.parseInt(cardno.substring(0,2));
        System.out.print("Cardtype: ");
        if(temp == 34 || temp == 37) System.out.print("American Express");
        else if(temp >= 51 && temp <= 55) System.out.print("MasterCard");
        else if(Character.getNumericValue(cardno.charAt(0)) == 4) System.out.print("VISA");
        else if(Character.getNumericValue(cardno.charAt(0)) == 6) System.out.print("RUPAY");
        else throw new RuntimeException();
        }
        catch(Exception e) { System.out.println("Sorry! Your Card Number is Invalid"); }
        finally { sc.close(); } 
    }
}
