package epam.core.task_03.model;

/**
 * Simple Duck class represents Duck for CasinoGame
 * Each Duck can have number and total distance it went
 * in game.
 * Also every Duck have it's own fly behavior interface
 * and able to fly!
 * @see epam.core.task_03.model.FlyBehavior
 *
 *
 * @author Zadorozhnyi Semen
 * @since GameCasino_v0.0.1
 */
public abstract class Duck {
    private FlyBehavior flyBehavior;
    private int totalDistance;
    private int number;
    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Duck() {
    }

    public int performFly() {
        int flyDistance = flyBehavior.fly();
        this.totalDistance += flyDistance;
        return flyDistance;
    }

    /**
     * Sets random fly behavior for duck
     */
    public abstract void setRandomFlyBehavior();
}
