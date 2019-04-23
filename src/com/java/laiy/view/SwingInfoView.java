package com.java.laiy.view;

import javax.swing.*;

public class SwingInfoView extends JDialog {

    private final String info =  "<html>Игра Крестики-нолики <br>" +
            "Вы можете выбрать обычную игру(поле размером 3х3)" +
            "или пользваотельскую(где вы сами можете задать размер моля и имена игроков) <br>" +
            "Ход всегда начинает 'X' или Первый игрок, а следом ходит 'О' или Второй игрок <br>" +
            "<br>" +
            "<br>" +
            "Проект сделан Чикмаревым Ильей, гр. 381505, в рамках курса Java, переподователь: Гаврилов Владимир Сергеевич. 2019г.</html>";


    public SwingInfoView() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel infoLabel = new JLabel(info);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(infoLabel);
    }
}
