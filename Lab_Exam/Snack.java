
/**
 * Write a description of class Snack here.
 *
 * @author Conrad Hahn
 * @version 4/9/2025
 */
public class Snack
{
    // instance variables - replace the example below with your own
    private String snackName;
    private int calories;

    /**
     * Constructor for objects of class Snack
     */
    public Snack()
    {
        this.snackName = "";
        this.calories = 0;
    }
    
    public Snack(String name, int cals)
    {
        this.snackName = name;
        this.calories = cals;
    }

    public int getCalories()
    {
        return calories;
    }

    public String getSnackName()
    {
        return snackName;
    }

    public void setCalories(int val)
    {
        this.calories = val;
    }

    public void setSnackName(String name)
    {
        this.snackName = name;
    }
}
