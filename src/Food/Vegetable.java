package Food;

import java.util.Calendar;

public class Vegetable extends Food
{
    private double weight;

    public Vegetable(String inType, String inName, double inWeight, double inTemp, String inDate, String inPack)
    {
        super(inType, inName, inPack, inDate, inTemp);
        weight = inWeight;
    }

    public double getWeight()
    {
        return weight;
    }

    public String toString()
    {
        return getName() + ", " + Double.toString(getWeight()) + ", " + Double.toString(getTemp()) + ", " + getDate() + ", " + getPack();
    }

    @Override
    public boolean calcExpiry(Calendar date)
    {
        return super.calcExpiry(date);
    }

    @Override
    public int calcSpace(Food food)
    {
        return (int) Math.ceil(weight * 1.025f);
    }

    @Override
    public boolean validateAmount(String numStr)
    {
        boolean valid = false;
        double num = Double.parseDouble(numStr);

        if ((num <= 20.0) && (num >= 0.2))
        {
            valid = true;
        }

        return valid;
    }
}
