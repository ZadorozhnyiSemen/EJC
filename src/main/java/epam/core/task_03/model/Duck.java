package epam.core.task_03.model;

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

    public abstract void setRandomFlyBehavior();
}
