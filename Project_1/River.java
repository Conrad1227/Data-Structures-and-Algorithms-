import java.util.Random;

/**
 * River that holds the simulation of the animals
 *
 * @author Conrad Hahn
 * @version 2/16/2025
 */
public class River
{
    //Variable declaration
    Random rng = new Random();
    public Animal [] river;
    public int riverlength;
    /**
     * Constructor for objects of class River
     * 
     * @param size specifies the length of the river
     */
    public River(int size)
    {
        //initializing array of animals inside river
        this.riverlength=size;
        if(riverlength<=0){
            riverlength=1;
        }
        river = new Animal[riverlength];
        for(int i = 0; i < riverlength;i++){
            int animalset = rng.nextInt(3);
            //randomly sets 
            if(animalset == 1){
               river[i] = new Fish();
            }else if(animalset == 0){
               river[i] = new Bear();
            }else if(animalset == 2){
               river[i] = null;
            }
        }
    }
    /**
     * gets the size of the river
     *
     * @return the size of the river
     */
    public int getSize (){
     return riverlength;
    }
     /**
     * gets a specific animals strength
     *
     * @param animal the animals strength that is being returned
     *
     * @return the animals strength
     */
    public int getStrength(Animal animal){
        int [] strength = {1,2,3,4,5,4,3,2,1,0};
        return strength[animal.getAge()];
    }
     /**
     * counts the number of empty spots in the river
     *
     * @return the number of open spots in the array
     */
    public int numEmpty(){
        int count = 0;
        for (int i=0; i < riverlength; i++){
            if(river[i]==null){
                count++;
            }
        }
        return count;
    }
     /**
     * adds a random animal to an empty spot in river
     *
     * @param animal animal in river array of animals
     *
     * @return if the array is empty return false or else return true
     */
    public boolean addRandom (Animal animal){
        int count = numEmpty();
        if(count == 0){
            return false;
        }
        int open = rng.nextInt(numEmpty());
        for(int i = 0; i < riverlength; i++){
            if(river[i]==null){
                if(open==0){
                    if(animal instanceof Bear){
                         river[i] = new Bear(0, rng.nextInt(2));
                    }
                    if(animal instanceof Fish){
                         river[i] = new Fish(0, rng.nextInt(2));
                    }
                }
                open--;
            }
        }
        return true;
    }
    /**
     * updates the cells of river by breeding, aging, moving, 
     * or killing the animals
     * 
     * @param i the spot in the river thats being updated
     */
    public void updateCell(int i){
        //checks if the spot in the river has an animal
        if(river[i]==null){
            return;
        }
        //checks if the animal has already been updated
        if(river[i].updated){
            return;
        }
        //checks if the animal is the max age and then kills 
        //the animal if it is, otherwise it ages
        if(river[i].maxAge()){
            //emptys the spot in the array
            river[i]=null;
            return;
        } else{
            //increases the age and sets updated to true
            river[i].ageUp();
            river[i].updatedSetTrue();
        }
        //generates the direction the animal is moving
        int move = rng.nextInt(3)-1;
        //the animal stays where it is
        if(move == 0){
            return;
        }
        //the new spot
        move = move + i;
        //if the animal goes to the other side of the river
        if(move == -1){
            move = riverlength-1;
        }
        if(move == riverlength){
            move = 0;
        }
        //if an animal moves to an empty spot update where it moves
        if(river[move] == null){
            river[move] = river[i];
            river[i] = null;
            return;
        }
        //if a fish moves to a fish, either breeds or does nothing
        if(river[i] instanceof Fish && river[move] instanceof Fish){
            if(river[i].getGender() != river[move].getGender()){
                this.addRandom(river[i]);
                return;
            }
            else{
                return;
            }
        }
        //if a bear moves to another bear = either breed or fight
        if(river[move] instanceof Bear && river[i] instanceof Bear){
            if(river[i].getGender() != river[move].getGender()){
                this.addRandom(river[i]);
                return;
            }
            else if(getStrength(river[i]) == getStrength(river[move])){
                return;
            }
            else if(getStrength(river[i]) > getStrength(river[move])){
                river[move] = river[i];
                river[i] = null;
                return;
            }
            else if(getStrength(river[i]) < getStrength(river[move])){
                river[i] = null;
                return;
            }
        }
        //if a fish moves into a bear
        if(river[i] instanceof Fish && river[move] instanceof Bear){
            river[i] = null;
            return;
        }
        if(river[move] instanceof Fish && river[i] instanceof Bear){
            river[move] = river[i];
            river[i] = null;
            return;
        }
        
    }
    /**
     * override method to string for the river
     * 
     * @return the river line as a string
     */
    public String toString(){
        String out = ""; 
        for(int i = 0; i < riverlength; i++){
            if(river[i] == null){
                out = out + "--- ";
            } else if(river[i] instanceof Bear){
                out = out + "B"+river[i].getGender()+river[i].getAge() + " ";
            } else if(river[i] instanceof Fish){
                out = out + "F"+river[i].getGender()+river[i].getAge() + " ";
            }
        }
        System.out.println(out);
        return out;
    }
    /**
     * sets all of the spots in river to false
     */
    public void updatedSetFalse(){
        for(int i = 0; i < riverlength; i++){
            if(river[i] instanceof Fish || river[i] instanceof Bear){
                river[i].updatedSetFalse();
            }
        }
    }
    /**
     * adds a specific animal to the array and removes everything else for testing purposes
     * 
     * @param animal that is being added
     */
    public void addSpecific(Animal animal,int i){
        for(int j=0;j<riverlength;j++){
            river[j]=null;
        }
        if(i<riverlength){
            river[i]= animal;
        }else{
           river[riverlength-1] = animal; 
         }
    }
}
