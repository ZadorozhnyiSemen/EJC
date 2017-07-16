package task_03;

import task_03.game.GameProcess;
import task_03.model.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DucksCasino {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            GameProcess game = new GameProcess();
            System.out.println("Enter your name: ");
            String name = reader.readLine();
            game.setPlayer(new Player(name));
            game.begin();
        } catch (IOException e) {
            System.err.println("Unable to read line!");
            e.printStackTrace();
        }
    }
}
