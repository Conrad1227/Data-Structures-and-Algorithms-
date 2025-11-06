
/**
 * Class for fish animal with unique methods
 *
 * @author Conrad Hahn
 * @version 2/17/2025
 */
public class Fish extends Animal
{
    /**
     * Fish constructor with given values for gender and age
     * 
     * @param agein age of fish being initialized
     * @param sexin sex of fish being initialized as an int
     */
    public Fish(int agein, int sexin){
        //sets gender of fish based on int input
        if(sexin == 0){
            sex = sex.FEMALE;
        } else {
            sex = sex.MALE;
        }
        if(agein>=5){
            age=5;
        }else if (agein<0){
            age = 0; 
        }else{
            age = agein;
        }
    }
    /**
     * Fish constructor with random gender and age
     */
    public Fish()
    {
        //sets age and sex to random int
        age = rng.nextInt(5);
        int rngsex = rng.nextInt(2);
        //converts random int to gender
        if(rngsex == 0){
            sex = sex.FEMALE;
        } else {
            sex = sex.MALE;
        }
    }
    /**
     * increments the animals age
     * 
     * @return if the age was increased
     */
    public boolean ageUp(){
        //as long as the age isnt max it increments it and returns true
        if(age <= 4){
            age++;
            return true;
        }
        return false;
    }
    /**
     * checks if animal is at max age
     * 
     * @return if animal is at max age
     */
    public boolean maxAge(){
        //checking if the age is max and returning a boolean accordingly
        if(age >= 5){
            return true;
        } else {
            return false;
        }
    }
}