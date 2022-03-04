package Store;

import java.util.Scanner;

import FileIO.User;
import Food.*;

public class Process 
{
    // Creating Storage Object
    public static Storage[] createStorageArray(int[] capacityArr)
    {
        Storage[] storeAreas = new Storage[3];

        storeAreas[0] = new Storage("pantry", capacityArr[0]);
        storeAreas[1] = new Storage("freezer", capacityArr[1]);
        storeAreas[2] = new Storage("fridge", capacityArr[2]);

        return storeAreas;
    }

    public static void toStorage(Food inFood, Storage[] storeArea)
    {
        double foodTemp = inFood.getTemp();

        if (foodTemp > -27.0 && foodTemp < -5.0 )
        {
            storeArea[1].addFood(inFood);
        }
        else if (foodTemp > -2.0 && foodTemp < 6.0)
        {
            storeArea[2].addFood(inFood);
        }
        else if (foodTemp > 8.0 && foodTemp < 25.0)
        {
            storeArea[0].addFood(inFood);
        }
    }

    public static void outStorage(String storeName, Storage[] storeArea, String name)
    {
        switch (storeName.toLowerCase())
        {
            case "pantry":
                storeArea[0].removeFood(name);
                break;

            case "freezer":
                storeArea[1].removeFood(name);
                break;

            case "fridge":
                storeArea[2].removeFood(name);
                break;

            default:
                System.out.println("This storage location does not exist!");
        }
    }

    // Creating Food Object
    public static Food toFood(String inString)
    {
        String[] strArr;
        Food out = null;

        strArr = inString.split(",");
        for (int ii = 0; ii < strArr.length; ii++)
        {
            strArr[ii] = strArr[ii].trim();
        }

        switch(strArr[0].toLowerCase())
        {
            case "meat":
                out = new Meat(strArr[0], strArr[1], strArr[2], 
                               Double.parseDouble(strArr[3]), 
                               Double.parseDouble(strArr[4]), 
                               strArr[5], strArr[6]);
                break;

            case "grain":
                out = new Grain(strArr[0], strArr[1], strArr[2], 
                                Double.parseDouble(strArr[3]), 
                                Double.parseDouble(strArr[4]), 
                                strArr[5], strArr[6]);
                break;

            case "fruit":
                out = new Fruit(strArr[0], strArr[1], strArr[2],
                                Integer.parseInt(strArr[3]),
                                Double.parseDouble(strArr[4]),
                                strArr[5], strArr[6]);
                break;

            case "vegetable":
                out = new Vegetable(strArr[0], strArr[1], 
                                    Double.parseDouble(strArr[2]), 
                                    Double.parseDouble(strArr[3]), 
                                    strArr[4], strArr[5]);
                break;
        }

        return out;
    }

    //Manual User Input Functions
    public static Food userAddFood(Scanner u_input)
    {
        Food food = null;
        int decision;
        boolean validFood = false;
        String combinedInput = "", foodType;
        
        do
        {
            System.out.println("What kind of food do you want to add?\n"+
                               "(1) Meat\n"  +
                               "(2) Grain\n" +
                               "(3) Fruit\n" +
                               "(4) Vegetable\n");

            decision = FileIO.User.intInput(u_input, "Food Type:");

            switch (decision)
            {
                case 1:
                    foodType = "Meat";
                    combinedInput = "Meat, ";
                    combinedInput += foodInput("Name", foodType, u_input);
                    combinedInput += foodInput("Cut", foodType, u_input);
                    combinedInput += foodInput("Weight", foodType, u_input);
                    combinedInput = commonInput(combinedInput, u_input);
                    food = toFood(combinedInput);
                    validFood = true;
                    break;
                
                case 2:
                    foodType = "Grain";
                    combinedInput = "Grain, ";
                    combinedInput += foodInput("Name", foodType, u_input);
                    combinedInput += foodInput("Type", foodType, u_input);
                    combinedInput += foodInput("Volume", foodType, u_input);
                    combinedInput = commonInput(combinedInput, u_input);
                    food = toFood(combinedInput);
                    validFood = true;
                    break;
    
                case 3:
                    foodType = "Fruit";
                    combinedInput = "Fruit, ";
                    combinedInput += foodInput("Name", foodType, u_input);
                    combinedInput += foodInput("Type", foodType, u_input);
                    combinedInput += foodInput("Number", foodType, u_input);
                    combinedInput = commonInput(combinedInput, u_input);
                    food = toFood(combinedInput);
                    validFood = true;
                    break;
                
                case 4:
                    foodType = "Vegetable";
                    combinedInput = "Fruit, ";
                    combinedInput += foodInput("Name", foodType, u_input);
                    combinedInput += foodInput("Weight", foodType, u_input);
                    combinedInput = commonInput(combinedInput, u_input);
                    food = toFood(combinedInput);
                    validFood = true;
                    break;
                
                default:
    
            }
        }
        while (validFood == false);

        return food;
    }

    public static String commonInput(String inStr, Scanner u_input)
    {
        System.out.println("Temperature Needed to Store Product: ");
        inStr += User.strInput(u_input, "Temp: ") + ", ";

        System.out.println("Best Before/Expiry/Use by Date of Product: ");
        inStr += User.strInput(u_input, "Date: ") + ", ";

        System.out.println("Packinging Used by Product: ");
        inStr += User.strInput(u_input, "Packaging: ") + ", ";

        return inStr;
    }

    public static String foodInput(String quantifier, String typeOfFood, Scanner u_input)
    {
        System.out.println(quantifier + " of " + typeOfFood);
        return User.strInput(u_input, (quantifier + ": ")) + ", ";
    }
}
