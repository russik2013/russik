package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Paint extends JPanel {
    Timer mainTimer = new Timer(30, null);
    BufferedImage image;
    Snake snake = new Snake();


    public Paint() {
        mainTimer.start();
        addKeyListener(new myKeyAdapter());
        setFocusable(true);
    }


    @Override
    public void paint(Graphics g) {
        image = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.GRAY);
        graphics.fillRect(0,0,256,256);


        snake.paint(graphics);


        g.drawImage(image, 0,0, null);
    }

    public void moveSnake(){
        snake.move();
    }



    private class myKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_W: snake.turn(Snake.UP); break;
                case KeyEvent.VK_A: snake.turn(Snake.LEFT); break;
                case KeyEvent.VK_S: snake.turn(Snake.DOWN); break;
                case KeyEvent.VK_D: snake.turn(Snake.RIGHT); break;
            }
        }
    }

}
