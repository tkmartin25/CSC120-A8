
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

