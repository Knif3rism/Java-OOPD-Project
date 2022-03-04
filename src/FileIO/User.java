package FileIO;

import java.util.Scanner;

public class User 
{
    public static int intInput(Scanner u_input, String hintText)
    {
        System.out.print(hintText);
        String usr_input = u_input.nextLine();
        int out = Integer.parseInt(usr_input.trim());
        return out;
    }

    public static double doubleInput(Scanner u_input, String hintText)
    {
        System.out.print(hintText);
        String usr_input = u_input.nextLine();
        double out = Double.parseDouble(usr_input.trim());
        return out;
    }

    public static String strInput(Scanner u_input, String hintText)
    {
        System.out.print(hintText);
        String usr_input = u_input.nextLine();
        return usr_input;
    }
}
