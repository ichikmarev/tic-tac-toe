package com.java.laiy.view;

import com.java.laiy.model.Player;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class SwingCustomView extends JDialog {

    private SwingStartView swingStartView;
    private JTextField playerOneName;
    private JTextField playerTwoName;
    private JSlider slider;

    public SwingCustomView(JFrame owner, SwingStartView ownerPanel) {
        super(owner);
        this.swingStartView = ownerPanel;
        setModalityType(Dialog.ModalityType.TOOLKIT_MODAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        playerOneName = new JTextField("Игрок1", 15);
        playerOneName.setSize(new Dimension(300,30));
        playerTwoName = new JTextField("Игрок2", 15);
        playerTwoName.setSize(new Dimension(300,30));
        slider = new JSlider(JSlider.HORIZONTAL, 3, 15, 7);
        JLabel chooseSize = new JLabel("Размер поля");
        slider.setMajorTickSpacing(1);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        JPanel panel = new JPanel();
        panel.add(chooseSize);
        panel.add(slider);
        JButton startCustomGame = new JButton("Начать пользовательскую игру");
        startCustomGame.addActionListener(e -> {
            startCustomGame();
        });

        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(playerOneName);
        mainPanel.add(playerTwoName);
        mainPanel.add(panel);
        mainPanel.add(startCustomGame);
        add(mainPanel, BorderLayout.CENTER);
    }

    private void startCustomGame() {
        this.dispose();
        this.swingStartView.startCustomGame(this.slider.getValue(),
                                            this.playerOneName.getText(),
                                            this.playerTwoName.getText(),
                                            "Пользовательская игра");
    }
}