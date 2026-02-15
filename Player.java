import java.util.ArrayList;

/**
 * Player class demonstrating:
 * - INHERITANCE (extends Character)
 * - OBJECTS (Player is an object)
 * - PRIMITIVE TYPES (scores, experience points)
 * - ARRAYLIST (inventory system)
 * - BOOLEAN & IF STATEMENTS (validation)
 */
public class Player extends Character {
    // PRIMITIVE TYPES: score, level, experience
    private int score;
    private int level;
    private int experience;
    private int experienceToNextLevel;

    // ARRAYLIST: inventory of items
    private ArrayList<Item> inventory;

    public Player(String name, int health, int strength, int x, int y) {
        super(name, health, strength, x, y);
        this.score = 0;
        this.level = 1;
        this.experience = 0;
        this.experienceToNextLevel = 100;
        this.inventory = new ArrayList<>();
            
    public String getStatus() {
        String status = name + " (HP: " + health + "/" + maxHealth + ", Level: " + level + ")";
        if (!isAlive()) {
            status += " [DEAD]";
        }
        return status;
    }
    }

    // BOOLEAN & IF STATEMENTS: combat and validation
    public boolean canAttack(Monster monster) {
        if (this.isAlive() && monster.isAlive()) {
            return true;
        }
        return false;
    }

    public int attack() {
        // PRIMITIVE TYPES: damage calculation
        if (!isAlive()) {
            return 0;
        }
        return strength + (int)(Math.random() * 10);
    }

    public void gainExperience(int exp) {
        if (exp > 0) {
            experience += exp;
            if (experience >= experienceToNextLevel) {
                levelUp();
            }
        }
    }

    private void levelUp() {
        level++;
        experience = 0;
        experienceToNextLevel = (int)(experienceToNextLevel * 1.5);
        maxHealth += 20;
        health = maxHealth;
        strength += 5;
        System.out.println("🎉 Level Up! You are now level " + level);
    }

    // ARRAYLIST: inventory management
    public void addItem(Item item) {
        if (item != null) {
            inventory.add(item);
            System.out.println("Added " + item.getName() + " to inventory");
        }
    }

    public void removeItem(int index) {
        if (index >= 0 && index < inventory.size()) {
            inventory.remove(index);
        }
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void displayInventory() {
        System.out.println("\n--- Inventory ---");
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty");
        } else {
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println((i + 1) + ". " + inventory.get(i).getName() + " (+" + inventory.get(i).getBonus() + ")");
            }
        }
    }

    // Move the player
    public boolean move(int newX, int newY, int mapWidth, int mapHeight) {
        // BOOLEAN & IF STATEMENTS: boundary validation
        if (newX >= 0 && newX < mapWidth && newY >= 0 && newY < mapHeight) {
            this.x = newX;
            this.y = newY;
            return true;
        }
        System.out.println("Cannot move there!");
        return false;
    }

    // Getters
    public int getScore() { return score; }
    public int getLevel() { return level; }
    public int getExperience() { return experience; }

    public void addScore(int points) {
        if (points > 0) {
            score += points;
        }
    }

    public void displayStats() {
        System.out.println("\n╔════════════════════╗");
        System.out.println("║ PLAYER STATS       ║");
        System.out.println("║ Name: " + String.format("%-11s", name) + "║");
        System.out.println("║ Level: " + String.format("%-10d", level) + "║");
        System.out.println("║ HP: " + String.format("%-14d", health) + "║");
        System.out.println("║ Score: " + String.format("%-11d", score) + "║");
        System.out.println("╚════════════════════╝");
    }

    public String getStatus() {
        String status = name + " (HP: " + health + "/" + maxHealth + ", Level: " + level + ")";
        if (!isAlive()) {
            status += " [DEAD]";
        }
        return status;
    }
}
