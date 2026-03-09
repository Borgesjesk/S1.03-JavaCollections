# S1.03 - Java Collections 🗂️

## 📌 Description
Collections are everywhere in Java and this project is proof of that.
From a simple list of months to a full quiz game about European capitals,
each exercise made me understand not just HOW collections work — but WHY
you would pick one over another. ArrayList vs HashSet, HashMap for instant
lookups, ListIterator when you need to go backwards — it all started making
sense here.

## 📌 Exercise Statement
Work with the most common Java collection classes: `ArrayList`, `HashSet`,
`HashMap` and `ListIterator`. Practice managing duplicates, comparing objects,
sorting, reading and writing files, and interacting with the user through
small programs that combine collections in a practical, clear and well
structured way.

## ✨ Exercises

### Level 1

**Ex1 — Duplicates**
I created a `Month` class and added 11 months to an `ArrayList`, leaving
August out on purpose. Then I inserted it at the correct position and converted
the list to a `HashSet` to verify duplicates were rejected. For this to actually
work I had to override `equals()` and `hashCode()` — without them, the HashSet
would have compared memory references and let duplicates through without saying
a word.

**Ex2 — ListIterator**
Reversed a list of integers using `ListIterator` — starting from the end and
moving backwards with `hasPrevious()` and `previous()`. The original list
stays untouched while a brand new reversed list is built. Simple but satisfying.

**Ex3 — Capital Game 🌍**
This one was my favourite. A full quiz game that reads European country-capital
pairs from a file, picks 10 random questions, tracks the score and saves
everything to a Hall of Fame. I separated responsibilities into four classes:
`Player`, `FileService`, `GameService` and `ConsoleHelper` — because game logic
should not care about how things are printed, and file reading should not care
about the game. Each class does one thing and does it well.

### Level 2

**Ex1 — HashSet without exact duplicates**
Created a `Restaurant` class with funny names (you're welcome) and made sure
that exact duplicates — same name AND same rating — are rejected by the HashSet.
Same name with a different rating is allowed, because "What The Fork" can have
a bad day too.

**Ex2 — Multiple sorting**
Extended `Restaurant` with `Comparable` to sort alphabetically by name and,
when names match, by rating in descending order. So the best version of
"Sir Fries A Lot" always comes first.

## 🛠 Technologies
- Java 21
- Maven
- IntelliJ IDEA

## 🚀 Installation and Execution
1. Clone the repository: `git clone <repository-url>`
2. Open in IntelliJ as a Maven project
3. Run the `Main.java` of the exercise you want to try
4. For **Ex3**, make sure `countries.txt` is inside the `Resources` folder

## 🧩 Project Structure
```
S1.03-JavaCollections/
├── src/main/java/cat/itacademy/s1_03/
│   ├── n1/
│   │   ├── ex1/ → Month, Main
│   │   ├── ex2/ → Main
│   │   └── ex3/ → Player, FileService, GameService, ConsoleHelper, Main
│   └── n2/
│       ├── ex1/ → Restaurant, Main
│       └── ex2/ → Restaurant, Main
├── Resources/
│   ├── countries.txt
│   └── classificacio.txt (generated after first game)
└── README.md
```

## 📸 Demo

### Ex1 — ArrayList and HashSet
```
=== ArrayList without August ===
[January, February, March, April, May, June, July, September, October, November, December]
=== ArrayList with August inserted ===
[January, February, March, April, May, June, July, August, September, October, November, December]
=== Duplicate test: tried to add 'January' again ===
=> Duplicate was ignored as expected
```

### Ex2 — ListIterator
```
=== Original list ===
[10, 20, 30, 40, 50, 60, 70]
=== Reversed list using ListIterator ===
[70, 60, 50, 40, 30, 20, 10]
```

### Ex3 — Capital Game
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
...
Drumroll please... 🥁 You scored 7/10
I am shocked! You really know your capitals.
========================================
```

### N2 Ex2 — Restaurant Sorting
```
=== Restaurants sorted alphabetically, rating descending ===
Restaurant: Brunch Of Lies | Rating: 6
Restaurant: Nacho Average Place | Rating: 9
Restaurant: Sir Fries A Lot | Rating: 8
Restaurant: Sir Fries A Lot | Rating: 3
Restaurant: The Hungry Mistake | Rating: 9
Restaurant: The Hungry Mistake | Rating: 7
Restaurant: What The Fork | Rating: 5
```