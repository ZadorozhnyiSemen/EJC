package epam.core.task_03.model;

import epam.core.task_03.generator.RandomValueGenerator;

public class ChampionDuck extends Duck {
    public ChampionDuck(int number) {
        setNumber(number);
        setRandomFlyBehavior();
    }

    @Override
    public void setTotalDistance(int totalDistance) {
        super.setTotalDistance(totalDistance);
    }

    @Override
    public void setRandomFlyBehavior() {
        switch (RandomValueGenerator.getRandomZeroOrOne()) {
            case 0: setFlyBehavior(new FlyNoWay());
                break;
            case 1: setFlyBehavior(new FlyFast());
                break;
        }
    }
}
