package Store;

import Food.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class Storage 
{
    /* 
     * Pantry  - arr[0]
     * Freezer - arr[1]
     * Fridge  - arr[2]
     * The first element is max size, second element is actual size
     */ 

    private String name;
    private int maxCapacity;
    private int currCapacity;
    private List<Food> inventory;

    public Storage(String inName, int capacity)
    {
        name = inName;
        maxCapacity = capacity;
        currCapacity = 0;
        inventory = new ArrayList<Food>();
    }

    public String getName()
    {
        return name;
    }

    public int getMaxCapacity()
    {
        return maxCapacity;
    }


    public int getCurrCapacity()
    {
        return currCapacity;
    }

    public List<Food> getInventory()
    {
        return inventory;
    }

    public int addFood(Food inFood)
    {
        int out = 0;
        int space;

        space = inFood.calcSpace(inFood);
        if ((space + currCapacity) < maxCapacity)
        {
            inventory.add(inFood);
        }
        else
        {
            out = 1;
        }

        return out;
    }

    public Food removeFood(String name)
    {
        Food out = null;
        int space;

        for (Food temp : inventory)
        {
            if (temp.getName().equals(name))
            {
                out = temp;
                inventory.remove(out);
                space = out.calcSpace(out);
                currCapacity = currCapacity - space;
            }
            
        }

        return out;
    }

    public void display()
    {
        System.out.println("\n-----" + name + "-----");

        for (Food temp : inventory)
        {
            System.out.println(temp.toString());
        }
    }

    public void findExpired()
    {
        Calendar cal;

        System.out.println("----- " + name + " -----");
        for (Iterator<Food> iterator = inventory.iterator(); iterator.hasNext();)
        {
            Food curr = iterator.next();
            cal = curr.getDateCalendar();
            if (cal.before(Calendar.getInstance()))
            {
                System.out.println(curr.toString());
                iterator.remove();
            }
        }

        
    }
}
