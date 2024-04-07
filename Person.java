import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Person implements Contract {
    // Qualities
    protected int x, y;
    protected String direction;
    protected Boolean moving = false;
    protected Boolean flying = false;
    protected int size = 10;
    protected List<Item> inventory;

    /**
     * // Creates a new person with an empty inventory
     */
    public Person() {
        this.inventory = new ArrayList<>();
    }

    /**
     * // Getter for x
     */
    public int getX() {
        return this.x;
    }

    /**
     * // Getter for y
     */
    public int getY() {
        return this.y;
    }

    /**
     * // Getter for whether or not moving is true/false
     */
    public Boolean getMoving() {
        return this.moving;
    }

    /**
     * // Getter for size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * // "Grabs" item and adds it to the inventory if room. Otherwise throws error
     * @param String item is the item to be added
     */
    public void grab(String itemName) {
        if (inventory.size() <= 2) {
            System.out.println(itemName + " grabbed!");
            inventory.add(new Item(itemName, "", ""));
        } else {
            throw new RuntimeException("Both of your hands are full! Try dropping an item first.");
        }
    }

    /**
     * // "Grabs" item and removes it to the inventory if it is already there. Otherwise throws error
     * @param String item is the item to be removed
     */
    public String drop(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equals(itemName)) {
                inventory.remove(item);
                return itemName + " dropped!";
        
        }
    }
        throw new RuntimeException(itemName + " is not in your inventory!");
    }

    /**
     * // "Examines" item
     * @param String item is the item to be examined
     */
    public void examine(String description) {
        System.out.println("Hm... " + description + " How interesting!");
    }

    /**
     * // "Uses" item if it is in inventory. Otherwise throws error
     * @param String item is the item to be used
     */
    public void use(String action) {
        System.out.println(action);
    }

    /**
     * // Makes the person "walk" if moving is false. Otherwise throws error
     * @param String direction is the direction to move in
     * @return boolean updates direction to true
     */
    public boolean walk(String direction) {
        if (moving == false) {
            System.out.println("You are now moving " + direction +".");
            moving = true;
            return moving;
        } else {
            throw new RuntimeException("You are already moving!");
        }
    }

    /**
     * // Fly to the specified coordinates if not already flying
     * @param int x is the x-coordinate to fly to
     * @param int y is the y-coordinate to fly to
     * @return boolean updates to indicate that you are flying
     */
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

    /**
     * // Updates flying to false
     * @return boolean updates to indicate that you not  are flying
     */
    public boolean land() {
        flying = false;
        return flying;
    }

   /**
     * // Shrinks the size of the person by 1/2
     * @return Number updates the size of the person
     */
    public Number shrink() {
        System.out.println("Shrinking down!");
        size /= 2;
        return size;
    }

    /**
     * // Grows the size of the person by x2
     * @return Number updates the size of the person
     */
    public Number grow() {
        System.out.println("Growing!");
        size *= 2;
        return size;
        }

    /**
     * // Sets moving to false
     */
    public void rest() {
        System.out.println("Phew! Time to take a break.");
        moving = false;
    }

    /**
     * // Returns the state of the person back to normal
     */
    public void undo() {
        System.out.println("Undoing all actions...");
        this.x = 0;
        this.y = 0;
        direction = "Not moving.";
        this.size = 10;
        Iterator<Item> iterator = inventory.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    public static void main(String[] args) {
        Person me = new Person();
        Item Waterbottle = new Item("Waterbottle", "Something to drink from!", "Drinking... Refreshing!");
        Item Sword = new Item("Sword", "It's dangerous to go alone. Take this!", "Swish!");
        System.out.println("You are located at: " + me.getX() + ", " + me.getY());
        me.walk("North");
        me.fly(100,500);
        me.land();
        me.examine(Waterbottle.getDescription());
        me.grab(Waterbottle.getName());
        me.drop(Waterbottle.getName());
        me.grab(Sword.getName());
        me.use(Sword.getAction());
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
