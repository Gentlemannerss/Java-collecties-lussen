import java.util.HashSet;
import java.util.Random;
public class randomNumber {
    public static HashSet<Integer> randomNumberGenerator() {
        HashSet<Integer> numbers = new HashSet<>();
        Random random = new Random();

        while (numbers.size() < 4) {
            int randomNumber = random.nextInt(9) + 1; // generates a random number between 1 and 9
            numbers.add(randomNumber);
        }

        return numbers;
    }

    public static String setToString(HashSet<Integer> set) {
        StringBuilder sb = new StringBuilder();
        for (Integer num : set) {
            sb.append(num);
        }
        return sb.toString();
    }
}
