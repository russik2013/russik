package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Paint extends JPanel implements ActionListener, Runnable{
    Timer mainTimer = new Timer(30,this);
    public Paint(){

        mainTimer.start();


        addKeyListener(new myKeyAdapter());

        setFocusable(true);
    }



    @Override
    public void paint (Graphics g){
       g.fillRect(10 + Snacke.y, 10 + Snacke.x, 50, 50);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void run() {

    }

    private class myKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
            Control control = new Control();
            if(key == KeyEvent.VK_D) {
                control.moveRight();
            }
            if(key == KeyEvent.VK_A) {
                control.moveLeft();

            }
            if(key == KeyEvent.VK_W) {
                control.moveUp();

            }
            if(key == KeyEvent.VK_S) {
                control.moveDown();

            }
        }
        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();
            Control control = new Control();
            if(key == KeyEvent.VK_D) {
                control.moveRight();
            }
            if(key == KeyEvent.VK_A) {
                control.moveLeft();

            }
            if(key == KeyEvent.VK_W) {
                control.moveUp();

            }
            if(key == KeyEvent.VK_S) {
                control.moveDown();

            }
        }
    }

}
