package com.company;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Snake {

    int x = 0;
    int y = 0;
    Image[] head = new Image[4];
    Image body;
    int length = 0;

    public Snake(){
        try {
            head[0] = ImageIO.read(new File("Images/headDown"));
            head[1] = ImageIO.read(new File("Images/headLeft"));
            head[2] = ImageIO.read(new File("Images/headRight"));
            head[3] = ImageIO.read(new File("Images/headUp"));
            body = ImageIO.read(new File("Images/body"));
            length = 3;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
