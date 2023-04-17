import java.util.ArrayList;
import java.util.Scanner;

/** bat class implements Contract */
public class Bat implements Contract {
    /** whether or not bat starts off in vampire form */
    boolean isVampireForm;
    /** stores which creatures the bat has bitten */
    ArrayList<Bat> victims;
    /** stores wehther or not the bat has shape shifted before */
    boolean hasShapeShifted;
    /** name of Bat */
    String name;
    /** size of Bat */
    double size;
    /** whether or not Bat has rabies */
    double maxSize;
    /** whether or not Bat has rabies */
    boolean rabies;
    /** whether or not Bat has acquired vampire abilities */
    protected boolean isVampire;
    /** whether or not bat can fly */
    boolean canFly;
    /** species of Bat */
    String species;
    /** object in possession */
    String inPossession;
    /** user's choice to grab an object if already holding an object */
    String userPossessionChoice;
    /** quantity for bat to grow */
    double amountToGrow;
    /** unit of time for bat to rest for */
    int hours;
    /** x coordinate of bat */
    double x;
    /** y coordinate of bat */
    double y;

    /**
     * full constructor for bat subclass
     * @param name of bat
     * @param isVampireForm whether or not bat is in vampire form (can later shapeshift)
     * @param size of bat
     * @param maxSize maximum size bat can reach by growing
     * @param rabies whether or not bat has rabies
     */
    public Bat(String name, double size, double maxSize, boolean rabies, boolean isVampireForm) {
        this.name = name;
        this.size = size;
        this.maxSize = maxSize;
        this.rabies = rabies;
        this.isVampireForm = isVampireForm;
        this.victims = new ArrayList<Bat>();
        this.species = "Bat";
        this.canFly = true;
        this.x = 0;
        this.y = 0;
        System.out.println("You have created a new bat.");
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
    public boolean fly(int x, int y){
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
     * prints out a bat's x and y coordinates
     */
    public void checkCoordinates() {
        System.out.println(this.name + " is at (" + this.x + ", " + this.y + ").");
    }

    /**
     * decreases bat's size by 2
     * @return new size after shrinking
     */
    public Number shrink(){
        double amountToShrink = 2;
        if (this.size - amountToShrink > 0) {
            this.size = this.size - amountToShrink;
            System.out.println(this.name + " is now this size: " + this.size);
            return this.size;
        }
        else {
            throw new RuntimeException(this.name + " cannot shrink by that amount.");
        }
        
    }

    /**
     * increases bat's size by 2
     * @return new size after growing
     */
    public Number grow(){
        double amountToGrow = 2;
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
     * bat rests for 8 hours
     */
    public void rest(){
        int hours = 8;
        System.out.println(this.name + " rested for " + hours + " hours.");
    }

    /**
     * accessor for name
     * @return name of bat
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * tries to repair damage done by a bite by apologizing, but if transmitted rabies and vampire, cannot try to undo the damage
     * @param victim to undo a bite to
     */
    public void undo(Bat victim){
        if (this.victims.contains(victim)) {
            if (victim.rabies || victim.isVampire) {
                System.out.println("You tried to apologize to " + victim.name + ". Um... You can't undo a transmission of vampire qualities or rabies.");
            }
            else {
                System.out.println("You apologized to your victim, " + victim.name + ".");
            }
        }
        else {
            System.out.println("Seems like there isn't anything to undo.");
        }
        
    }

    /**
     * overload of undo()
     * if shapeshifted, shapeshifts back into previous state
     */
    public void undo() {
        if (this.hasShapeShifted){
            this.shapeShift();
        }
        else {
            System.out.println("Nothing to undo.");
        }
    }

    /**
     * bites other living creatures (victims) and gives them rabies or turns them into vampires
     * @param victim to be bitten
     */
    public void bite(Bat victim) {
        System.out.println(this.name + " bit " + victim.name + ".");
        this.victims.add(victim);
        if (this.rabies) {
            victim.rabies = true;
            System.out.println(victim.name + " now has rabies.");
        }
        if (this.isVampireForm && !victim.isVampire) {
            victim.isVampire = true;
            System.out.println(victim.name + " is now a vampire.");
        }
    }
    
    /**
     * allows bat to shapeshift into vampire form, giving it the capability to change other living creatures iinto vampires
     */
    public void shapeShift(){
        this.hasShapeShifted = true;
        if (!this.isVampireForm) {
            this.isVampireForm = true;
            System.out.println(this.name + " changed into vampire form.");
        }
        else if (this.isVampireForm) {
            this.isVampireForm = false;
            System.out.println(this.name + " changed into bat form.");
        }
    }

    /** for testing */
    public static void main(String[] args) {
        Bat batty = new Bat("Batty", 20, 40, false, false);
        Bat Teddy = new Bat("Teddy", 160, 152, false, true);
        batty.shapeShift();
        //Human Teddy = new Human("Teddy", 160, false);
        batty.bite(Teddy);
        batty.undo(Teddy);
        //Human Egg = new Human("Egg", 165, false);
        //Human Tejas = new Human("Tejas", 168, false);
        //Human Amelia = new Human("Amelia", 163, false);
        batty.shapeShift();
        //batty.bite(Egg);
        //batty.undo(Egg);
        batty.undo();
        //batty.bite(Tejas);
        //Teddy.befriend(Tejas);
        //Egg.befriend(Tejas);
        //Egg.befriend(Teddy);
        //Amelia.befriend(Teddy);
        //Egg.checkFriends();
        //Teddy.checkFriends();
        batty.rest(4);
        //Tejas.marry(Egg);
        //Tejas.getMarriedStatus();
        //Tejas.divorce(Egg);
        //Tejas.getMarriedStatus();
        //Teddy.grab("painting");
        //Teddy.grab("chair");
        //Teddy.shrink(3);
        //Egg.marry(Tejas);
        //Teddy.grow(3);
        //Teddy.marry(Amelia);
        //Amelia.getMarriedStatus();
        batty.fly(3,4);
        batty.fly(8,-4);
        batty.checkCoordinates();
        //Teddy.fly(3,4);
    }

}


