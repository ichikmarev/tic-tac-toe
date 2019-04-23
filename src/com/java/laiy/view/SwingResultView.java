package com.java.laiy.view;

import com.java.laiy.model.Player;

import javax.swing.*;
import java.awt.*;

public class SwingResultView extends JDialog {

    private SwingGameView ownerPanel; // панель от котороый зависим

    public SwingResultView(Player winner, JFrame owner, SwingGameView ownerPanel) { // передаем игрока победителя или Null. так же основное окно и основную панель
        super(owner); // сделано для того чтобы заблочить окно до тех пор пока не будет решено что-то в окне
        this.ownerPanel = ownerPanel; // запоминаем панель
        setModalityType(ModalityType.TOOLKIT_MODAL);  // сделано для того чтобы заблочить окно до тех пор пока не будет решено что-то в окне
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // отключаем возможность закрыть окно, пусть жмут на кнопку.
        setLocationRelativeTo(null); // спавн модального окна по центру
        // создаем лейбл, меняем шрифт и ставим его по центру. по умолчанию выводится ничья
        JLabel result = new JLabel("Draw");
        result.setFont(new Font("Arial", Font.BOLD, 20));
        result.setHorizontalAlignment(SwingConstants.CENTER);
        result.setVerticalAlignment(SwingConstants.CENTER);
        if(winner != null) { // если есть победитель то выводим победителя
            result.setText("Here is our winner: " + winner.getName());
        }
        add(result, BorderLayout.CENTER); // добавляем лейбл на панель

        JPanel buttons = new JPanel(new FlowLayout()); // создаем панель для кнопок

        JButton backToStart = new JButton("Back to start"); // создаем кнопку и вешаем на нее перехватчик событий
        backToStart.addActionListener(e -> {
            backToStart(); // вовзрат к startpanel
        });
        buttons.add(backToStart); // добавляем кнопку на панель

        add(buttons, BorderLayout.SOUTH); // выводим кнопку на основную панель
    }

    private void backToStart() {
        ownerPanel.backToMain(); //вызываем метод у панели
        this.dispose(); // закрываем окно
    }
}
