package cat.itacademy.s1_03.n1.ex3;

import java.util.*;

public class GameService {

    private static final int TOTAL_QUESTIONS = 10;
    private final FileService fileService;
    private final ConsoleHelper console;

    public GameService(FileService fileService, ConsoleHelper console) {
        this.fileService = fileService;
        this.console = console;
    }

    public void startGame() {
        Map<String, String> countries = fileService.loadCountries();

        // --- TEACHER FEEDBACK: Robustness Check ---
        if (countries == null || countries.size() < TOTAL_QUESTIONS) {
            System.err.println("\n[SYSTEM ERROR] Cannot start game.");
            System.err.println("Required countries: " + TOTAL_QUESTIONS);
            System.err.println("Available in file: " + (countries == null ? 0 : countries.size()));
            System.err.println("Please check your resources/countries.txt file.\n");
            return;
        }

        console.displayWelcome();
        console.displayScoreboard(fileService.loadScoreboard());

        Player player = new Player(console.askPlayerName());
        playRounds(countries, player);

        console.displayFinalScore(player);
        fileService.saveResult(player);
    }

    private void playRounds(Map<String, String> countries, Player player) {
        List<String> selectedCountries = selectRandomCountries(countries);
        console.displayRoundIntro(player.getName());

        // Defensive loop limit
        int rounds = Math.min(TOTAL_QUESTIONS, selectedCountries.size());
        for (int i = 0; i < rounds; i++) {
            askQuestion(i + 1, selectedCountries.get(i), countries, player);
        }
    }

    private List<String> selectRandomCountries(Map<String, String> countries) {
        List<String> keys = new ArrayList<>(countries.keySet());
        Collections.shuffle(keys);

        // --- TEACHER FEEDBACK: Safe subList ---
        int limit = Math.min(keys.size(), TOTAL_QUESTIONS);
        return keys.subList(0, limit);
    }

    private void askQuestion(int number, String country, Map<String, String> countries, Player player) {
        String answer = console.askQuestion(number, country);
        String correct = countries.get(country);

        if (answer != null && answer.equalsIgnoreCase(correct)) {
            console.displayCorrect();
            player.addPoint();
        } else {
            console.displayWrong(country, correct);
        }
    }
}