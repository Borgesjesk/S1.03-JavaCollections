package cat.itacademy.s1_03.n1.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        List<Integer> originalList = buildOriginalList();
        List<Integer> reversedList = buildReversedList(originalList);

        System.out.println("=== Original list ===");
        System.out.println(originalList);

        System.out.println("\n=== Reversed list using ListIterator ===");
        System.out.println(reversedList);
    }

    private static List<Integer> buildOriginalList() {
        return new ArrayList<>(List.of(10, 20, 30, 40, 50, 60, 70));
    }

    private static List<Integer> buildReversedList(List<Integer> original) {
        List<Integer> reversed = new ArrayList<>();
        ListIterator<Integer> iterator = original.listIterator(original.size());
        while (iterator.hasPrevious()) {
            reversed.add(iterator.previous());
        }
        return reversed;
    }
}