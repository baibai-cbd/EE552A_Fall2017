package com.white;

import javax.swing.*;
import java.awt.*;

public class GameApp extends JFrame {
    private GameArea gameArea;

    public GameApp() {
        Container container =getContentPane();
        gameArea = new GameArea();
        container.add(gameArea, BorderLayout.CENTER);
        setSize(800,800);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
