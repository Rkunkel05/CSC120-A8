public class Item {
    
    public static Object item;
    private String name;
    private String description;
    private String action;
    
    public Item(String n, String d, String a) {
        this.name= n;
        this.description = d;
        this.action = a;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getAction() {
        return this.action;
    }

    public String toString() {
        return this.getClass().getCanonicalName() + " called " + this.name + ". " + this.description;
       }

    public static void main(String[] args) {
        Item Waterbottle = new Item("Waterbottle", "It's something to drink from!", "Drinking... Refreshing!");
        System.out.println(Waterbottle);
    }
    
}
