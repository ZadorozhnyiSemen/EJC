package epam.core.task_03;

import epam.core.task_03.generator.RandomValueGenerator;
import epam.core.task_03.model.ChampionDuck;
import epam.core.task_03.model.Duck;
import epam.core.task_03.model.GameProcess;
import epam.core.task_03.model.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        GameProcess game = new GameProcess();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your name: ");
        try {
            String name = reader.readLine();
            game.setPlayer(new Player(name));
            game.begin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
