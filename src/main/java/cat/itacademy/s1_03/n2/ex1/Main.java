package cat.itacademy.s1_03.n2.ex1;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        HashSet<Restaurant> restaurants = buildRestaurantSet();
        printRestaurants(restaurants);
    }

    private static HashSet<Restaurant> buildRestaurantSet() {
        HashSet<Restaurant> restaurants = new HashSet<>();
        restaurants.add(new Restaurant("Restaurant A", 9));
        restaurants.add(new Restaurant("Restaurant B", 8));
        restaurants.add(new Restaurant("Restaurant A", 7));
        restaurants.add(new Restaurant("Restaurant A", 9)); // exact duplicate — should be ignored
        restaurants.add(new Restaurant("Restaurant C", 5));
        return restaurants;
    }

    private static void printRestaurants(HashSet<Restaurant> restaurants) {
        System.out.println("=== Restaurant HashSet (no exact duplicates) ===");
        restaurants.forEach(System.out::println);
    }
}