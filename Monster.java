public class Monster extends Character {
    private int experienceReward;
    private int goldReward;

    public Monster(String name, int health, int strength, int x, int y, int expReward, int goldReward) {
        super(name, health, strength, x, y);
        this.experienceReward = expReward;
        this.goldReward = goldReward;
    }

    public int attack() {
        if (!isAlive()) {
            return 0;
        }
        return strength + (int)(Math.random() * 8);
    }

    public int getExperienceReward() { return experienceReward; }
    public int getGoldReward() { return goldReward; }

    public String getStatus() {
        String status = name + " (HP: " + health + "/" + maxHealth + ")";
        if (!isAlive()) {
            status += " [DEAD]";
        }
        return status;
    }
}