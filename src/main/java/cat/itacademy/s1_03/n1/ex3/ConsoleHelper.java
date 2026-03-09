package cat.itacademy.s1_03.n1.ex3;

import java.util.List;
import java.util.Scanner;

public class ConsoleHelper {

    private final Scanner scanner;

    public ConsoleHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayWelcome() {
        System.out.println("========================================");
        System.out.println("       Welcome to the Capital Game!     ");
        System.out.println("  I dare you to name these European capitals!");
        System.out.println("========================================\n");
    }

    public void displayScoreboard(List<String> scores) {
        if (scores.isEmpty()) {
            System.out.println("No previous scores yet. Be the first to surprise me!\n");
            return;
        }
        System.out.println("=== Hall of Fame ===");
        scores.forEach(System.out::println);
        System.out.println();
    }

    public String askPlayerName() {
        System.out.print("Enter your name: ");
        return scanner.nextLine().trim();
    }

    public void displayRoundIntro(String playerName) {
        System.out.println("\nLet's go, " + playerName + "! 10 questions await you.\n");
    }

    public String askQuestion(int number, String country) {
        System.out.print("Question " + number + "/10 — What is the capital of " + country + "? ");
        return scanner.nextLine().trim();
    }

    public void displayCorrect() {
        System.out.println("✅ You got it!\n");
    }

    public void displayWrong(String country, String correct) {
        System.out.println("❌ Oh nooo! Wrong! The capital of " + country + " is " + correct + ".\n");
    }

    public void displayFinalScore(Player player) {
        System.out.println("========================================");
        System.out.println("You are finished, " + player.getName() + "!");
        System.out.println("Drumroll please... 🥁 You scored " + player.getScore() + "/10");
        if (player.getScore() == 10) {
            System.out.println("Woow! Perfect score! Outstanding! 🏆");
        } else if (player.getScore() >= 7) {
            System.out.println("I am shocked! You really know your capitals.");
        } else if (player.getScore() >= 4) {
            System.out.println("Not too bad! Better luck next time!");
        } else {
            System.out.println("Keep up — I know you'll get there!");
        }
        System.out.println("========================================\n");
    }
}