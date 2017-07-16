package task_04.model;

import task_04.game.GameProcess;

import java.util.ArrayList;
import java.util.List;

/**
 * Class GameField represents field of the Battle Ship game<br>
 * Game field contains 2-dimension array of Cells<br>
 * Game field contain list of ships and available cells
 */
public class GameField {
    public static final int GAME_FIELD_SIZE = 10;
    private static final int SHIPS_TYPES = 4;
    private static final char NOT_TOUCHED_CELL = '.';
    private static final char MISSED_CELL = 'o';
    private static final char SHOOTED_WITH_SHIP_CELL = 'X';
    private Cell[][] cells;
    private List<Cell> availableCellList;
    private List<Ship> shipList;

    public GameField() {
        this.shipList = new ArrayList<>();
        this.cells = new Cell[GAME_FIELD_SIZE][GAME_FIELD_SIZE];
        this.availableCellList = new ArrayList<>(GAME_FIELD_SIZE * GAME_FIELD_SIZE);
        initFieldAndShips();
    }

    /**
     * Initialize field and mark all cells as available<br>
     * Place ships randomly
     */
    private void initFieldAndShips() {
        for (int i = 0; i < cells.length; ++i) {
            for (int j = 0; j < cells[i].length; ++j) {
                if (cells[i][j] == null) {
                    cells[i][j] = new Cell(i, j);
                } else {
                    cells[i][j].reset();
                }
                availableCellList.add(cells[i][j]);
            }
        }
        int size = Ship.MAX_SHIP_SIZE;
        for (int count = 0; count < SHIPS_TYPES; ++count, --size) {
            for (int i = 0; i <= count; ++i) {
                placeShipOnField(new Ship(size));
            }
        }
    }

    /**
     * Places ship on field<br>
     * Randomly chooses vertical or horizontal direction of the ship
     *
     * @param ship Ship to place on field
     */
    private void placeShipOnField(Ship ship) {
        int shipSize = ship.getShipSize();
        Cell cell = availableCellList.get((int) (Math.random() * availableCellList.size()));
        if (shipSize > 1) {
            List<List<Cell>> positionList = new ArrayList<>(shipSize * 2);
            List<Cell> currentPositionList;
            nextDirectionHorizontal:
            for (int i = 0; i < shipSize; ++i) {
                currentPositionList = new ArrayList<>(shipSize);
                for (int j = 0; j < shipSize; ++j) {
                    if (cell.getRow() - i + j < cells.length && cell.getRow() - i + j >= 0
                            && availableCellList.contains(cells[cell.getRow() - i + j][cell.getColumn()])) {
                        currentPositionList.add(cells[cell.getRow() - i + j][cell.getColumn()]);
                    } else {
                        continue nextDirectionHorizontal;
                    }
                }
                positionList.add(currentPositionList);
            }
            nextDirectionVertical:
            for (int i = 0; i < shipSize; ++i) {
                currentPositionList = new ArrayList<>(shipSize);
                for (int j = 0; j < shipSize; ++j) {
                    if (cell.getColumn() - i + j < cells[0].length && cell.getColumn() - i + j >= 0
                            && availableCellList.contains(cells[cell.getRow()][cell.getColumn() - i + j])) {
                        currentPositionList.add(cells[cell.getRow()][cell.getColumn() - i + j]);
                    } else {
                        continue nextDirectionVertical;
                    }
                }
                positionList.add(currentPositionList);
            }
            currentPositionList = positionList.get((int) (Math.random() * positionList.size()));
            currentPositionList.forEach(cell1 -> {
                cell1.setContainsShipPart(true);
                ship.getCellList().add(cell1);
            });
        } else if (shipSize == 1) {
            cell.setContainsShipPart(true);
            ship.getCellList().add(cell);
        }
        availableCellList.removeAll(ship.getCellList());
        setShipShotBorder(ship);
        shipList.add(ship);
    }

    /**
     * Sets shoot border for ship
     * and ignores bounds of the field
     *
     * @param ship Ship to set border
     */
    private void setShipShotBorder(Ship ship) {
        boolean isExistMinRow = ship.getMinShipRow() > 0;
        boolean isExistMaxRow = ship.getMaxShipRow() + 1 != cells.length;
        boolean isExistMinCol = ship.getMinShipCol() > 0;
        boolean isExistMaxCol = ship.getMaxShipCol() + 1 != cells[0].length;
        int minBorderRow = isExistMinRow ? ship.getMinShipRow() - 1 : ship.getMinShipRow();
        int maxBorderRow = isExistMaxRow ? ship.getMaxShipRow() + 1 : ship.getMaxShipRow();
        int minBorderCol = isExistMinCol ? ship.getMinShipCol() - 1 : ship.getMinShipCol();
        int maxBorderCol = isExistMaxCol ? ship.getMaxShipCol() + 1 : ship.getMaxShipCol();
        int verticalStartPos = isExistMinRow ? 1 : 0;
        int verticalLength = isExistMaxRow ? maxBorderRow - minBorderRow : maxBorderRow - minBorderRow + 1;
        int horLength = maxBorderCol - minBorderCol + 1;

        for (int i = 0; i < horLength; ++i) {
            if (isExistMinRow) {
                ship.getShipShotBorder().add(cells[minBorderRow][minBorderCol + i]);
            }
            if (isExistMaxRow) {
                ship.getShipShotBorder().add(cells[maxBorderRow][minBorderCol + i]);
            }
        }
        for (int i = verticalStartPos; i < verticalLength; ++i) {
            if (isExistMinCol) {
                ship.getShipShotBorder().add(cells[minBorderRow + i][minBorderCol]);
            }
            if (isExistMaxCol) {
                ship.getShipShotBorder().add(cells[minBorderRow + i][maxBorderCol]);
            }
        }
        availableCellList.removeAll(ship.getShipShotBorder());
    }

    public Cell[][] getCells() {
        return cells;
    }

    public List<Ship> getShipList() {
        return shipList;
    }

    /**
     * Reset field of the game
     */
    public void resetGameField() {
        availableCellList.clear();
        shipList.clear();
        initFieldAndShips();
    }

    /**
     * Mark that cell was shot
     * @param row row of the cell
     * @param col col of the cell
     * @return <code>false</code> if cell is already shot <code>true</code> if cell was marked as shot
     */
    public boolean markShot(int row, int col) {
        if (cells[row][col].isShot()) {
            return false;
        }
        cells[row][col].setShot(true);
        if (cells[row][col].isContainsShipPart()) {
            Ship currentShip = null;
            for (Ship ship : shipList) {
                if (ship.getCellList().contains(cells[row][col])) {
                    currentShip = ship;
                }
            }
            if (currentShip != null && !currentShip.isAlive()) {
                for (Cell shadowCell : currentShip.getShipShotBorder()) {
                    shadowCell.setShot(true);
                }
                shipList.remove(currentShip);
            }
        }
        return true;
    }

    /**
     * Count value of alive ships
     * @return Value of alive ships
     */
    public int getAliveShipsCount() {
        return shipList.size();
    }

    /**
     *  Draw game board on the user screen (console)
     */
    public void showGameBoard() {
        for (int i = 0; i < GAME_FIELD_SIZE; ++i) {
            int rowNum = i + 1;
            if (rowNum != GAME_FIELD_SIZE) {
                System.out.print(rowNum + GameProcess.EMPTY_SPACES);
            } else {
                System.out.print(rowNum + GameProcess.EMPTY_SPACES.substring(0, 1));
            }
            for (int j = 0; j < GAME_FIELD_SIZE; ++j) {
                if (cells[i][j].isShot()) {
                    if (cells[i][j].isContainsShipPart()) {
                        System.out.print(SHOOTED_WITH_SHIP_CELL + GameProcess.EMPTY_SPACES);
                    } else {
                        System.out.print(MISSED_CELL + GameProcess.EMPTY_SPACES);
                    }
                } else {
                    System.out.print(NOT_TOUCHED_CELL + GameProcess.EMPTY_SPACES);
                }
            }
            System.out.println();
        }
    }
}
