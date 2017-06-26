package epam.core.task_03.generator;

import java.util.Random;

public class RandomValueGenerator {
    static Random random = new Random();

    public static int getRandomZeroOrOne() {
        return random.nextInt(2);
    }
}
