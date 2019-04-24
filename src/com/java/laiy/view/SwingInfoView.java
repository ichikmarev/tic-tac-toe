package com.java.laiy.view;

import javax.swing.*;
import java.awt.*;

public class SwingInfoView extends JDialog {

    private SwingStartView ownerPanel;

    private final String info =  "<html>Игра Крестики-нолики<br>" +
            "Вы можете выбрать обычную игру(поле размером 3х3)" +
            " или пользовательскую(где вы сами можете задать размер поля и имена игроков). <br>" +
            "Ход всегда начинает 'X' или Первый игрок, а следом ходит 'О' или Второй игрок. <br>" +
            "<br>" +
            "<br>" +
            "Проект сделан Чикмаревым Ильей, гр. 381505, в рамках курса Java, преподаватель: Гаврилов Владимир Сергеевич. 2019г.</html>";


    public SwingInfoView() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel infoLabel = new JLabel(info);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(infoLabel);

        JPanel buttons = new JPanel(new FlowLayout());

        JButton backToStart = new JButton("Закрыть");
        backToStart.addActionListener(e -> {
            backToStart();
        });
        buttons.add(backToStart);

        add(buttons, BorderLayout.SOUTH);
    }

    private void backToStart() {
        this.dispose();
    }
}
