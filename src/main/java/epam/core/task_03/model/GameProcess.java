package epam.core.task_03.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GameProcess {
    public static final int DUCKS_IN_GAME = 5;
    private Player player;
    private List<Duck> ducks;
    private BufferedReader reader;

    public List<Duck> getDucks() {
        return ducks;
    }

    public void setDucks(List<Duck> ducks) {
        this.ducks = ducks;
    }

    public Player getPlayer() {

        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public GameProcess() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.ducks = new ArrayList<>(DUCKS_IN_GAME);
        for (int i = 0; i < DUCKS_IN_GAME; i++) {
            ducks.add(new ChampionDuck());
        }
    }

    public GameProcess(Player player, List<Duck> ducks) {
        this.player = player;
        this.ducks = ducks;
    }

    public void begin() {
        while (player.getBalance() > 0) {
            enterBet();
            System.out.printf("Hi %s! Your balance is %d. Your bet is on duck #%d. Good luck!\n"
                    , player.getName(), player.getBalance(), player.getPlayerBet() + 1);
            player.setBalance(0);
        }
        System.out.println("YOU LOSE!");
    }

    private void enterBet() {
        boolean flag = true;
        while (flag) {
            int betNumber = 0;
            try {
                System.out.println("Enter number of duck you betting: ");
                betNumber = Integer.parseInt(reader.readLine());
                if (betNumber > 0 && betNumber <= GameProcess.DUCKS_IN_GAME) {
                    flag = false;
                    player.setPlayerBet(betNumber - 1);
                } else {
                    System.out.println("Please enter a valid number [There are "
                            + GameProcess.DUCKS_IN_GAME + " ducks in game]");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
