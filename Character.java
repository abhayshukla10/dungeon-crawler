/**
 * Base Character class demonstrating INHERITANCE
 * Both Player and Monster will extend this class
 */
public abstract class Character {
    // PRIMITIVE TYPES: health, coordinates, strength
    protected int health;
    protected int maxHealth;
    protected int x;
    protected int y;
    protected int strength;
    protected String name;

    public Character(String name, int health, int strength, int x, int y) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.strength = strength;
        this.x = x;
        this.y = y;
    }

    // BOOLEAN & IF STATEMENTS: validation logic
    public boolean isAlive() {
        if (health > 0) {
            return true;
        }
        return false;
    }

    public void takeDamage(int damage) {
        if (damage > 0) {
            health -= damage;
            if (health < 0) {
                health = 0;
            }
        }
    }

    public void heal(int amount) {
        if (amount > 0 && health < maxHealth) {
            health += amount;
            if (health > maxHealth) {
                health = maxHealth;
            }
        }
    }

    // Getters
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public int getX() { return x; }
    public int getY() { return y; }
    public String getName() { return name; }
    public int getStrength() { return strength; }
}