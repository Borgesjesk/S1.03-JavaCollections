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
        for (int i = 0; i < TOTAL_QUESTIONS; i++) {
            askQuestion(i + 1, selectedCountries.get(i), countries, player);
        }
    }

    private List<String> selectRandomCountries(Map<String, String> countries) {
        List<String> keys = new ArrayList<>(countries.keySet());
        Collections.shuffle(keys);
        return keys.subList(0, TOTAL_QUESTIONS);
    }

    private void askQuestion(int number, String country, Map<String, String> countries, Player player) {
        String answer = console.askQuestion(number, country);
        String correct = countries.get(country);
        if (answer.equalsIgnoreCase(correct)) {
            console.displayCorrect();
            player.addPoint();
        } else {
            console.displayWrong(country, correct);
        }
    }
}