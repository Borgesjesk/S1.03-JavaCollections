package cat.itacademy.s1_03.n2.ex1;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        HashSet<Restaurant> restaurants = buildRestaurantSet();
        printRestaurants(restaurants);
    }

    private static HashSet<Restaurant> buildRestaurantSet() {
        HashSet<Restaurant> restaurants = new HashSet<>();
        restaurants.add(new Restaurant("The Hungry Mistake", 9));
        restaurants.add(new Restaurant("Sir Fries A Lot", 8));
        restaurants.add(new Restaurant("What The Fork", 7));
        restaurants.add(new Restaurant("In Cod We Trust", 5));
        restaurants.add(new Restaurant("Nacho Average Place", 9));
        restaurants.add(new Restaurant("Brunch Of Lies", 6));
        restaurants.add(new Restaurant("The Hungry Mistake", 9)); // exact duplicate — should be ignored
        restaurants.add(new Restaurant("What The Fork", 3)); // same name, different rating — allowed
        return restaurants;
    }

    private static void printRestaurants(HashSet<Restaurant> restaurants) {
        System.out.println("=== Restaurant HashSet (no exact duplicates) ===");
        restaurants.forEach(System.out::println);
    }
}