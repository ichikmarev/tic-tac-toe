package com.java.laiy.controller;

import com.java.laiy.view.SwingGameView;

import javax.swing.*;

public class Game {

    final private SwingGameView view;

    public Game(SwingGameView view) {
        this.view = view;
    }

    public void theGame(JPanel startPanel) {
            JFrame mainFrame = (JFrame) SwingUtilities.windowForComponent(startPanel); // получаем по этой панели ее фрейм
            mainFrame.remove(startPanel);
            mainFrame.add(view);
            mainFrame.validate();
    }
}
