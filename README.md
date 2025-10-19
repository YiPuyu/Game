# Gold Miner

**Author:** YiPuyu

## 🎮 Project Overview
**Gold Miner** is a Java Swing-based arcade-style game where the player aims to collect gold while avoiding rocks. The game features multiple levels with increasing difficulty, providing a classic mining experience in a simple GUI environment.

## 🖼️ Screenshot
![Gold Miner Screenshot](13122b0c-23d2-4a17-97f4-456949e07a64.png)

## 🧩 Gameplay
- **Objective:** Collect enough gold to reach the target score and advance to the next level.
- **Controls:**
  - **Left Mouse Click:** Launch the hook to grab gold.
  - **Right Mouse Click:** Use a water bottle to remove obstacles (rocks).
  - **Triple Click on Screen:** Start the game.
- **Level Progression:** The game automatically progresses to the next level when the target score is achieved. There are 3 levels in total.

## ⚙️ Features
- Multiple levels with different challenges.
- Randomly generated gold items:
  - `Gold` – standard gold.
  - `GoldMini` – smaller gold with lower value.
  - `GoldPlus` – larger gold with higher value.
- `Rock` objects as obstacles.
- Hook implemented as a `line` object with animated movement.
- Background and level logic handled by `bg` class.
- Object-oriented design allows easy extension of game objects.

## 🏗️ Project Structure
src/
└── com/sxt/
├── gameWin.java # Main game window and loop
├── GameObject.java # Base class for all game objects
├── Gold.java # Standard gold
├── GoldMini.java # Small gold
├── GoldPlus.java # Large gold
├── Rock.java # Rock obstacle
├── line.java # Hook mechanics
└── bg.java # Background, level, and timing logic



## ⚙️ How to Run
1. Ensure **JDK 8+** is installed.
2. Compile the project:
```bash
javac -d out src/com/sxt/*.java
Run the game:


java -cp out com.sxt.gameWin
Or open in IntelliJ IDEA / Eclipse and run gameWin.java.

🧠 Concepts Used
Java Swing for GUI rendering.

Double buffering to reduce flicker (offScreenImage).

Event-driven programming (MouseAdapter) for input.

Game loop using while(true) + repaint() + Thread.sleep().

Collision detection via rectangle intersection.

🏆 Future Improvements
Add score display and in-game UI.

Keyboard control support.

Pause menu and settings.

Optimize animations with a dedicated timer thread.

yaml
复制代码
