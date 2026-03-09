package cat.itacademy.s1_03.n2.ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Restaurant> restaurants = buildRestaurantList();
        Collections.sort(restaurants);
        printRestaurants(restaurants);
    }

    private static List<Restaurant> buildRestaurantList() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("The Hungry Mistake", 9));
        restaurants.add(new Restaurant("Sir Fries A Lot", 8));
        restaurants.add(new Restaurant("The Hungry Mistake", 7));
        restaurants.add(new Restaurant("What The Fork", 5));
        restaurants.add(new Restaurant("Nacho Average Place", 9));
        restaurants.add(new Restaurant("Sir Fries A Lot", 3));
        restaurants.add(new Restaurant("Brunch Of Lies", 6));
        return restaurants;
    }

    private static void printRestaurants(List<Restaurant> restaurants) {
        System.out.println("=== Restaurants sorted alphabetically, rating descending ===");
        restaurants.forEach(System.out::println);
    }
}