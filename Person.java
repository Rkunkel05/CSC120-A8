public class Person {
    // Location
    protected int x, y;
    protected String direction;

    // Qualities
    protected String name;
    protected Boolean moving = false;
    protected Boolean flying = false;

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

    public String toString() {
        return this.getClass().getCanonicalName();
    }

    public boolean walk(String direction) {
        if (moving = false) {
            System.out.println("You are now moving in " + direction);
            return true;
        } else {
            throw new RuntimeException("You are already moving!");
        }
    }

    public static void main(String[] args) {
        Person me = new Person();
        System.out.println(me);
    }
}
