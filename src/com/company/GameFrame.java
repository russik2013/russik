package com.company;

import javax.swing.*;



public class GameFrame extends JFrame {
        public GameFrame(){
            setLocationRelativeTo(null);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setSize(400, 400);
            add(new Paint());
            setVisible(true);
        }

    }
