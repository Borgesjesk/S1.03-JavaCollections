package cat.itacademy.s1_03.n1.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        // Original list with 7 numbers
        List<Integer> originalList = new ArrayList<>(List.of(10, 20, 30, 40, 50, 60, 70));
        List<Integer> reversedList = new ArrayList<>();

        // ListIterator starts at the END and reads backwards
        ListIterator<Integer> iterator = originalList.listIterator(originalList.size());
        while (iterator.hasPrevious()) {
            reversedList.add(iterator.previous());
        }

        System.out.println("=== Original list ===");
        System.out.println(originalList);

        System.out.println("\n=== Reversed list using ListIterator ===");
        System.out.println(reversedList);
    }
}