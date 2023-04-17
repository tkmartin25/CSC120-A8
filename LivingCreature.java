import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class LivingCreature implements Contract {
    /** name of Living Creature */
    String name;
    /** size of Living Creature */
    double size;
    /** whether or not Living Creature has rabies */
    double maxSize;
    /** whether or not Living Creature has rabies */
    boolean rabies;
    /** whether or not Living Creature has acquired vampire abilities */
    protected boolean isVampire;
    boolean canFly;
    /** species of Living Creature */
    String species;
    /** object in possession */
    String inPossession;

    String userPossessionChoice;

    double amountToGrow;

    int hours;

    double x;

    double y;

    /**
     * constructor for LivingCreature parent class
     * @param name
     * @param size
     * @param rabies
     */
    public LivingCreature(String name, double size, boolean rabies) {
        this.name = name;
        this.size = size;
        this.maxSize = 200;
        this.rabies = rabies;
        this.isVampire = false;
        this.canFly = false;
        this.species = "<Species Unknown>";
        this.x = 0;
        this.y = 0;
    }

    /**
     * constructor for LivingCreature parent class
     * @param name
     * @param size
     * @param maxSize
     * @param rabies
     * @param canFly
     */
    public LivingCreature(String name, double size, double maxSize, boolean rabies) {
        this.name = name;
        this.size = size;
        this.maxSize = maxSize;
        this.rabies = rabies;
        this.isVampire = false;
        this.canFly = false;
        this.species = "<Species Unknown>";
    }

    /**
     * item becomes in creature's possession
     * @param item to be grabbed
     */
    public void grab(String item){
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
    public String drop(String item) {
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
    
    
    public void examine(String item){
        System.out.println("You examined " + item);
    }
    
    public void use(String item){
        if (item == "chair") {
            System.out.println("You sat on the " + item + ".");
        }
    }
    
    public boolean walk(String direction){
        direction = direction.toLowerCase();
        if (direction == "north") {
            System.out.println("You walked north.");
            this.y = y + 1;
            return true;
        }
        if (direction == "south") {
            System.out.println("You walked south.");
            this.y = y - 1;
            return true;
        }
        if (direction == "west") {
            System.out.println("You walked west.");
            this.x = x - 1;
            return true;
        }
        if (direction == "east") {
            System.out.println("You walked east.");
            this.x = x + 1;
            return true;
        }
        else {
            throw new RuntimeException("Error: You must input one of the following four directions: 'north', 'south', 'west', or 'east'.");
        }
    }

    /**
     * living creatures travels an x and y direction and their coordinates change
     * @param x number to travel in the x - axis direction
     * @param y number to travel in the y - axis direction
     * @return true if flew successfully, otherwise if living creature cannot fly throw error
     */
    boolean fly(double x, double y){
        if (this.canFly) {
            System.out.println(this.name + " flew in the direction of " + x + " and " + y + ".");
            this.x = this.x + x;
            this.y = this.y + y;
            return true;
        }
        else {
            throw new RuntimeException(this.name + " cannot fly.");
        }
    }

    /**
     * prints out a living creature's x and y coordinates
     */
    void checkCoordinates() {
        System.out.println(this.name + " is at (" + this.x + ", " + this.y + ").");
    }

    /**
     * decreases living creature's size by user inputted amount
     * @param amountToShrink double to shrink the living creature
     * @return new size after shrinking
     */
    Number shrink(double amountToShrink){
        if (this.size - amountToShrink > 0) {
            this.size = this.size - amountToShrink;
            System.out.println(this.name + " is now this size: " + this.size);
            return this.size;
        }
        else {
            throw new RuntimeException(this.name + " cannot shrink by that amount.");
        }
        
    }

    Number grow(double amountToGrow){
        if (this.size + amountToGrow < this.maxSize) {
            this.size = this.size + amountToGrow;
            System.out.println(this.name + " is now this size: " + this.size);
            return this.size;
        }
        else {
            throw new RuntimeException(this.name + " cannot grow by that amount.");
        }
    }

    /**
     * living creature rests for a user-specified number of hours
     * @param hours to be rested
     */
    void rest(int hours){
        System.out.println(this.name + " rested for " + hours + " hours.");
    }

    void undo(){
        
    }

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


