package Food;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Food implements IFood
{
    /* type - Type of Food i.e. Meat, Grain, Vegetable, Fruit
     * name - The name of the stored food
     * pack - Packaging type of the item
     * date - Used by or Best before date
     * temp - The temperature necessary for safe storage of the item
     */
    private String type, name, pack;
    private Calendar date;
    private double temp;

    public Food(String inType, String inName, String inPack, String inDate, double inTemp)
    {
        type = inType;
        name = inName;
        pack = inPack;
        date = processDate(inDate);
        temp = inTemp;
    }

    public String getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public String getPack()
    {
        return pack;
    }

    public String getDate()
    {
        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        return fmt.format(date.getTime());
    }

    public Calendar getDateCalendar()
    {
        return date;
    }

    public double getTemp()
    {
        return temp;
    }

    public String toString()
    {
        return this.toString();
    }

    //Private Methods
    private Calendar processDate(String date)
    {
        Calendar processed = null;
        String[] strArr;
        int[] dateArr = new int[3];

        strArr = date.split("/");
        if (strArr.length == 3)
        {
            processed = Calendar.getInstance();
            for (int ii = 0; ii < strArr.length; ii++)
            {
                dateArr[ii] = Integer.parseInt(strArr[ii]);
            }

            processed.set(dateArr[2], dateArr[1], dateArr[0]);
        }

        return processed;
    }

    public boolean calcExpiry(Calendar date)
    {
        Calendar currDate;
        int dateCompare;
        boolean expired = true;

        currDate = Calendar.getInstance();

        dateCompare = currDate.compareTo(date);

        if (dateCompare == -1)
        {
            expired = true;
        }
        else
        {
            expired = false;
        }

        return expired;
    }

    public int calcSpace(Food food)
    {
        return this.calcSpace(food);
    }
}
