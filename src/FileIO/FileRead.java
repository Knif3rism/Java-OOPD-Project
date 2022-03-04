package FileIO;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FileRead 
{
    public static int[] readStorageSize(String fileName)
    {
        int counter = 0;
        String temp;

        int intArr[] = new int[3];
        String strArr[];

        try
        {
            FileInputStream fileStream = new FileInputStream(fileName);
            Scanner sc = new Scanner(fileStream);

            while ((sc.hasNextLine()) && (counter < 3))
            {
                temp = sc.nextLine();
                strArr = temp.split(",");
                
                if (strArr[0].toLowerCase().equals("pantry"))
                {
                    intArr[0] = Integer.parseInt(strArr[1].strip());
                }
                else if (strArr[0].toLowerCase().equals("freezer"))
                {
                    intArr[1] = Integer.parseInt(strArr[1].strip());
                }
                else if (strArr[0].toLowerCase().equals("fridge"))
                {
                    intArr[2] = Integer.parseInt(strArr[1].strip());
                }

                counter++;
            }
            sc.close();

        }
        catch (FileNotFoundException e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }

        return intArr;
    }

    public static List<String> readInventory(String fileName)
    {
        List<String> list = new ArrayList<String>();

        try
        {
            FileInputStream fileStream = new FileInputStream(fileName);
            Scanner sc = new Scanner(fileStream);

            for (int ii = 0; ii < 4; ii++)
            {
                sc.nextLine();
            }

            while (sc.hasNextLine())
            {
                list.add(sc.nextLine());
            }

            sc.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }


        return list;
    }

    public static int fileLine(String fileName)
    {
        int count = 0;

        try
        {
            FileInputStream fileStream = new FileInputStream(fileName);
            Scanner sc = new Scanner(fileStream);

            while (sc.hasNextLine())
            {
                count++;
            }

            sc.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }

        return count;
    }
}
