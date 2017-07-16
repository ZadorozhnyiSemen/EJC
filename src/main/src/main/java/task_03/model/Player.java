package task_03.model;

/**
 * Simple player for Ducks Casino game
 * have name, balance and playerBet (number of duck in game)
 * nothing special.
 *
 * @author Zadorozhnyi Semen
 * @since GameCasino_v0.0.1
 */
public class Player {
    private String name;
    private int balance = 500;
    private int playerBet;

    public int getPlayerBet() {
        return playerBet;
    }

    public void setPlayerBet(int playerBet) {
        this.playerBet = playerBet;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
