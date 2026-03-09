package cat.itacademy.s1_03.n2.ex2;

public class Restaurant implements Comparable<Restaurant> {

    private final String name;
    private final int rating;

    public Restaurant(String name, int rating) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Restaurant name cannot be empty");
        }
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Rating must be between 0 and 10");
        }
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public int compareTo(Restaurant other) {
        int nameComparison = this.name.compareToIgnoreCase(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        return Integer.compare(other.rating, this.rating); // descending rating
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant other)) return false;
        return rating == other.rating && name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return 31 * name.toLowerCase().hashCode() + rating;
    }

    @Override
    public String toString() {
        return "Restaurant: " + name + " | Rating: " + rating;
    }
}