package com.java.laiy.view;

import com.java.laiy.model.Player;

import javax.swing.*;
import java.awt.*;

public class SwingResultView extends JDialog {

    private SwingGameView ownerPanel;

    public SwingResultView(Player winner, JFrame owner, SwingGameView ownerPanel) {
        super(owner);
        this.ownerPanel = ownerPanel;
        setModalityType(ModalityType.TOOLKIT_MODAL);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel result = new JLabel("Ничья");
        result.setFont(new Font("Arial", Font.BOLD, 20));
        result.setHorizontalAlignment(SwingConstants.CENTER);
        result.setVerticalAlignment(SwingConstants.CENTER);
        if(winner != null) {
            result.setText("Победил: " + winner.getName());
        }
        add(result, BorderLayout.CENTER);

        JPanel buttons = new JPanel(new FlowLayout());

        JButton backToStart = new JButton("В главное меню");
        backToStart.addActionListener(e -> {
            backToStart();
        });
        buttons.add(backToStart);

        add(buttons, BorderLayout.SOUTH);
    }

    private void backToStart() {
        ownerPanel.backToMain();
        this.dispose();
    }
}
