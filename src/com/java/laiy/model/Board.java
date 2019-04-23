package com.java.laiy.model;


public class Board {

    private static final int MIN_COORDINATE = 0;

    private static final int DEFAULT_BOARD_SIZE = 3;

    private final Figure[][] figures;

    private final int size;

    public static final int startWidth = 500;
    public static final int startHeight = 500;
    public static final int border = 50;

    public static final int resultWidth = 500;
    public static final int resultHeight = 100;

    public Board() {
        this(DEFAULT_BOARD_SIZE);
    }

    public Board(final int customBoardSize) {
        size = customBoardSize;
        if (customBoardSize < DEFAULT_BOARD_SIZE) {
            this.figures = new Figure[DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
        }
         else {
            this.figures = new Figure[customBoardSize][customBoardSize];
        }
    }

    public int getSize() {
        return size;
    }

    public boolean setFigure(final int x, final int y, final Figure figure){
        if (figures[x][y] == null && checkCoordinates(x, y)) {
            figures[x][y] = figure;
            return true;
        }
        return false;
    }

    public Figure getFigure(final int x, final int y) {
        if (checkCoordinates(x, y)) {
            return figures[x][y];
        }
        return null;
    }

    public Figure[][] getFiguresArray() {
            return figures;
    }

    public int getRowLength(final int row) {
        return figures[row].length;
    }

    private boolean checkCoordinates(final int x, final int y){
        return (checkCoordinate(x) && checkCoordinate(y));
    }

    public boolean checkCoordinate(final int coordinate) {
        return (coordinate >= MIN_COORDINATE && coordinate <= figures.length - 1);
    }

}