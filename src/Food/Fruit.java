package Food;

import java.util.Calendar;

public class Fruit extends Food
{
    private int numOfFruit;
    private String fruitType;

    public Fruit(String inType, String inName, String inFruitType, int inNum, double inTemp, String inDate, String inPack)    {
        super(inType, inName, inPack, inDate, inTemp);
        numOfFruit = inNum;
        fruitType = inFruitType;
    }

    public int getNumOfFruit()
    {
        return numOfFruit;
    }

    public String getFruitType()
    {
        return fruitType;
    }

    public String toString()
    {
        return getName() + ", " + getFruitType() + ", " + Integer.toString(getNumOfFruit()) + ", " + Double.toString(getTemp()) + ", " + getDate() + ", " + getPack();
    }

    @Override
    public boolean calcExpiry(Calendar date)
    {
        return super.calcExpiry(date);
    }

    @Override
    public int calcSpace(Food food)
    {
        return (int) Math.ceil(numOfFruit * 1.95f);
    }

    @Override
    public boolean validateAmount(String numStr)
    {
        boolean valid = false;
        int num = Integer.parseInt(numStr);

        if ((num <= 20) && (num >= 1))
        {
            valid = true;
        }

        return valid;
    }
}
