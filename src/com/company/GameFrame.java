package com.company;

import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame {
        public GameFrame(){
            setLocation(150, 150);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setSize(400, 400);
            setBackground(Color.cyan);
            add(new Paint());
            repaint();
            setVisible(true);
        }

    }
