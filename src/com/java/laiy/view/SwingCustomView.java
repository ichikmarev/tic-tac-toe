package com.java.laiy.view;

import com.java.laiy.model.Player;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class SwingCustomView extends JDialog {

    private SwingStartView swingStartView;
    // поля из которых получаются значения для кастомной игры
    private JTextField playerOneName;
    private JTextField playerTwoName;
    private JSlider slider;

    // получаем jframe и панель родителя
    public SwingCustomView(JFrame owner, SwingStartView ownerPanel) {
        super(owner); // блочим от нажатий нижнее окно
        this.swingStartView = ownerPanel; // запоминаем панель родителя
        setModalityType(Dialog.ModalityType.TOOLKIT_MODAL); // блочим от нажатий нижнее окно
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // при клике на крест, окно закрывается
        setLocationRelativeTo(null); // спавн по центру
        // поля для новых имен игроков. Имеют Изначальные значения
        playerOneName = new JTextField("PlayerOne name", 15);
        playerOneName.setSize(new Dimension(300,30));
        playerTwoName = new JTextField("PlayerTwo name", 15);
        playerTwoName.setSize(new Dimension(300,30));
        // создаем слайдер для выбора размера доски
        slider = new JSlider(JSlider.HORIZONTAL, 3, 15, 7);
        JLabel chooseSize = new JLabel("Board size");
        slider.setMajorTickSpacing(1); // опрделяем минимальный и максимальный шаг
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        JPanel panel = new JPanel();
        panel.add(chooseSize); // создаем панель и добавляем слайдер
        panel.add(slider);
        // создаем кнопку и вешаем обработчик событий
        JButton startCustomGame = new JButton("Start custom game");
        startCustomGame.addActionListener(e -> {
            startCustomGame();
        });
        // создаем основную панель и добавляем туда все элементы
        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(playerOneName);
        mainPanel.add(playerTwoName);
        mainPanel.add(panel);
        mainPanel.add(startCustomGame);
        // добавляем на основную панель
        add(mainPanel, BorderLayout.CENTER);
    }

    private void startCustomGame() { // удаляем модальное окно и вызываем метод инициализирующий кастомную игру.
        this.dispose();
        this.swingStartView.startCustomGame(this.slider.getValue(),
                                            this.playerOneName.getText(),
                                            this.playerTwoName.getText(),
                                            "Custom game");
    }
}