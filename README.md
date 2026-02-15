## Aboult the game

- **Grid-Based World**: Navigate a 10x10 dungeon using WASD commands
- **Dynamic Combat**: Turn-based battles with real-time strategy
- **Character Progression**: Level up, gain experience, and increase stats
- **Inventory System**: Collect and manage weapons, armor, and potions
- **Multiple Enemies**: Fight Goblins, Orcs, and Dragons with unique stats
- **Recursive Help System**: Nested menu navigation for game guidance

## How to Run

To play the Dungeon Crawler game:

1. **Ensure you have Java installed** (Java 8 or higher)
   - Check by running: `java -version`

2. **Clone or download all files** from this repository into one folder

3. **Open Terminal/Command Prompt** and navigate to the folder:
   ```bash
   cd dungeon-crawler
   ```

4. **Compile all Java files**:
   ```bash
   javac *.java
   ```

5. **Start the game**:
   ```bash
   java DungeonCrawler
   ```

The game will launch and display the dungeon map.

## Game Rules

### Movement
- Use `w`, `a`, `s`, `d` to move up, left, down, and right
- Your character is represented by `P` on the map
- Monsters appear as `M` on the map
- Empty spaces are shown as `.`

### Combat
- Type `attack` to engage the nearest monster in combat
- Combat is turn-based: you attack, then the monster counter-attacks
- Damage is calculated based on your strength stat plus randomness
- Continue attacking until either you or the monster is defeated
- Winning grants **experience points** and **gold rewards**

### Character Progression
- Level Up: Gain experience from defeating monsters to level up
- Health Increase: Max health increases with each level
- Strength Boost: Attack power increases with each level
- Check your progress with `status`

### Winning & Losing
- WIN: Defeat all monsters in the dungeon
- LOSE: Your health reaches 0 during combat

# Commands
- `w` to Move up
- `a` to Move left
- `s` to Move down
- `d` to Move right
- `attack` to Engage nearest monster in combat
- `i` to Display inventory
- `heal` to Use health potion from inventory
- `status` to Show player stats (HP, Level, Score)
- `help` to Display help menu with game info
- `quit` to Exit the game


## Example Gameplay

```
╔═════════════════════╗
║P . . . . . . . . . ║
║. . . . . . . . . . ║
║. . . . . M . . . . ║
║. . . M . . . . . . ║
║. . . . . . . . . . ║
║. . . . . . . M . . ║
║. . . . . . . . . . ║
║. . . . . . . . . . ║
║. . . . . . . . . . ║
║. . . . . . . . . . ║
╚═════════════════════╝

╔════════════════════╗
║ PLAYER STATS       ║
║ Name: Hero         ║
║ Level: 1           ║
║ HP: 100            ║
║ Score: 0           ║
╚════════════════════╝

--- Monsters on Map ---
- Goblin (HP: 30/30)
- Orc (HP: 50/50)
- Dragon (HP: 80/80)

> attack
  COMBAT START: Hero vs Goblin
Hero attacks for 18 damage!
Goblin (HP: 12/30)
Goblin attacks for 7 damage!
Hero (HP: 93/100)
...
 You defeated Goblin!
```
