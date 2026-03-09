package cat.itacademy.s1_03.n1.ex1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Creating 12 Month objects
        Month m1 = new Month("January");
        Month m2 = new Month("February");
        Month m3 = new Month("March");
        Month m4 = new Month("April");
        Month m5 = new Month("May");
        Month m6 = new Month("June");
        Month m7 = new Month("July");
        Month m8 = new Month("August");
        Month m9 = new Month("September");
        Month m10 = new Month("October");
        Month m11 = new Month("November");
        Month m12 = new Month("December");

        // ArrayList with 11 months — August is missing
        ArrayList<Month> months = new ArrayList<>(
                List.of(m1,m2,m3,m4,m5,m6,m7,m9,m10,m11,m12)
        );
        System.out.println("=== ArrayList without August ===");
        System.out.println(months);

        // Insert August at index 7 (its correct position)
        months.add(7, m8);
        System.out.println("\n=== ArrayList with August inserted at index 7 ===");
        System.out.println(months);

        // Convert to HashSet — duplicates are not allowed
        HashSet<Month> monthsSet = new HashSet<>(months);

        // Try to add January again — HashSet should ignore it
        monthsSet.add(m1);
        System.out.println("\n=== HashSet after trying to add January again ===");

        // Iterate using Iterator
        Iterator<Month> iterator = monthsSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }
        System.out.println("\n=> Duplicate was ignored as expected");
    }
}