
package com.java.laiy;

import com.java.laiy.model.Board;
import com.java.laiy.view.*;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(final String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Board.startWidth, Board.startHeight);
        frame.setTitle("Крестики-нолики");
        frame.add(new SwingStartView(), BorderLayout.CENTER);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}