package epam.core.task_03.model;

public class ChampionDuck extends Duck {
    public ChampionDuck() {
        flyBehavior = new FlyNoWay();
    }
}
