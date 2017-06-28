package epam.core.task_03.model;

import epam.core.task_03.generator.RandomValueGenerator;

public class FlyFast implements FlyBehavior {
    @Override
    public int fly() {
        switch (RandomValueGenerator.getRandomZeroOrOne()) {
            case 0: return RandomValueGenerator.getFromTenToHundred() << 1;
            case 1: return RandomValueGenerator.getFromTenToHundred() >> 1;
        }
        return -1;
    }
}
