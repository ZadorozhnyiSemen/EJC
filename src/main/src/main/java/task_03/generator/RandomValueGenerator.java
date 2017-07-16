package task_03.generator;

import java.util.Random;

public class RandomValueGenerator {
    private static Random random = new Random();

    public static int getRandomZeroOrOne() {
        return random.nextInt(2);
    }

    public static int getFromTenToHundred() {
        return 10 + random.nextInt(90);
    }
}
