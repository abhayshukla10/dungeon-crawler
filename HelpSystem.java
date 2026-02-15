/**
 * HelpSystem class demonstrating RECURSION
 * Recursively displays nested help menu structure
 */
public class HelpSystem {
    private static final String INDENT = "  ";

    /**
     * RECURSION: Recursively display help menu with depth tracking
     */
    public static void displayHelp(int depth) {
        // Base case: stop at depth 5
        if (depth > 5) {
            return;
        }

        String prefix = INDENT.repeat(depth);

        if (depth == 0) {
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║         GAME HELP MENU             ║");
            System.out.println("╚════════════════════════════════════╝");
        }

        if (depth == 0) {
            System.out.println(prefix + "1. Movement");
            displayHelp(depth + 1);
        } else if (depth == 1) {
            System.out.println(prefix + "- Use W/A/S/D to move around");
            System.out.println(prefix + "- Coordinates (X, Y) on map");
            displayHelp(depth + 1);
        } else if (depth == 2) {
            System.out.println(prefix + "2. Combat");
            displayHelp(depth + 1);
        } else if (depth == 3) {
            System.out.println(prefix + "- Attack adjacent monsters");
            System.out.println(prefix + "- Monsters counter-attack");
            displayHelp(depth + 1);
        } else if (depth == 4) {
            System.out.println(prefix + "3. Items & Inventory");
            displayHelp(depth + 1);
        } else if (depth == 5) {
            System.out.println(prefix + "- Collect items to increase stats");
            System.out.println(prefix + "- View inventory with 'i' command");
            System.out.println();
        }
    }

    /**
     * Alternative recursive method to count depth
     */
    public static int getMaxDepth(int current) {
        if (current >= 5) {
            return current;
        }
        return getMaxDepth(current + 1);
    }
}