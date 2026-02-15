/**
 * Item class demonstrating OBJECTS
 * Simple class representing game items
 */
public class Item {
    // PRIMITIVE TYPES: bonus value, type
    private String name;
    private int bonus;
    private String type; // "weapon", "armor", "potion"

    public Item(String name, int bonus, String type) {
        this.name = name;
        this.bonus = bonus;
        this.type = type;
    }

    public String getName() { return name; }
    public int getBonus() { return bonus; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return name + " (+" + bonus + " " + type + ")";
    }
}