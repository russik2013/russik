package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Paint extends JPanel {
    Timer mainTimer = new Timer(30, null);
    BufferedImage image;
    Snake snake = new Snake();
    Apple apple;
    Random random = new Random();
    boolean isApple = false;
    public static ArrayList<Apple> apples = new ArrayList<>();
    int snakeBodyStep = 8;

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

        if(!isApple){
            int x = random.nextInt(16);
            int y = random.nextInt(16);
            apple = new Apple(x*16, y*16);
            isApple = true;
        }
        apple.paint(graphics);
        for(Apple a:apples){
            a.paint(graphics);
        }

        g.drawImage(image, 0,0, null);


    }

    public void moveSnake(){
        snake.move();
        testCollisionWithApple();
        snake.testCollisionWithYouself();
    }

    private void testCollisionWithApple(){
            if(apple.getRect().intersects(snake.getRect())) {
               isApple = false;
               snake.bodyIncrease();
            }
        for(int i = 0; i< apples.size(); i++) {
            if (apples.get(i).getRect().intersects(snake.getRect())){
                apples.remove(i);
            }
        }
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
