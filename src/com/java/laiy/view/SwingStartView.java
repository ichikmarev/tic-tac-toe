package com.java.laiy.view;

import com.java.laiy.controller.GameStarter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SwingStartView extends JPanel {

    public SwingStartView() {
        JPanel controlPanel = new JPanel(new FlowLayout());
        JButton playButton = new JButton("Играть");
        playButton.addActionListener(e -> {
            GameStarter.defaultStart().theGame(this);
        });
        controlPanel.add(playButton);

        JButton customButton = new JButton("Создать пользовательскую");
        customButton.addActionListener(e -> {
            customInput();
        });
        controlPanel.add(customButton);
        JButton infoButton = new JButton("Информация");
        infoButton.addActionListener(e -> {
            showInfo();
        });
        controlPanel.add(infoButton);
        BufferedImage titlePicture = null;
        try {
            titlePicture = ImageIO.read(this.getClass().getResource("resources/title.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new BorderLayout());
        add(new JPanel().add(new JLabel(new ImageIcon(titlePicture))), BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    private void customInput() {
        JDialog result = new SwingCustomView((JFrame) SwingUtilities.windowForComponent(this), this);
        result.setPreferredSize(new Dimension(400, 200));
        result.pack();
        result.setResizable(false);
        result.setVisible(true);
    }

    public void startCustomGame(int boardSize, String playerOneName, String playerTwoName, String gameName) {
        GameStarter.customStart(boardSize,playerOneName,playerTwoName, gameName).theGame(this);
    }

    private void showInfo() {
        JDialog result = new SwingInfoView();
        result.setPreferredSize(new Dimension(400, 250));
        result.pack();
        result.setResizable(false);
        result.setVisible(true);
    }
}
