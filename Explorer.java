public class Explorer extends Person {
    // Person walks 
    public boolean walk(String direction) {
        if (moving = false) {
            System.out.println("You are now moving in " + direction);
            return true;
        } else {
            throw new RuntimeException("You are already moving!");
        }
    }

    // Person flies to new coordinates
    public boolean fly(int num1, int num2) {
        int x = num1;
        int y = num2;
        flying = true;
        return flying;
    }

    // Person shrinks in size
    public Number shrink() {
        // filler num
        return 3.0;
    }

    // Person grows in size
    public Number grow() {
        // filler num
        return 3.0;
    }

    // Person stops walking 
    public void rest() {
        System.out.println("You are resting!");
    }

    // Person goes back to original size, coordinates, and stops moving
    public void undo() {
        int x = 0;
        int y = 0;
        direction = "Not moving.";
    }

    public static void main(String[] args) {
        Explorer me = new Explorer();
        me.fly(10,10);
    }
}
