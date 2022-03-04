import java.util.List;
import java.util.Scanner;

import Food.Food;
import Store.Process;
import Store.Storage;

public class Main
{
    public static void main(String[] args) 
    {
        int decision = 1;
        boolean hasReadFile = false;

        Scanner u_input = new Scanner(System.in);
        String strTemp, strTemp2;
        int[] capacityArr;
        List<String> strList;
        Storage[] storeArea = null;

        Food tempFood;

        while (decision != 0)
        {
            System.out.println("\nPlease Select One of the Options Below?\n"+
            "(1) Add Food\n"  +
            "(2) Remove Food\n" +
            "(3) Find Expired\n" +
            "(4) Display Contents\n" +
            "(5) Read In Storage\n" +
            "(6) Write Out Storage\n" +
            "(0) Exit\n");

            decision = FileIO.User.intInput(u_input, "Menu Select: ");

            switch (decision)
            {
                //Add food
                case 1:
                    if (hasReadFile)
                    {
                        tempFood = Process.userAddFood(u_input);
                        Process.toStorage(tempFood, storeArea);
                    }
                    else
                    {
                        System.out.println("Please use select a file first.");
                    }
                    
                    break;
                
                //Remove food
                case 2:
                    if (hasReadFile)
                    {
                        System.out.println("Remove a food item by stating the name "+
                                           "of the store area you want to select " +
                                           "and then the item you want to remove");

                        strTemp = FileIO.User.strInput(u_input, "Store Area: ");
                        strTemp2 = FileIO.User.strInput(u_input, "Food: ");
                        Store.Process.outStorage(strTemp, storeArea, strTemp2);

                    }
                    else
                    {
                        System.out.println("Please use select a file first.");
                    }

                    break;

                //Find Expired
                case 3:
                    if (hasReadFile)
                    {
                        for (int ii = 0; ii < storeArea.length; ii++)
                        {
                            storeArea[ii].findExpired();
                        }
                    }
                    else
                    {
                        System.out.println("Please use select a file first.");
                    }

                    break;

                //Display Contents
                case 4:
                    if (hasReadFile)
                    {
                       for (int ii = 0; ii < storeArea.length; ii++)
                       {
                           storeArea[ii].display();
                       }
 
                    }
                    else
                    {
                        System.out.println("Please use select a file first.");
                    }
                    
                    break;

                //Read in storage
                case 5:
                    strTemp = FileIO.User.strInput(u_input, "File: ");
                    capacityArr = FileIO.FileRead.readStorageSize(strTemp);
                    strList = FileIO.FileRead.readInventory(strTemp);

                    storeArea = Store.Process.createStorageArray(capacityArr);

                    for (String temp : strList)
                    {
                        tempFood = Store.Process.toFood(temp);
                        Store.Process.toStorage(tempFood, storeArea);
                    }

                    hasReadFile = true;

                    break;

                //Write out storage
                case 6:
                    System.out.println("Among Us");
                    break;

                case 0:
                    System.out.println("Exiting the inventory system");
                    break;
                
                default:
                    System.out.println("Input values between 1-6");
            }
        }
        
        u_input.close();
        System.out.println("Thank you and goodbye");
    }
}
