import java.util.Scanner;
import java.util.ArrayList;

/**
 * Main DungeonCrawler class demonstrating:
 * - GAME LOOP (ITERATION)
 * - BOOLEAN & IF STATEMENTS (game logic)
 * - OBJECTS (Player, Monster, GameMap)
 * - CLASSES (Custom game classes)
 * - ARRAYS & ARRAYLIST (game entities)
 */
public class DungeonCrawler {
    private Player player;
    private GameMap gameMap;
    private Scanner scanner;
    private boolean gameRunning;

    public static void main(String[] args) {
        DungeonCrawler game = new DungeonCrawler();
        game.start();
    }

    public DungeonCrawler() {
        scanner = new Scanner(System.in);
        gameRunning = true;
    }

    // ITERATION: Game loop
    public void start() {
        System.out.println("\n╔════════════════════════════╗");
        System.out.println("║  WELCOME TO DUNGEON CRAWLER ║");
        System.out.println("╚════════════════════════════╝\n");

        initializeGame();
        HelpSystem.displayHelp(0);

        // GAME LOOP - main iteration
        while (gameRunning) {
            gameMap.display();
            player.displayStats();
            displayMonsterInfo();
            System.out.print("\n> ");
            String command = scanner.nextLine().toLowerCase();
            processCommand(command);
        }

        System.out.println("\n╔════════════════════════════╗");
        System.out.println("║    GAME OVER - FINAL STATS  ║");
        System.out.println("╚════════════════════════════╝");
        player.displayStats();
        System.out.println("Final Score: " + player.getScore());
    }

    private void initializeGame() {
        // Create game map (10x10)
        gameMap = new GameMap(10, 10);

        // Create player
        player = new Player("Hero", 100, 15, 1, 1);
        gameMap.setPlayer(player);

        // ARRAYLIST: Add multiple monsters
        gameMap.addMonster(new Monster("Goblin", 30, 8, 5, 5, 50, 10));
        gameMap.addMonster(new Monster("Orc", 50, 12, 3, 7, 100, 25));
        gameMap.addMonster(new Monster("Dragon", 80, 18, 8, 3, 200, 50));

        // Add starting items to inventory
        player.addItem(new Item("Iron Sword", 10, "weapon"));
        player.addItem(new Item("Health Potion", 20, "potion"));
    }

    private void processCommand(String command) {
        // BOOLEAN & IF STATEMENTS: Command validation
        if (command.equals("w")) {
            movePlayer(0, -1);
        } else if (command.equals("a")) {
            movePlayer(-1, 0);
        } else if (command.equals("s")) {
            movePlayer(0, 1);
        } else if (command.equals("d")) {
            movePlayer(1, 0);
        } else if (command.equals("attack")) {
            performCombat();
        } else if (command.equals("i")) {
            player.displayInventory();
        } else if (command.equals("help")) {
            HelpSystem.displayHelp(0);
        } else if (command.equals("status")) {
            player.displayStats();
        } else if (command.equals("heal")) {
            useHealthPotion();
        } else if (command.equals("quit")) {
            gameRunning = false;
        } else {
            System.out.println("Unknown command. Type 'help' for commands.");
        }

        // ITERATION: Remove dead monsters
        for (int i = gameMap.getMonsters().size() - 1; i >= 0; i--) {
            if (!gameMap.getMonsters().get(i).isAlive()) {
                gameMap.getMonsters().remove(i);
            }
        }

        // BOOLEAN & IF STATEMENTS: Win condition
        if (gameMap.getMonsters().isEmpty()) {
            System.out.println("\n🎉 You defeated all monsters! You win!");
            gameRunning = false;
        }

        // BOOLEAN & IF STATEMENTS: Lose condition
        if (!player.isAlive()) {
            System.out.println("\n💀 You were defeated!");
            gameRunning = false;
        }
    }

    private void movePlayer(int dx, int dy) {
        int newX = player.getX() + dx;
        int newY = player.getY() + dy;

        // BOOLEAN & IF STATEMENTS: Movement validation
        if (player.move(newX, newY, gameMap.getWidth(), gameMap.getHeight())) {
            System.out.println("Moved to (" + newX + ", " + newY + ")");
            gameMap.setPlayer(player);
        }
    }

    private void performCombat() {
        Monster target = gameMap.getNearestMonster(player);

        // BOOLEAN & IF STATEMENTS: Combat validation
        if (target == null) {
            System.out.println("No monsters nearby!");
            return;
        }

        if (!player.canAttack(target)) {
            System.out.println("Cannot attack!");
            return;
        }

        // ITERATION: Combat rounds
        System.out.println("\n⚔️  COMBAT START: " + player.getName() + " vs " + target.getName());
        
        while (player.isAlive() && target.isAlive()) {
            // Player attacks
            int playerDamage = player.attack();
            target.takeDamage(playerDamage);
            System.out.println(player.getName() + " attacks for " + playerDamage + " damage!");
            System.out.println(target.getStatus());

            // BOOLEAN & IF STATEMENTS: Check if monster is dead
            if (!target.isAlive()) {
                System.out.println("\n✨ You defeated " + target.getName() + "!");
                player.gainExperience(target.getExperienceReward());
                player.addScore(target.getGoldReward() * 10);
                break;
            }

            // Monster counter-attacks
            int monsterDamage = target.attack();
            player.takeDamage(monsterDamage);
            System.out.println(target.getName() + " attacks for " + monsterDamage + " damage!");
            System.out.println(player.getStatus());

            // BOOLEAN & IF STATEMENTS: Check if player is dead
            if (!player.isAlive()) {
                System.out.println("\n💀 You were defeated by " + target.getName() + "!");
                break;
            }
            System.out.println();
        }
    }

    private void useHealthPotion() {
        // ARRAYLIST: Check inventory
        ArrayList<Item> inventory = player.getInventory();
        int potionIndex = -1;

        // ITERATION: Find health potion in inventory
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getType().equals("potion")) {
                potionIndex = i;
                break;
            }
        }

        // BOOLEAN & IF STATEMENTS: Use potion
        if (potionIndex != -1) {
            Item potion = inventory.get(potionIndex);
            player.heal(potion.getBonus());
            inventory.remove(potionIndex);
            System.out.println("Used " + potion.getName() + "! Healed " + potion.getBonus() + " HP");
        } else {
            System.out.println("No health potions in inventory!");
        }
    }

    private void displayMonsterInfo() {
        ArrayList<Monster> monsters = gameMap.getMonsters();
        
        // ITERATION: Display all alive monsters
        System.out.println("\n--- Monsters on Map ---");
        if (monsters.isEmpty()) {
            System.out.println("No monsters");
        } else {
            for (Monster m : monsters) {
                if (m.isAlive()) {
                    System.out.println("- " + m.getStatus());
                }
            }
        }
    }
}