package cat.itacademy.s1_03.n1.ex3;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileService {

    private static final String COUNTRIES_FILE = "src/main/java/cat/itacademy/s1_03/n1/ex3/Resources/countries.txt";
    private static final String SCOREBOARD_FILE = "src/main/java/cat/itacademy/s1_03/n1/ex3/Resources/classificacio.txt";

    public Map<String, String> loadCountries() {
        Map<String, String> countries = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(COUNTRIES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                parseLine(line, countries);
            }
        } catch (IOException e) {
            System.out.println("Error loading countries: " + e.getMessage());
        }
        return countries;
    }

    private void parseLine(String line, Map<String, String> countries) {
        String trimmed = line.trim();
        if (trimmed.isBlank()) return;
        String[] parts = trimmed.split(" ");
        if (parts.length < 2) return;
        String country = parts[0].replace("_", " ");
        String capital = parts[1].replace("_", " ");
        countries.put(country, capital);
    }

    public void saveResult(Player player) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SCOREBOARD_FILE, true))) {
            writer.write(player.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving result: " + e.getMessage());
        }
    }

    public List<String> loadScoreboard() {
        List<String> scores = new ArrayList<>();
        File file = new File(SCOREBOARD_FILE);
        if (!file.exists()) return scores;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) scores.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading scoreboard: " + e.getMessage());
        }
        return scores;
    }
}