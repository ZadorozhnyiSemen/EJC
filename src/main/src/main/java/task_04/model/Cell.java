package task_04.model;

/**
 * Simple Cell class represents cell in the game<br>
 * Cell is able to be shot and contain part or full ship inside it
 */
public class Cell {
    // row in a game field
    private int row = -1;
    // column in a game field
    private int column = -1;
    // is cell shot
    private boolean shot = false;
    // does cell contains part of a ship
    private boolean containsShipPart = false;

    public Cell() {
    }

    public Cell(int row, int col) {
        this.row = row;
        this.column = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isShot() {
        return shot;
    }

    public void setShot(boolean shot) {
        this.shot = shot;
    }

    public boolean isContainsShipPart() {
        return containsShipPart;
    }

    public void setContainsShipPart(boolean containsShipPart) {
        this.containsShipPart = containsShipPart;
    }

    /**
     * Reset cell, make it non shot and empty of ships
     */
    public void reset() {
        shot = false;
        containsShipPart = false;
    }
}
