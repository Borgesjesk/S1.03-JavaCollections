package cat.itacademy.s1_03.n1.ex1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Main {

    private static final int AUGUST_INDEX = 7;

    public static void main(String[] args) {
        ArrayList<Month> months = buildMonthList();

        System.out.println("=== ArrayList without August ===");
        printList(months);

        insertAugust(months);
        System.out.println("\n=== ArrayList with August inserted ===");
        printList(months);

        HashSet<Month> monthsSet = convertToHashSet(months);
        verifyNoDuplicates(monthsSet, months.getFirst());

        System.out.println("\n=== Iterating with for loop ===");
        printWithForLoop(monthsSet);

        System.out.println("\n=== Iterating with Iterator ===");
        printWithIterator(monthsSet);
    }

    private static ArrayList<Month> buildMonthList() {
        return new ArrayList<>(List.of(
                new Month("January"), new Month("February"), new Month("March"),
                new Month("April"), new Month("May"), new Month("June"),
                new Month("July"), new Month("September"), new Month("October"),
                new Month("November"), new Month("December")
        ));
    }

    private static void insertAugust(ArrayList<Month> months) {
        months.add(AUGUST_INDEX, new Month("August"));
    }

    private static HashSet<Month> convertToHashSet(ArrayList<Month> months) {
        return new HashSet<>(months);
    }

    private static void verifyNoDuplicates(HashSet<Month> monthsSet, Month duplicate) {
        boolean added = monthsSet.add(duplicate);
        System.out.println("\n=== Duplicate test: tried to add '" + duplicate + "' again ===");
        System.out.println(added ? "=> Duplicate was added (unexpected!)" : "=> Duplicate was ignored as expected");
    }

    private static void printList(ArrayList<Month> months) {
        System.out.println(months);
    }

    private static void printWithForLoop(HashSet<Month> monthsSet) {
        for (Month m : monthsSet) {
            System.out.print(m + "  ");
        }
        System.out.println();
    }

    private static void printWithIterator(HashSet<Month> monthsSet) {
        Iterator<Month> iterator = monthsSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }
        System.out.println();
    }
}