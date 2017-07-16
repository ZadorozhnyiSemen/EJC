package task_03.model;

import task_03.generator.RandomValueGenerator;

/**
 * Champion Duck this ducks implements ability to fly
 * FlyBehavior is random and sets when object is created
 *
 * @see task_03.model.Duck
 *
 * @author Zadorozhnyi Semen
 * @since GameCasino_v0.0.1
 */
public class ChampionDuck extends Duck {
    public ChampionDuck(int number) {
        setNumber(number);
        setRandomFlyBehavior();
    }

    @Override
    public void setTotalDistance(int totalDistance) {
        super.setTotalDistance(totalDistance);
    }

    /**
     * {@inheritDoc}
     */
    public void setRandomFlyBehavior() {
        switch (RandomValueGenerator.getRandomZeroOrOne()) {
            case 0: setFlyBehavior(new FlyNoWay());
                break;
            case 1: setFlyBehavior(new FlyFast());
                break;
        }
    }
}
