package Food;

import java.util.Calendar;

public class Meat extends Food
{
    private String cut;
    private double weight;

    public Meat(String inType, String inName, String inCut, double inWeight, double inTemp, String inDate, String inPack)
    {
        super(inType, inName, inPack, inDate, inTemp);
        cut = inCut;
        weight = inWeight;
    }

    public String getCut()
    {
        return cut;
    }

    public double getWeight()
    {
        return weight;
    }

    public String toString()
    {
        return getName() + ", " + getCut() + ", " + Double.toString(getWeight()) + ", " + Double.toString(getTemp()) + ", " + getDate() + ", " + getPack();
    }

    @Override
    public boolean calcExpiry(Calendar date)
    {
        return super.calcExpiry(date);
    }

    @Override
    public int calcSpace(Food food)
    {
        return (int) Math.ceil(weight * 0.86f);
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
