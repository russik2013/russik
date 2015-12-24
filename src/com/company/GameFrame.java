package com.company;

import javax.swing.*;



public class GameFrame extends JFrame {
        public GameFrame(){
            setLocation(150, 150);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setSize(400, 400);
            add(new Paint());
            setVisible(true);
        }

    }
