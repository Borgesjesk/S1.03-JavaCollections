# S1.03 - Java Collections 🗂️


## Exercise 2 — ListIterator 🔁

### 📌 What this exercise does
Creates two lists of integers:
- **originalList** — filled with numbers in order
- **reversedList** — filled with the same numbers but in reverse order using `ListIterator`

### 🧠 Key concepts I understood

**Why ListIterator and not Collections.reverse()?**
`Collections.reverse()` would modify the original list. Using `ListIterator` we read the original list backwards without touching it — the original stays intact while we build a completely new reversed list.

**How ListIterator works backwards**
By calling `listIterator(list.size())` we place the cursor at the END of the list. Then `hasPrevious()` and `previous()` move backwards through each element — the opposite of a normal iterator.

### 💻 Output
```
=== Original list ===
[10, 20, 30, 40, 50, 60, 70]

=== Reversed list using ListIterator ===
[70, 60, 50, 40, 30, 20, 10]
```

### ▶️ How to run
1. Clone the repository
2. Open in IntelliJ as a Maven project
3. Run `Main.java` inside `cat.itacademy.s1_03.n1.ex2`