package FileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Food.Food;
import Store.Storage;

public class FileWrite 
{
    public static void writeStorage(Storage[] storeArea, String fileName)
    {
        List<Food> inv;

        try 
        {
            FileWriter fw = new FileWriter(fileName);
            for (int ii = 0; ii < storeArea.length; ii++)
            {
                fw.write(storeArea[ii].getName() + ", " + storeArea[ii].getMaxCapacity() + "\n");
            }

            fw.write("\n");

            for (int ii = 0; ii < storeArea.length; ii++)
            {
                inv = storeArea[ii].getInventory();
                for (Food temp : inv)
                {
                    fw.write(temp.getType() + ", " + temp.toString() + "\n");
                }
            }

            fw.close();
        } 
        catch (IOException e) 
        {
            System.out.println(e.getMessage());
        }
    }
}
