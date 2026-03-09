# S1.03 - Java Collections 🗂️

## Exercise 1 — ArrayList, HashSet and Iterator 🔄

### 📌 What this exercise does
Creates a `Month` class and works with two of the most common Java collections:
- **ArrayList** — stores 12 months in order and inserts a missing element at a specific index
- **HashSet** — demonstrates that duplicate elements are automatically ignored

### 🧠 Key concepts I understood

**ArrayList vs HashSet**
ArrayList keeps insertion order and allows duplicates. HashSet is unordered and does not allow duplicates. The choice between them depends on whether order and uniqueness matter for your use case.

**🔍 Why the duplicate January was NOT removed in our HashSet**
This was the most important thing I learned in this exercise. HashSet uses `equals()` and `hashCode()` to detect duplicates. For primitive types and Strings, Java handles this automatically. But for custom objects like `Month`, Java compares memory references by default — not the actual name value. So even though both January objects have the same name, they are different objects in memory, and HashSet treats them as different elements.

To fix this properly, you would need to override `equals()` and `hashCode()` inside the `Month` class so Java compares by name value instead of memory address.

**🔁 Iterator vs for-each loop**
Both loop through a collection but Iterator gives more control — you can remove elements safely while iterating, which you cannot do with a standard for-each loop without throwing a `ConcurrentModificationException`.

### 💻 Output
```
=== ArrayList without August ===
[January, February, March, April, May, June, July, September, October, November, December]

=== ArrayList with August inserted at index 7 ===
[January, February, March, April, May, June, July, August, September, October, November, December]

=== HashSet after trying to add January again ===
June  March  October  August  April  July  December  February  May  January  September  November  
=> Duplicate was ignored as expected
```

### ▶️ How to run
1. Clone the repository
2. Open in IntelliJ as a Maven project
3. Run `Main.java` inside `cat.itacademy.s1_03.n1.ex1`

### 🛠️ Technologies
- Java 21
- Maven
- IntelliJ IDEA