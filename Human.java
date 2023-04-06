import java.util.ArrayList;

public class Human extends LivingCreature {
    boolean isSingle;
    ArrayList<Human> friends;

    public Human(String name, double size, boolean rabies) {
        super(name, size, rabies);
        this.isVampire = false;
        this.isSingle = true;
        this.species = "Human";
        this.friends = new ArrayList<Human>();
    }

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

    //void marry(Human human) {}
    
}
