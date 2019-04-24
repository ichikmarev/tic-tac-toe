package com.java.laiy.view;

import com.java.laiy.controller.GameController;
import com.java.laiy.model.Board;

import javax.swing.*;
import java.awt.*;

import static com.java.laiy.model.Board.resultHeight;
import static com.java.laiy.model.Board.resultWidth;

public class SwingGameView extends JPanel {

    protected final GameController game;

    public SwingGameView(final GameController game)  {
        assert game != null;
        this.game = game;
        int boardSize = game.getBoard().getSize();
        JPanel gamePanel = new JPanel(new GridLayout(boardSize, boardSize));
        gamePanel.setPreferredSize(new Dimension(Board.startWidth - Board.border, Board.startHeight - Board.border));
        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                JButton buffButton = new JButton("");

                int size = (int)Board.startWidth/(int)(boardSize*1.5);

                buffButton.setFont(new Font("Arial", Font.PLAIN, size));

                int bufI = i;
                int bufJ = j;
                buffButton.addActionListener(e -> { // Перехватчик эвентов
                    buffButton.setText(game.move(bufI, bufJ, game.getCurrentPlayer(game.getPlayers()[0]))); // Нажимаем кнопку
                    // и если игрок может нажать на эту кнопку, выводится знак игрока.
                    if(!game.getNextTurn()) {
                        endGame();
                    }
                });
                gamePanel.add(buffButton);
            }
        }
        add(gamePanel);
    }

    private void endGame() {
        JDialog result = new SwingResultView(game.getWinner(), (JFrame) SwingUtilities.windowForComponent(this), this);
        result.setPreferredSize(new Dimension(resultWidth, resultHeight));
        result.pack();
        result.setResizable(false);
        result.setVisible(true);
    }

    public void backToMain() {
        JFrame mainFrame = (JFrame) SwingUtilities.windowForComponent(this);
        mainFrame.remove(this);
        mainFrame.add(new SwingStartView(), BorderLayout.CENTER);
        mainFrame.validate();
        mainFrame.repaint();
    }
}
