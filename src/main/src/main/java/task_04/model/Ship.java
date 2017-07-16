package task_04.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple Ship class for BattleShip game<br>
 * Ship contains array of cells and array of shot border
 * (space where you can't place another ship)<br>
 * Ship can have default maximum size
 */
public class Ship {
    static final int MAX_SHIP_SIZE = 4;
    // List of Ship's cells
    private List<Cell> cellList;
    // List of Ship's shot border cells
    private List<Cell> shipShotBorder;
    // size of the ship
    private int shipSize;

    public Ship() {
        this.cellList = new ArrayList<>(MAX_SHIP_SIZE);
        this.shipShotBorder = new ArrayList<>(MAX_SHIP_SIZE * 2 + 6);
    }

    public Ship(int shipSize) {
        this();
        this.shipSize = shipSize;
    }

    public int getShipSize() {
        return shipSize;
    }

    public List<Cell> getCellList() {
        return cellList;
    }

    public List<Cell> getShipShotBorder() {
        return shipShotBorder;
    }

    /**
     * Check if at least 1 cell of ship is not shot
     * @return <code>true</code> if at least 1 cell alive and
     * <code>false</code> if all cells of the ship dead
     */
    public boolean isAlive() {
        for (Cell cell : cellList) {
            if (!cell.isShot()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get maximal row of the ship
     * @return max ship row
     */
    public int getMaxShipRow() {
        int maxShipRow = -1;
        for (Cell cell : cellList) {
            if (maxShipRow < cell.getRow()) {
                maxShipRow = cell.getRow();
            }
        }
        return maxShipRow;
    }

    /**
     * Get minimal row of the ship
     * @return min ship row
     */
    public int getMinShipRow() {
        int minShipRow = 100;
        for (Cell cell : cellList) {
            if (minShipRow > cell.getRow()) {
                minShipRow = cell.getRow();
            }
        }
        return minShipRow;
    }

    /**
     * Get maximal column of the ship
     * @return max ship column
     */
    public int getMaxShipCol() {
        int maxShipCol = -1;
        for (Cell cell : cellList) {
            if (maxShipCol < cell.getColumn()) {
                maxShipCol = cell.getColumn();
            }
        }
        return maxShipCol;
    }

    /**
     * Get minimal column of the ship
     * @return min ship column
     */
    public int getMinShipCol() {
        int minShipCol = 100;
        for (Cell cell : cellList) {
            if (minShipCol > cell.getColumn()) {
                minShipCol = cell.getColumn();
            }
        }
        return minShipCol;
    }
}
