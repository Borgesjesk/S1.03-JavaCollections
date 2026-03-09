# S1.03 - Java Collections 🗂️

## Level 2 — Exercise 1 — HashSet without exact duplicates 🍽️

### 📌 What this exercise does
Creates a `HashSet` of `Restaurant` objects and proves that exact duplicates
are rejected — but restaurants with the same name and a different rating
are allowed. Because yes, "What The Fork" can be a 7 one day and a 3 the next.

### 🧠 Key concepts I understood

**Why override equals() and hashCode()?**
Without them, Java compares objects by memory reference — every new
`Restaurant` object would be "different" even if name and rating are identical.
By overriding both methods, we tell Java exactly what makes two restaurants
the same: same name (case insensitive) AND same rating.

**Why both equals() AND hashCode()?**
HashSet first checks `hashCode()` to find the bucket, then uses `equals()`
to confirm. If you only override one, duplicates will slip through. They
always go together — no exceptions.

**What counts as a duplicate?**
- Same name + same rating → ❌ rejected
- Same name + different rating → ✅ allowed (it's a different experience!)

### 🛠 Technologies
- Java 21
- Maven
- IntelliJ IDEA

### 💻 Example output
```
=== Restaurant HashSet (no exact duplicates) ===
Restaurant: The Hungry Mistake | Rating: 9
Restaurant: Sir Fries A Lot | Rating: 8
Restaurant: What The Fork | Rating: 7
Restaurant: What The Fork | Rating: 3
Restaurant: In Cod We Trust | Rating: 5
Restaurant: Nacho Average Place | Rating: 9
Restaurant: Brunch Of Lies | Rating: 6
```

### ▶️ How to run
1. Clone the repository
2. Open in IntelliJ as a Maven project
3. Run `Main.java` inside `cat.itacademy.s1_03.n2.ex1`