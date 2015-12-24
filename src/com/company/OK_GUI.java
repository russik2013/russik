package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by basill on 24.12.15.
 */
public class OK_GUI extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton OKButton1;
    private JButton OKButton3;
    private JButton OKButton2;
    private JLabel label;
    private int count = 0;

    OK_GUI() {
        setSize(new Dimension(400, 200));
        setTitle("OK Warning!!!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);

        OKButton1.addActionListener(this);
        OKButton2.addActionListener(this);
        OKButton3.addActionListener(this);

        setVisible(true);
    }

    private void clickToButton(int i) {
        switch (i) {
            case 1:
                label.setText("A?");
                break;
            case 2:
                label.setText("and what you want for me? a?");
                break;
            case 3:
                label.setText("oh... fuck you. I am go out");
                break;
            case 4:
                System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clickToButton(++count);
    }
}
