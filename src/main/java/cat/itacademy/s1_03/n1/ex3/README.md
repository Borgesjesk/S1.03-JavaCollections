# S1.03 - Java Collections 🗂️

## Exercise 3 — Capital Game 🌍

### 📌 What this exercise does
A command-line quiz game that tests your knowledge of European capitals.
The program loads country-capital pairs from a file, asks 10 random questions,
tracks your score and saves it to a Hall of Fame — so you can always come back
and try to beat yourself!

### 🏗 Structure
- **`Player.java`** — holds the player's name and score
- **`FileService.java`** — reads `countries.txt` and writes results to `classificacio.txt`
- **`GameService.java`** — pure game logic: selects random countries, evaluates answers
- **`ConsoleHelper.java`** — handles all user interaction and display messages
- **`Main.java`** — wires everything together and launches the game

### 🧠 Key concepts I understood

**Why separate ConsoleHelper from GameService?**
GameService should only care about game logic — not about how things are printed.
ConsoleHelper owns all user interaction, which makes each class have a single
clear responsibility. This is the S in SOLID.

**Why use HashMap for countries?**
Because we need to look up a capital by country name instantly — HashMap gives
us O(1) lookup time. A list would require scanning every element.

**Why append to classificacio.txt instead of overwriting?**
So the Hall of Fame keeps growing with every game played — history is never lost!

### 🛠 Technologies
- Java 21
- Maven
- IntelliJ IDEA

### 💻 Example output
```
========================================
       Welcome to the Capital Game!
  I dare you to name these European capitals!
========================================

No previous scores yet. Be the first to surprise me!

Enter your name: Jess

Let's go, Jess! 10 questions await you.

Question 1/10 — What is the capital of Croatia? Zagreb
✅ You got it!

Question 2/10 — What is the capital of Iceland? London
❌ Oh nooo! Wrong! The capital of Iceland is Reikiavik.

...

========================================
You are finished, Jess!
Drumroll please... 🥁 You scored 7/10
I am shocked! You really know your capitals.
========================================
```

### ▶️ How to run
1. Clone the repository
2. Open in IntelliJ as a Maven project
3. Run `Main.java` inside `cat.itacademy.s1_03.n1.ex3`
4. Enter your name and answer 10 questions — good luck! 🍀