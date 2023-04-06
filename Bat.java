import java.util.ArrayList;


public class Bat extends LivingCreature {
    boolean isVampireForm;
    ArrayList<LivingCreature> victims;
    boolean hasShapeShifted;
    int hours;
    
    public Bat(String name, boolean isVampireForm, double size, boolean rabies) {
        super(name, size, rabies);
        this.isVampireForm = isVampireForm;
        this.victims = new ArrayList<LivingCreature>();
        this.species = "Bat";
        System.out.println("You have created a new bat.");
    }

    //void grab(String item){
        //System.out.println("You grabbed " + item);
    //}
    //String drop(String item){
        //System.out.println("You dropped " + item);
        //return item;
    //}
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
    
    void undo(LivingCreature victim){
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
    void undo() {
        if (this.hasShapeShifted){
            this.shapeShift();
        }
        else {
            System.out.println("Nothing to undo.");
        }

    }

    /**
     * bites other living creatures (victims) and gives them rabies or turns them into vampires
     * @param victim
     */
    void bite(LivingCreature victim) {
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
    void shapeShift(){
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
        Bat batty = new Bat("Batty", false, 30, true);
        batty.shapeShift();
        Human Teddy = new Human("Teddy", 160, false);
        batty.bite(Teddy);
        batty.undo(Teddy);
        Human Egg = new Human("Egg", 165, false);
        Human Tejas = new Human("Tejas", 168, false);
        Human Amelia = new Human("Amelia", 163, false);
        batty.shapeShift();
        batty.bite(Egg);
        batty.undo(Egg);
        batty.undo();
        batty.bite(Tejas);
        Teddy.befriend(Tejas);
        Egg.befriend(Tejas);
        Egg.befriend(Teddy);
        Amelia.befriend(Teddy);
        Egg.checkFriends();
        Teddy.checkFriends();
        batty.rest(4);
        Teddy.rest(2);
        Tejas.marry(Egg);
        Tejas.getMarriedStatus();
        Tejas.divorce(Egg);
        Tejas.getMarriedStatus();
    }

}

