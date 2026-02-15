/**
 * GameMap class demonstrating:
 * - 2D ARRAYS (game map grid)
 * - ITERATION (traversing the grid)
 * - OBJECTS (contains Player and Monster objects)
 */
public class GameMap {
    // 2D ARRAY: game world
    private char[][] grid;
    private int width;
    private int height;
    private Player player;
    private java.util.ArrayList<Monster> monsters;

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new char[height][width];
        this.monsters = new java.util.ArrayList<>();
        initializeGrid();
    }

    private void initializeGrid() {
        // ITERATION: filling the grid
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = '.';
            }
        }
    }

    public void setPlayer(Player player) {
        this.player = player;
        updateGrid();
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
        updateGrid();
    }

    public java.util.ArrayList<Monster> getMonsters() {
        return monsters;
    }

    private void updateGrid() {
        initializeGrid();
        // 2D ARRAY: placing player
        if (player != null) {
            grid[player.getY()][player.getX()] = 'P';
        }
        // ITERATION: placing monsters
        for (Monster m : monsters) {
            if (m.isAlive()) {
                grid[m.getY()][m.getX()] = 'M';
            }
        }
    }

    public void display() {
        System.out.println("\n╔" + "═".repeat(width * 2 - 1) + "╗");
        // ITERATION: 2D array traversal
        for (int i = 0; i < height; i++) {
            System.out.print("║");
            for (int j = 0; j < width; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("║");
        }
        System.out.println("╚" + "═".repeat(width * 2 - 1) + "╝");
    }

    public boolean isMonsterNear(Player player) {
        int px = player.getX();
        int py = player.getY();
        for (Monster m : monsters) {
            if (m.isAlive()) {
                // BOOLEAN & IF STATEMENTS: distance check
                int distance = Math.abs(px - m.getX()) + Math.abs(py - m.getY());
                if (distance == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public Monster getNearestMonster(Player player) {
        int px = player.getX();
        int py = player.getY();
        Monster nearest = null;
        int minDistance = Integer.MAX_VALUE;

        for (Monster m : monsters) {
            if (m.isAlive()) {
                int distance = Math.abs(px - m.getX()) + Math.abs(py - m.getY());
                if (distance < minDistance) {
                    minDistance = distance;
                    nearest = m;
                }
            }
        }
        return nearest;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}