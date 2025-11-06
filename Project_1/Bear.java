/**
 * Class for bear animal with unique methods
 *
 * @author Conrad Hahn
 * @version 2/17/2025
 */
public class Bear extends Animal
{
    /**
     * Bear constructor with given values for gender and age
     * 
     * @param agein age of bear being initialized
     * @param sexin sex of bear being initialized as an int
     */
    public Bear(int agein, int sexin){
        //sets gender of bear based on int input
        if(sexin == 0){
            sex = sex.FEMALE;
        } else {
            sex = sex.MALE;
        }
        if(agein>=9){
            age=9;
        }else if (agein<0){
            age = 0; 
        }else{
            age = agein;
        }
    }
    /**
     * Bear constructor with random gender and age
     */
    public Bear()
    {
        //sets age and sex to random int
        age = rng.nextInt(10);
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
        if(age <= 8){
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
        if(age >= 9){
            return true;
        } else {
            return false;
        }
    }
}