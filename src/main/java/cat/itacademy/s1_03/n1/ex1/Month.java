package cat.itacademy.s1_03.n1.ex1;

public class Month {

    private final String name;

    public Month(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Month name cannot be empty");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Month other)) return false;
        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}