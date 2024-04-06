public class Person implements Contract {
    // Location
    protected int x, y;
    protected String direction;

    // Qualities
    protected String name;
    protected Boolean moving = false;
    protected Boolean flying = false;
    protected int size = 10;

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

    // Grabs item; Maybe adds it to inventory - Can't hold more than two objects - You only have two hands (:
    public void grab(String item) {
        System.out.println(item + " grabbed!");
    }

    // Drops item; Checks if in inventory + removes it from inventory
    public String drop(String item) {
        System.out.println(item + " dropped!");
        return item;
    }

    public void examine(String item) {
        System.out.println("Hm... I need to take a closer look at" + item);
    }

    // Checks if you have item; Uses it if so 
    public void use(String item) {
        System.out.println(item + " used!");
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

    @Override
    public Number shrink() {
        System.out.println("Shrinking down!");
        size /= 2;
        return size;
    }

    @Override
    public Number grow() {
        System.out.println("Growing!");
        size *= 2;
        return size;
        }

    @Override
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
        System.out.println(me);
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
