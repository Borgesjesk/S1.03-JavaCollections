# S1.03 - Java Collections 🗂️

## Level 2 — Exercise 2 — Multiple Sorting 🔢

### 📌 What this exercise does
Takes the `Restaurant` class from ex1 and adds sorting functionality.
Restaurants are sorted alphabetically by name — and when two restaurants
share the same name, the higher rated one comes first. Because obviously
"Sir Fries A Lot" with a 8 deserves to be seen before the sad 3-rated version.

### 🧠 Key concepts I understood

**Why Comparable and not Comparator?**
`Comparable` is used when there is one natural, obvious way to sort an object —
in this case, alphabetically by name and then by rating descending. It lives
inside the class itself, which makes sense since sorting is part of what
a Restaurant "is".

`Comparator` would be better if we needed multiple different sorting strategies
from outside the class — for example, sort by rating only, or by name length.

**How compareTo() works**
First it compares names with `compareToIgnoreCase()`. If names are different,
that result decides the order. If names are equal, it compares ratings in
reverse (`Integer.compare(other.rating, this.rating)`) to get descending order.

### 🛠 Technologies
- Java 21
- Maven
- IntelliJ IDEA

### 💻 Example output
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

### ▶️ How to run
1. Clone the repository
2. Open in IntelliJ as a Maven project
3. Run `Main.java` inside `cat.itacademy.s1_03.n2.ex2`