import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Person implements Contract {
    // Qualities
    protected int x, y;
    protected String direction;
    protected Boolean moving;
    protected Boolean flying;
    protected int size = 5;
    protected List<Item> inventory;

    /**
     * // Creates a new person with an empty inventory
     */
    public Person() {
        this.inventory = new ArrayList<>();
        moving = false;
        flying = false;
    }

    /**
     * // Various getters
     */
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Boolean getMoving() {
        return this.moving;
    }

    public int getSize() {
        return this.size;
    }

    /**
     * // Checks if there is space in the inventory, and adds the item to it. Otherwise throws error 
     * @param String itemName is the item to be added
     */
    public void grab(String itemName) {
        if (inventory.size() <= 1) {
            System.out.println(itemName + " grabbed!");
            inventory.add(new Item(itemName, "", ""));
        } else {
            throw new RuntimeException("Both of your hands are full! Try dropping an item first.");
        }
    }

    /**
     * // Checks if item is in inventory and removes it. Otherwise throws error
     * @param String itemName is the item to be removed
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
     * // Prints the description of the item
     * @param String description is the item's associated description 
     */
    public void examine(String description) {
        System.out.println("Hm... " + description + " How interesting!");
    }

    /**
     * // Prints the action of the item 
     * @param String action is the item's associated action
     */
    public void use(String action) {
        System.out.println(action);
    }

    /**
     * // Updates moving to true if the person is not already walking. Otherwise throws error
     * @param String direction is the direction to move in
     * @return boolean moving updates moving to true
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
     * // "Fly" to the specified coordinates if not already flying. Otherwise throws error if flying is already true
     * @param int x is the x-coordinate to fly to
     * @param int y is the y-coordinate to fly to
     * @return boolean flying indicates if the person is flying
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
     * // "Landing" - Updates flying to false. Otherwise throws error if flying is not true
     * @return boolean flying indicates that the person is not flying 
     */
    public boolean land() {
        if (flying == true) {
            flying = false;
            return flying;
        } else {
            throw new RuntimeException("You are not flying!");
        }
    }

   /**
     * // Shrinks the size of the person by 1/2
     * @return Number size updates the size of the person
     */
    public Number shrink() {
        size /= 2;
        System.out.println("Shrinking! You are now size " + size);
        return size;
    }

    /**
     * // Grows the size of the person by x2
     * @return Number size updates the size of the person
     */
    public Number grow() {
        size *= 2;
        System.out.println("Growing! You are now size " + size);
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
     * // Returns the state of the person back to the default settings
     */
    public void undo() {
        System.out.println("Undoing all actions...");
        this.x = 0;
        this.y = 0;
        direction = "Not moving.";
        this.size = 5;
        Iterator<Item> iterator = inventory.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    public void printInventory() {
        System.out.println("\n");
        System.out.println("*********");
        System.out.println("INVENTORY:");
        if (inventory.size() == 0) {
            System.out.println("Empty");
            System.out.println("*********");
            System.out.println("\n");
        } else {
            for (Item item : inventory) {
                System.out.println("+ " + item);
            }
            System.out.println("*********");
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        // Creating person and items 
        Person me = new Person();
        Item Waterbottle = new Item("Waterbottle", "Something to drink from!", "Drinking... Refreshing!");
        Item Sword = new Item("Sword", "It's dangerous to go alone. Take this!", "Swish!");
        Item Wand = new Item("Wand", "Cast a spell with this!", "Shazam!");
        // Details about person 
        System.out.println("You are located at: " + me.getX() + ", " + me.getY());
        me.printInventory();
        // Moving
        me.walk("North");
        me.fly(100,500);
        me.land();
        System.out.println("\n");
        // Interacting with waterbottle 
        me.examine(Waterbottle.getDescription());
        me.grab(Waterbottle.getName());
        me.printInventory();
        System.out.println(me.drop(Waterbottle.getName()));
        System.out.println("\n");
        // Interaction with sword 
        me.grab(Sword.getName());
        me.grab(Wand.getName());
        me.printInventory();
        me.use(Sword.getAction());
        System.out.println("\n");
        // Changing size
        System.out.println("You are curently size: " + me.size + ".");
        me.grow();
        me.grow();
        me.shrink();
        System.out.println("\n");
        // Undoing everything 
        me.undo();
        System.out.println("You are located at: " + me.getX() + ", " + me.getY());
        System.out.println("You are curently size: " + me.size + ".");
        me.printInventory();
    }
}
