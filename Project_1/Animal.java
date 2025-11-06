import java.util.Random;
/**
 * Animal class for river simulation
 *
 * @author Conrad Hahn
 * @version 2/16/2025
 */
public abstract class Animal
{
    //sample code given in lab for specifying animal sexuality
    protected enum Sex{
        FEMALE, MALE
    }
    //decleration of protected and abstract variables
    protected Sex sex; 
    protected int age;
    protected boolean updated;
    Random rng = new Random();
    abstract boolean maxAge();
    abstract boolean ageUp();
    /**
     * Constructor for animals with random variables
     */
    public Animal()
    {
        // initialize age with random value and set sex
        age = rng.nextInt(5);
        sex = Sex.FEMALE;
    }
    /**
     * constructor for animals with set age and gender
     * 
     * @param ageset age of animal being initialized
     * @param sexset sex of animal being initialized
     */
    public Animal(int ageset, Sex sexset){
        //set variables to parameters 
        age = ageset;
        sex = sexset;
    }
    /**
     * returns the age of animal
     *
     * @return age of the animal
     */
    public int getAge(){
        return age;
    }
    /**
     * getter for animals gender
     * 
     * @return gender 
     */
    
    public char getGender(){
        //check gender and return char accordingly
        if(sex.equals(sex.FEMALE)){
            return 'F';
        } else {
            return 'M';
        }
    }
     /**
     * turns the animals gender and age to a string output
     * 
     * @return gender and age 
     */
    public String toString(){
        char morf; 
        //checks for gender and sets char for each
        if(sex.equals(sex.MALE)){
            morf = 'M';
        } else {
            morf = 'F';
        }
        //returns char plus animals age
        return morf+Integer.toString(age);
    }
    //these methods are to prevent an animal from being updated repeadetly
    /**
     * checks if the animal has already been updated that cycle
     * @return if the animal had been updated
     */
    public boolean getUpdated(){
        return updated;
    }
    /**
     * sets updated to true
     */
    public void updatedSetTrue(){
        updated = true;
    }
    /**
     * sets updated to false
     */
    public void updatedSetFalse(){
        updated = false;
    }
}
