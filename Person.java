abstract class Person {

    // Location
    protected int x, y;
    protected String direction;

    // Qualities
    protected String name;
    protected Boolean moving; 
    protected Boolean flying;

     // Need to make a person to do the actions!
    public void Person() {
        moving = false;
        flying = false;
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

    public String toString() {
        return this.getClass().getCanonicalName();
    }

}
