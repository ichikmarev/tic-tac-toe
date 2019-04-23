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
        // получаем размер доски
        int boardSize = game.getBoard().getSize();
        // создаем панель с сеточным лайоутом по количеству объектов
        JPanel gamePanel = new JPanel(new GridLayout(boardSize, boardSize));
        // задаем размер меньше окна
        gamePanel.setPreferredSize(new Dimension(Board.startWidth - Board.border, Board.startHeight - Board.border));
        // создаем кнопки
        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                JButton buffButton = new JButton(""); // создаем кнопку с тустой подписью
                int bufI = i; // запоминаем координаты, чтобы бала возможность передавать в лямбда функцию, которая перехватывает события
                int bufJ = j;
                buffButton.addActionListener(e -> { // собственно перехватчик эвентов
                    buffButton.setText(game.move(bufI, bufJ, game.getCurrentPlayer(game.getPlayers()[0]))); // нажимаем кнопку
                    // и если игрок может нажать на эту кнопку, выводится знак игрока.
                    if(!game.getNextTurn()) { // проверяем можем ли играть дальше
                        endGame(); // метод обрабатывающий окончания игры
                    }
                });
                gamePanel.add(buffButton);// добавляем кнопку на панель
            }
        }
        add(gamePanel); // добавляем панель
    }

    private void endGame() { // конец игры. выводим диалоговое окно. задаем его размер, блочим изменения размера и выводим.
        JDialog result = new SwingResultView(game.getWinner(), (JFrame) SwingUtilities.windowForComponent(this), this);
        result.setPreferredSize(new Dimension(resultWidth, resultHeight));
        result.pack();
        result.setResizable(false);
        result.setVisible(true);
    }

    public void backToMain() { // метод вызываемый из диалогового окна
        JFrame mainFrame = (JFrame) SwingUtilities.windowForComponent(this); // получаем по этой панели ее фрейм
        mainFrame.remove(this); // удаляем эту панель
        mainFrame.add(new SwingStartView(), BorderLayout.CENTER); // отрисовываем панель в центре новую
        mainFrame.validate(); // методы необходимые для корректной замены панелей
        mainFrame.repaint();
    }
}
