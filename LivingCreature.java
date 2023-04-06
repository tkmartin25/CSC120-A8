import java.util.Scanner;

public class LivingCreature {
    /** name of Living Creature */
    String name;
    /** size of Living Creature */
    double size;
    /** whether or not Living Creature has rabies */
    boolean rabies;
    /** whether or not Living Creature has acquired vampire abilities */
    protected boolean isVampire;
    /** species of Living Creature */
    String species;
    /** object in possession */
    String inPossession;

    String userPossessionChoice;

    /**
     * constructor for LivingCreature parent class
     * @param name
     * @param size
     * @param rabies
     */
    public LivingCreature(String name, double size, boolean rabies) {
        this.name = name;
        this.size = size;
        this.rabies = rabies;
        this.isVampire = false;
        this.species = "<Species Unknown>";
    }

    /**
     * item becomes in creature's possession
     * @param item to be grabbed
     */
    void grab(String item){
        if (this.inPossession == null) {
            this.inPossession = item;
            System.out.println(this.name + " grabbed a " + item + ".");
        }
        else {
            System.out.println(this.name + " is already carrying a " + this.inPossession + ".");
            Scanner userInput = new Scanner(System.in); 
            System.out.println("Would you like " + this.name + " to drop the " + this.inPossession + " and pick up a " + item + "? (Y/N) ");
            String userPossessionChoice = userInput.nextLine();
            userInput.close();
            userPossessionChoice = userPossessionChoice.toUpperCase();
            if (userPossessionChoice.equals("Y")) {
                this.drop(this.inPossession);
                this.grab(item);
            }
            else if (userPossessionChoice.equals("N")) {
                System.out.println(this.name + " did not pick up a " + item + ".");
            }
            else {
                System.out.println(userPossessionChoice);
                throw new RuntimeException("Invalid response.");
            }

        }

    }
    
    /**
     * drops item that is in Living Creature's possession
     * @param item to be dropped
     * @return item that is dropped, and null if nothing is dropped
     */
    String drop(String item) {
        if (this.inPossession == item) {
            this.inPossession = null;
            System.out.println(this.name + " dropped a " + item + ".");
            return item;
        }
        else if (this.inPossession == null) {
            System.out.println(this.name + " is not currently carrying anything.");
            return null;
        }
        else {
            System.out.println(this.name + " is currently carrying " + this.inPossession + ".");
            return null;
        }
    }
    
    
    //void examine(String item){
        //System.out.println("You examinted " + item);
    //}
    //void use(String item){
        //System.out.println("You used " + item);
    //}
    
    //boolean walk(String direction){
        //System.out.println("You walked.");
    //}
    //boolean fly(int x, int y){
       // System.out.println("You flew.");
    //}
    //Number shrink(){
        
    //}
    //Number grow(){}
    void rest(int hours){
        System.out.println(this.name + " rested for " + hours + " hours.");
    }

    //void undo(){}

    /**
     * accessor for name
     * @return name of living creature
     */
    String getName(){
        return this.name;
    }


    public static void main(String[] args) {
    }

}


