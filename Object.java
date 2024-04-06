public class Object {
    
    private String name;
    
    public Object(String n) {
        this.name = n;
    }

    public String toString() {
        return super.toString() + " called " + this.name;
       }

    public static void main(String[] args) {
        Object Waterbottle = new Object("Waterbottle");
        System.out.println(Waterbottle);
    }
    
}
