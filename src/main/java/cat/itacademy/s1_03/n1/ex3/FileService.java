package cat.itacademy.s1_03.n1.ex3;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.nio.charset.StandardCharsets;

public class FileService {

    private static final String COUNTRIES_FILE = "countries.txt";
    private static final String SCOREBOARD_FILE = "classificacio.txt";

    public Map<String, String> loadCountries() {
        Map<String, String> countries = new HashMap<>();

        // Professional approach: Load from classpath resources
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(COUNTRIES_FILE)) {
            if (is == null) {
                System.err.println("Error: Resource file not found: " + COUNTRIES_FILE);
                return countries;
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    parseLine(line, countries);
                }
            }
        } catch (IOException e) {
            System.err.println("Critical Error loading countries: " + e.getMessage());
        }
        return countries;
    }

    private void parseLine(String line, Map<String, String> countries) {
        String trimmed = line.trim();
        if (trimmed.isBlank()) return;

        // Split by whitespace with a limit of 2 to handle names correctly
        String[] parts = trimmed.split("\\s+", 2);
        if (parts.length < 2) return;

        String country = parts[0].replace("_", " ");
        String capital = parts[1].replace("_", " ");
        countries.put(country, capital);
    }

    public void saveResult(Player player) {
        // We write to a local file for the scoreboard so it persists outside the JAR
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SCOREBOARD_FILE, true))) {
            writer.write(player.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving result: " + e.getMessage());
        }
    }

    public List<String> loadScoreboard() {
        List<String> scores = new ArrayList<>();
        File file = new File(SCOREBOARD_FILE);
        if (!file.exists()) return scores;

        try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) scores.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error loading scoreboard: " + e.getMessage());
        }
        return scores;
    }
}