package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Apple {
    static final Image apple;
    int x;
    int y;

    static {
        Image image;
        try {
            image = ImageIO.read(new File("src/Images/apple.png"));
        } catch (IOException e) {
            image = null;
            e.printStackTrace();
        }
        apple = image;
    }

    public Apple (int x, int y){
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g){
        g.drawImage(apple, x, y, null);
    }

    public Rectangle getRect()
    {
        return new Rectangle(x, y, 16, 16);

    }

}
