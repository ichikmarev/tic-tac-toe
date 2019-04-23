package com.java.laiy.view;

import javax.swing.*;

public class SwingInfoView extends JDialog {

    private final String info =  "Lorem ipsum";

    public SwingInfoView() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel infoLabel = new JLabel(info);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(infoLabel);
    }
}
