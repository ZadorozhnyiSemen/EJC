package epam.core.task_03.model;

import java.util.ArrayList;
import java.util.List;

public class GameProcess {
    private static final int DUCKS_IN_GAME = 5;
    private Player player;
    private List<Duck> ducks;

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

    }
}
