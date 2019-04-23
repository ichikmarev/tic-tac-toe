
package com.java.laiy;

import com.java.laiy.model.Board;
import com.java.laiy.view.*;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(final String[] args) {
        JFrame frame = new JFrame(); // создаем окно
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // устанавливаем стандартный тип закрытия
        frame.setSize(Board.startWidth, Board.startHeight); // задаем размеры окна
        frame.setTitle("XO"); // задаем название окна
        frame.add(new SwingStartView(), BorderLayout.CENTER); // ставим стартовую панель в центр
        frame.setResizable(false); // отключаем возможность изменения окна
        frame.setLocationRelativeTo(null); // чтобы окно было по центру
        frame.setVisible(true); // делаем окно видимым
    }
}