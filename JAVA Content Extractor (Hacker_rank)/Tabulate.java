package com.dutta;
import java.util.Scanner;

public class Tabulate
{
    public static void main(String... args)
    {
        int i = 0, j = 0, x = 0, count = 0, no_of_char = 0, extra = 0,use;
        boolean tempx = true, tempx1 = true, validate = true, validate1 = false, test = false;
        int locate[] = new int[10];
        char temp[] = new char[100];
        char temp1[] = new char[100];
        int length[] = new int[2];
        char main[][] = new char[20][20];
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '<')
            {
                locate[x] = i;
                count++;
                for (j = i; !(s.charAt(j) == '>'); j++)
                {
                    if (tempx)
                        no_of_char++;
                    temp[j] = s.charAt(j);
                }
                tempx = false;
                temp[j] = '>';
                x++;
                i = j;
                if (validate1) { validate = false; validate1 = false; }
            }
            else
            {
                if (validate)
                {
                    temp1[i] = s.charAt(i);
                    if (temp1[i] == '>')
                    {
                        System.out.println("Error: Contents between the tags are invalid");
                        System.exit(1);
                    }
                    validate1 = true;
                }
                else
                {
                    System.out.println("Error: Contents are written at invalid position ");
                    System.exit(1);
                }
            }
        }

        j = (count / 2) - 1;
        for (i = 0; i < 2; i++)
        {
            if (i == 0) length[i] = locate[j] + no_of_char;
            else length[i] = locate[j];
            j++;
        }

        if (length[1] - length[0] == 1)
        {
            System.out.println("Error: Contents are not written between the tags");
            System.exit(1);
        }

        for (i = 0; i < count; i++)
        {
            use = locate[i] + 1;
            for (j = 0; j < (no_of_char - 1); j++)
            {
                if (i >= count / 2) { if (temp[locate[i] + 1] == '/') main[i][j] = temp[use + 1]; }
                else
                    main[i][j] = temp[use];
                use++;
            }
        }

        int ab = count - 1;
        for (i = 0; i < (count / 2); i++)
        {
            for (j = 0; j <= (count / 2); j++)
            {
                if (main[i][j] == main[ab][j]) { if (i == (count / 2) - 1 && j == (count / 2) - 1) test = true; }
                else
                {
                    System.out.println("Error: Tags are not same");
                    System.exit(1);
                }
            }
            ab--;
        }

        if (test)
        {
            System.out.println("Tags and Contents are valid");
            System.out.println(new StringBuilder("Contents are: ").append(temp1));
            System.out.print("No. of tags:"+count+" length of tags:"+(no_of_char-1));
        }
    }
}
