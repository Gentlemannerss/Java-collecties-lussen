import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welkom bij mijn cijfer naar tekst translator.");
        Translator translator = new Translator(numeric, alphabetic);
        boolean play = true;
        String invalid = "Invalid input";
        Scanner scanner = new Scanner(System.in);

        while (play) {
            System.out.println("Wil je een getal vertalen druk op 'v'. Wil je stoppen druk op 'x'. Of wil je een leuke mini-game, druk op 'm'");
            String input = scanner.nextLine();
                if (input.equals("x")) {
                    play = false;
                } else if (input.equals("v")) {
                    System.out.println("Type een cijfer van 0 t/m 9");
                    int number = scanner.nextInt();
                    scanner.nextLine();
                        if (number < 10) {
                            String result = translator.translate(number);
                            System.out.println("De vertaling van " + number + " is " + result);
                        } else {
                            System.out.println(invalid);
                        }
                } else if (input.equals("m")) {
                    System.out.println("Mini-game Time");
                    HashSet<Integer> secretNumber = randomNumber.randomNumberGenerator();
                    String stringNumber = randomNumber.setToString(secretNumber);
                    System.out.println(stringNumber); //deze moet uitgecomment worden voor als je het spel echt wil spelen.
                    feedback(stringNumber);
                } else {
                    System.out.println(invalid);
                }
        }


    }

    public static Integer[] numeric = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    public static final String[] alphabetic = {"een", "twee", "drie", "vier", "vijf", "zes", "zeven", "acht", "negen", "nul"};

    public static void feedback(String stringNumber) {
        Scanner scanner = new Scanner(System.in);
        int maxGuesses = 10;
        int numGuesses = 0;
        String guess = "";

        while (!guess.equals(stringNumber) && numGuesses < maxGuesses) {
            System.out.println("take a guess " + (maxGuesses - numGuesses) + " guesses left)");
            guess = scanner.nextLine();
            StringBuilder feedback = new StringBuilder();
            if (Objects.equals(guess, stringNumber)) {
                System.out.println("gefeliciteerd je hebt het goed");
            } else if (guess.length() !=4) {
                System.out.println("Your guess must be a 4 digit number");
            } else {
                for (int i = 0; i < 4; i++) {
                    if (guess.substring(i, i + 1).equals(stringNumber.substring(i, i + 1))) {
                        feedback.append("+");
                    } else if (stringNumber.contains(guess.substring(i, i + 1))) {
                        feedback.append("0");
                    } else {
                        feedback.append("X");
                    }
                }
                System.out.println("Helaas, verkeerd geraden. \n + betekent dat het cijfer juist is en op de juiste plek staat. \n O betekent een juist cijfer, maar verkeerde plek. \n X betekent dat het cijfer er niet in zit. \nProbeer nogmaals:");
            }
            System.out.println(feedback.toString());
            numGuesses++;
        }
        if (numGuesses == maxGuesses) {
            System.out.println("You ran out of guesses. The secret number was " + stringNumber);
        }
    }
}
