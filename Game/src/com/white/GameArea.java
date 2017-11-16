package com.white;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GameArea extends JPanel {

    private ArrayList<Shape> fixedShapes;
    private ArrayList<Shape> gameShapes;
    GoGameState goGameState;
    //
    private static final int INTERVAL_PIXELS = 42;

    public GameArea() {
        fixedShapes = new ArrayList<>(100);
        gameShapes = new ArrayList<>(400);
        goGameState = new GoGameState();
        setFixedShapes();
        setBackground(Color.decode("#e0af3e"));
        MyMouseListener ml = new MyMouseListener();
        addMouseListener(ml);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Shape s: fixedShapes) {
            s.draw(g);
        }

    }

    private void setFixedShapes() {
        int x0 = 22;
        int y0 = 22;
        int xEnd = 778;
        int yEnd = 778;
        for (int i=0; i<19; i++) {
            fixedShapes.add(new Line(x0+(i*INTERVAL_PIXELS),y0,x0+(i*INTERVAL_PIXELS),yEnd));  //vertical lines
            fixedShapes.add(new Line(x0,(i*INTERVAL_PIXELS)+y0,xEnd,(i*INTERVAL_PIXELS)+y0));  //horizontal lines
        }
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                fixedShapes.add(new Circle((x0+3*INTERVAL_PIXELS)+(j*6*INTERVAL_PIXELS)-2,(y0+3*INTERVAL_PIXELS)+(i*6*INTERVAL_PIXELS)-2,4,4));
            }
        }
    }

    class MyMouseListener implements MouseListener {

        private int x,y;

        @Override
        public void mouseClicked(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            Graphics g = getGraphics();
            Shape temp = null;
            temp = goGameState.tryPlacePiece(x,y);
            if (temp!=null) {
                gameShapes.add(temp);
            }
            for (Shape ss: gameShapes) {
                ss.draw(g);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
