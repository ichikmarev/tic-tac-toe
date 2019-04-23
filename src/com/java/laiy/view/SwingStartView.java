package com.java.laiy.view;

import com.java.laiy.controller.GameStarter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SwingStartView extends JPanel {

    public SwingStartView() {
        JPanel controlPanel = new JPanel(new FlowLayout()); // создаем панель для кнопок
        JButton playButton = new JButton("Play default"); // создаем кнопку
        playButton.addActionListener(e -> { // вешаем перехватчик событий на кнопку
            GameStarter.defaultStart().theGame(this); // запуск дефолтной игры
        });
        controlPanel.add(playButton); // добавляем кнопку на панель

        JButton customButton = new JButton("Set custom"); // создаем кнопку для кастомной игры и затем вешаем перехватчик собыитй
        customButton.addActionListener(e -> {
            customInput(); // вызываем метод отвечающий за диалоговое окно
        });
        controlPanel.add(customButton); // добавляем кнопку на панель
        JButton infoButton = new JButton("Info");
        infoButton.addActionListener(e -> {
            showInfo();
        });
        controlPanel.add(infoButton);
        BufferedImage titlePicture = null; // подгружаем картинку
        try {
            titlePicture = ImageIO.read(this.getClass().getResource("resources/title.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new BorderLayout()); // задаем этой панели BorderLayout
        add(new JPanel().add(new JLabel(new ImageIcon(titlePicture))), BorderLayout.CENTER); // добавляем лейбл в который вставляем картинку на панель в центр
        add(controlPanel, BorderLayout.SOUTH); //  добавляем на основную панель кнопки
    }

    private void customInput() {
        JDialog result = new SwingCustomView((JFrame) SwingUtilities.windowForComponent(this), this); // получаем доступ к основному экрану
        result.setPreferredSize(new Dimension(400, 200)); //задаем размеры модального окна
        result.pack(); // задаем элементу нужный размер
        result.setResizable(false); // отключаем возможность менять размер окна
        result.setVisible(true); // поазываем диалоговое окно
    }

    public void startCustomGame(int boardSize, String playerOneName, String playerTwoName, String gameName) {
        GameStarter.customStart(boardSize,playerOneName,playerTwoName, gameName).theGame(this); // метод вызываемый из диалогового окна, запускает кастомную игру со статами
    }

    private void showInfo() {
        JDialog result = new SwingInfoView(); // получаем доступ к основному экрану
        result.setPreferredSize(new Dimension(400, 150)); //задаем размеры модального окна
        result.pack(); // задаем элементу нужный размер
        result.setResizable(false); // отключаем возможность менять размер окна
        result.setVisible(true); // поазываем диалоговое окно
    }
}
