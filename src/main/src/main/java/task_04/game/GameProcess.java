package task_04.game;

import task_04.model.GameField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameProcess {
    //Maximum player shots
    private static final int MAX_MOVES = 50;
    //Maximum ships on field
    private static final int SHIPS_COUNT = 10;
    //Column letters for field
    private static final String COLUMN_LETTERS = "ABCDEFGHIJ";

    private GameField gameField;
    private int shotAttempts = MAX_MOVES;

    public GameProcess() {
        gameField = new GameField();
    }

    /**
     * Begin game process <br>
     * Welcome player and while he have shots play the game <br>
     * User input is validated by regexp <br>
     * User can quit or restart any time
     */
    public void startGame() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(GAME_READY);
            displayProgress();
            nextPlayerChoice:
            while (shotAttempts > 0) {
                String playerChoice = reader.readLine().toUpperCase();
                switch (playerChoice) {
                    case "R":
                        resetGame();
                        break;
                    case "Q":
                        System.out.println(BYE_WORD);
                        return;
                    default:
                        if (playerChoice.matches("[a-jA-J]([1-9]|10)")) {
                            int col = COLUMN_LETTERS.indexOf(playerChoice.charAt(0));
                            int row = Integer.parseInt(playerChoice.substring(1, playerChoice.length())) - 1;
                            if (col >= 0 && col < GameField.GAME_FIELD_SIZE && row >= 0 && row < GameField.GAME_FIELD_SIZE) {
                                if (gameField.markShot(row, col)) {
                                    --shotAttempts;
                                    if (gameField.getAliveShipsCount() == 0) {
                                        break nextPlayerChoice;
                                    }
                                    displayProgress();
                                    break;
                                }
                            }
                        }
                        System.err.println(INVALID_INPUT);
                        break;
                }
            }
            if (shotAttempts > 0) {
                displayProgress();
                System.out.println(WIN_WORD);
            } else {
                System.out.println(LOSS_WORD);
            }
        } catch (IOException e) {
            System.err.println("Error occurred: " + e);
        }
    }

    /**
     * Reset game:
     * Clear and init new board and ships,
     * set moves back to max,
     * display new board
     */
    private void resetGame() {
        gameField.resetGameField();
        shotAttempts = MAX_MOVES;
        displayProgress();
    }

    /**
     * Show current game process with menu information,
     * field representation and game info
     */
    private void displayProgress() {
        System.out.println(String.format("%s\n%s\n%s\n", RESET_GAME_WORD, EXIT_GAME_WORD, SHOOT_HINT));
        System.out.print(EMPTY_SPACES.charAt(0) + EMPTY_SPACES);
        for (int i = 0, n = COLUMN_LETTERS.length(); i < n; ++i) {
            System.out.print(COLUMN_LETTERS.charAt(i) + EMPTY_SPACES);
        }
        System.out.println();
        gameField.showGameBoard();
        System.out.printf("\n%s\n%s\n%s\n",MINOR_DELIMITER ,INFO, MINOR_DELIMITER);
        System.out.println(String.format("%s%d\n%s%d\n%s%d\n",
                REMAIN_SHIPS,
                gameField.getAliveShipsCount(),
                DESTROYED_SHIPS,
                SHIPS_COUNT - gameField.getAliveShipsCount(),
                REMAIN_SHOOTS,
                shotAttempts
                ));
        System.out.println(DELIMITER);
    }

    // Texts for display
    public static final String EMPTY_SPACES = "  ";
    private static final String GAME_READY = "Ships are arranged. Ready to play!";
    private static final String BYE_WORD = "Bye :(";
    private static final String LOSS_WORD = "Reached try limit! Game over!";
    private static final String WIN_WORD = "You won! Bye!";
    private static final String RESET_GAME_WORD = "Enter 'R' to reset game";
    private static final String EXIT_GAME_WORD = "Enter 'Q' to exit";
    private static final String SHOOT_HINT = "Enter (letter + number) combination to shoot in cell on board \n" +
            "Example A1, f5, j10";
    private static final String INFO = "INFO:\n(.) - empty cell\n(o) - missed cell\n(X) - hit cell";
    private static final String REMAIN_SHOOTS = "Remaining shots: ";
    private static final String REMAIN_SHIPS = "Remaining ships: ";
    private static final String DESTROYED_SHIPS = "Already destroyed: ";
    private static final String MINOR_DELIMITER = "--------------------";
    private static final String DELIMITER = "==================================================";
    private static final String INVALID_INPUT = "Please enter valid cell.";
}
