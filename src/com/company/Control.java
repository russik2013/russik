package com.company;

public class Control {
    int speed = 2;
    public void moveUp(){

        Snacke.x = -speed;

    }
    public void moveDown(){

        Snacke.x = speed;

    }
    public void moveLeft(){

        Snacke.y = - speed;

    }
    public void moveRight(){

        Snacke.y = speed;

    }
}
