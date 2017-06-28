package epam.core.task_03;

import epam.core.task_03.generator.RandomValueGenerator;
import epam.core.task_03.model.ChampionDuck;
import epam.core.task_03.model.Duck;
import epam.core.task_03.model.GameProcess;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        GameProcess game = new GameProcess();
        game.getDucks()
                .forEach(duck ->  {
                    System.out.println(duck.performFly());
                    System.out.println(duck.getTotalDistance());
                });

    }
}
