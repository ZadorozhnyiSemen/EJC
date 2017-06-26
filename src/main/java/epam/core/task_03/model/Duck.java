package epam.core.task_03.model;

public abstract class Duck {
    FlyBehavior flyBehavior;
    int distance;

    public Duck() {
    }

    public void performFly() {
        flyBehavior.fly();
    }
}
