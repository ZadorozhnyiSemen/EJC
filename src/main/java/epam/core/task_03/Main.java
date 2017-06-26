package epam.core.task_03;

import epam.core.task_03.generator.RandomValueGenerator;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int one = 0;
        int zero = 0;
        int randomResult;
        for (int i = 0; i < 5000; i++) {
            randomResult = RandomValueGenerator.getRandomZeroOrOne();
            System.out.println(randomResult);
            switch (randomResult) {
                case 0: zero++;
                break;
                case 1: one++;
                break;
                default:
                    System.out.println("Can't be");
            }
        }
        System.out.println("Count of zeros: " + zero);
        System.out.println("Count of ones: " + one);
    }
}
