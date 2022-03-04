package Food;

import java.util.Calendar;

public class Grain extends Food
{
    private double volume;
    private String grainType;

    public Grain(String inType, String inName, String inGrainType, double inVolume, double inTemp, String inDate, String inPack)
    {
        super(inType, inName, inPack, inDate, inTemp);
        volume = inVolume;
        grainType = inGrainType;
    }

    public double getVolume()
    {
        return volume;
    }

    public String getGrainType()
    {
        return grainType;
    }

    public String toString()
    {
        return getName() + ", " + getGrainType() + ", " + Double.toString(getVolume()) + ", " + Double.toString(getTemp()) + ", " + getDate() + ", " + getPack();
    }

    @Override
    public boolean calcExpiry(Calendar date)
    {
        return super.calcExpiry(date);
    }

    @Override
    public int calcSpace(Food food)
    {
        return (int) Math.ceil(volume * 1.0f);
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
