import java.util.ArrayList;

public class Human extends LivingCreature {
    /** whether or not a human is married */
    boolean isMarried;
    /** array list that stores human's friends */
    ArrayList<Human> friends;
    /** variable that stores human's spouse */
    Human spouse;

    /**
     * constructor for Human, with name, size, and rabies status
     * @param name
     * @param size
     * @param rabies
     */
    public Human(String name, double size, boolean rabies) {
        super(name, size, rabies);
        this.isVampire = false;
        this.isMarried = false;
        this.species = "Human";
        this.maxSize = 210;
        this.friends = new ArrayList<Human>();
    }

    /**
     * constructor for Human, with name, size, and rabies status
     * @param name
     * @param size
     * @param maxSize
     * @param rabies
     */
    public Human(String name, double size, double maxSize, boolean rabies) {
        super(name, size, maxSize, rabies);
        this.isVampire = false;
        this.isMarried = false;
        this.species = "Human";
        this.friends = new ArrayList<Human>();
    }

    /**
     * human becomes friends with input human
     * @param human to be befriended
     */
    void befriend(Human human) {
        if (this.friends.contains(human)) {
            System.out.println("You're already friends with " + human.name + ".");
        }
        else {
            this.friends.add(human);
            human.friends.add(this);
            System.out.println("You befriended " + human.name + ".");
        }
    }

    /**
     * human can unfriend a human of choice, which removes the friend from array list of friends
     * @param human to be unfriended
     */
    void unfriend(Human human) {
        if (!this.friends.contains(human)) {
            System.out.println(this.name + " isn't even friends with " + human.name + ".");
        }
        else {
            this.friends.remove(human);
            human.friends.remove(human);
            System.out.println(this.name + " unfriended " + human.name + ".");
        }
    }

    /**
     * prints out human's friends
     */
    void checkFriends() {
        if (this.friends.size() == 0) {
            System.out.println(this.name + " doesn't have any friends.");
        }
        else {
            System.out.println(this.name + "'s friends: ");
            for (int i = 0; i < this.friends.size(); i++) {
                System.out.println(this.friends.get(i).getName());
            }
        }
    }

    /**
     * marries human of choice, which sets both this and input human's spouses to each other
     * @param human to be married
     */
    void marry(Human human) {
        if (human.isMarried) {
            throw new RuntimeException("Sorry, but " + human.name + " is already married.");
        }
        else if (this.isMarried) {
            throw new RuntimeException(this.name + " is already married. Divorce first before remarrying.");
        }
        else if (!this.isMarried && !human.isMarried) {
            this.isMarried = true;
            human.isMarried = true;
            this.spouse = human;
            human.spouse = this;
            System.out.println("Congratulations to " + this.name + " and " + human.name + ", who are now married!");
        }
    }

    /**
     * removes human and human to be divorced's spouses and sets to null
     * @param human to be divorced
     */
    void divorce(Human human) {
        if (this.spouse != human) {
            throw new RuntimeException(human.name + " is not married to " + this.name + ".");
        }
        else if (this.spouse == human) {
            this.isMarried = false;
            human.isMarried = false;
            this.spouse = null;
            human.spouse = null;
            System.out.println("Oop. " + this.name + " and " + human.name + " are now divorced.");
        }
    }

    /**
     * prints out user's married status
     * @return boolean on whether or not human is married
     */
    boolean getMarriedStatus() {
        if (this.isMarried) {
            System.out.println(this.name + " is married.");
            return true;
        }
        else {
            System.out.println(this.name + " is not married.");
            return false;
        }
    }
    
}
