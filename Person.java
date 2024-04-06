import java.util.ArrayList;
import java.util.List;

public class Person implements Contract {
    // Location
    protected int x, y;
    protected String direction;

    // Qualities
    protected String name;
    protected Boolean moving = false;
    protected Boolean flying = false;
    protected int size = 10;
    protected List<String> inventory;

    // Constructor
    public Person() {
        this.inventory = new ArrayList<>();
    }

    // Getters
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getMoving() {
        return this.moving;
    }

    public int getSize() {
        return this.size;
    }

    // Grabs item; Maybe adds it to inventory
    public void grab(String item) {
        if (inventory.size() <= 10) {
            System.out.println(item + " grabbed!");
            inventory.add(item);
        } else {
            throw new RuntimeException("You don't have room in your inventory! Try dropping an item first.");
        }
    }

    // Drops item; Checks if in inventory + removes it from inventory
    public String drop(String item) {
        if (inventory.contains(item)) {
            System.out.println(item + " dropped!");
            inventory.remove(item);
            return item;
        } else {
             throw new RuntimeException(item + " is not in your inventory!");
        }
    }

    public void examine(String item) {
        System.out.println("Hm... I need to take a closer look at" + item);
    }

    // Checks if you have item; Uses it if so 
    public void use(String item) {
        if (inventory.contains(item)) {
            System.out.println(item + " used!");
        } else {
            System.out.println(item + " is not in your inventory, so you can't use it!");
        }
    }

    public boolean walk(String direction) {
        if (moving == false) {
            System.out.println("You are now moving " + direction +".");
            return true;
        } else {
            throw new RuntimeException("You are already moving!");
        }
    }

    // flies to coordinates
    public boolean fly(int x, int y) {
        if (flying == false) {
            System.out.println("Flying to " + x +", "+ y+"! Wahoo!");
            this.x = x;
            this.y = y;
            flying = true;
            System.out.println("You are located at: " + this.x + ", " + this.y);
            return flying;
        } else {
            throw new RuntimeException("You are already flying!");
        }
    }

    // Changes size by 1/2
    public Number shrink() {
        System.out.println("Shrinking down!");
        size /= 2;
        return size;
    }

    // Changes size by x2
    public Number grow() {
        System.out.println("Growing!");
        size *= 2;
        return size;
        }

    // Sets moving to false
    public void rest() {
        System.out.println("Phew! Time to take a break.");
        moving = false;
    }

    // Person goes back to original size, coordinates, and stops moving
    public void undo() {
        System.out.println("Undoing all actions...");
        this.x = 0;
        this.y = 0;
        direction = "Not moving.";
        this.size = 10;
    }

    public static void main(String[] args) {
        Person me = new Person();
        System.out.println("You are located at: " + me.getX() + ", " + me.getY());
        me.walk("North");
        me.fly(100,500);
        me.grab("Waterbottle");
        me.drop("Waterbottle");
        me.use("Sword");
        System.out.println(me.size);
        me.grow();
        me.grow();
        me.shrink();
        System.out.println(me.size);
        me.undo();
        System.out.println("You are located at: " + me.getX() + ", " + me.getY());
        System.out.println(me.size);
    }
}
