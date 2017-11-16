package com.white;

import java.util.Arrays;

public class GoGameState {

    private enum PositionState {EMPTY, BLACK, WHITE}
    private static final int BOUNDARY_PIXEL = 22;
    private static final int INTERVAL_PIXELS = 42;

    //
    PositionState[][] boardState;

    public GoGameState() {
        this.boardState = new PositionState[19][19];
        for (PositionState[] row: boardState) {
            Arrays.fill(row, PositionState.EMPTY);
        }
    }

    public Shape tryPlacePiece(int x, int y) {
        //System.out.println(x+"  "+y);
        // using mod to get margin of the click from the intersections on the board
        int marginX = (x-BOUNDARY_PIXEL)%INTERVAL_PIXELS;
        int marginY = (y-BOUNDARY_PIXEL)%INTERVAL_PIXELS;
        //System.out.println(marginX+"  "+marginY);
        // test if the margin is small enough
        if (Math.abs(marginX-INTERVAL_PIXELS/2)>=14 && Math.abs(marginY-INTERVAL_PIXELS/2)>=14) {
            // within range
            // round up the x,y values to get the index of cell
            int cellX = (int)Math.round((x-BOUNDARY_PIXEL)/(double)INTERVAL_PIXELS);
            int cellY = (int)Math.round((y-BOUNDARY_PIXEL)/(double)INTERVAL_PIXELS);
            //System.out.println(cellX+"  "+cellY);
            if (boardState[cellY][cellX]==PositionState.EMPTY) {
                System.out.println("new piece");
                boardState[cellY][cellX] = PositionState.BLACK;
                return new Circle(BOUNDARY_PIXEL+(cellX*INTERVAL_PIXELS)-8,BOUNDARY_PIXEL+(cellY*INTERVAL_PIXELS)-8,17,17);
            } else {
                System.out.println("cell occupied");
                return null;
            }

        } else {
            System.out.println("mouse clicked not within range");
            return null;
        }
    }
}
