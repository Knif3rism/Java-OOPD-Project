package Food;

import java.util.Calendar;

public interface IFood 
{
    public boolean calcExpiry(Calendar today);
    public int calcSpace(Food food);
    public boolean validateAmount(String numStr);
}
