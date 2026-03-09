package cat.itacademy.s1_03.n1.ex3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileService fileService = new FileService();
        ConsoleHelper console = new ConsoleHelper(scanner);
        GameService gameService = new GameService(fileService, console);
        gameService.startGame();
        scanner.close();
    }
}