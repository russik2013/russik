package com.company;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Snake {
    private static final Image[] HEAD = new Image[4];
    public static final int DOWN = 0;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int UP = 3;
    public static final int DELAY = 16;
    public static final Point RESTRICTIONS_MAX = new Point(256 - DELAY, 256 - DELAY); // Верхнее ограничение
    public static final Point RESTRICTIONS_MIN = new Point(0, 0); // Нижнее ограничение

    public Point headPoint;
    public Point tailPoint;
    public int length;
    public ArrayList<SnakeBody> body = new ArrayList<>();
    public int headWay;
    public boolean controlWay = true;

    static {
        try {
            HEAD[0] = ImageIO.read(new File("src/com/company/Images/headDown.png"));
            HEAD[1] = ImageIO.read(new File("src/com/company/Images/headLeft.png"));
            HEAD[2] = ImageIO.read(new File("src/com/company/Images/headRight.png"));
            HEAD[3] = ImageIO.read(new File("src/com/company/Images/headUp.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Snake() {
        headWay = 0;
        length = 2;
        headPoint = new Point(2*DELAY, 11*DELAY);
        body.add(new SnakeBody(new Point(2*DELAY, 10*DELAY), headWay));
        body.add(new SnakeBody(new Point(2*DELAY, 9*DELAY), headWay));
        body.add(new SnakeBody(new Point(2*DELAY, 8*DELAY), headWay));
        body.add(new SnakeBody(new Point(2*DELAY, 7*DELAY), headWay));
        body.add(new SnakeBody(new Point(2*DELAY, 6*DELAY), headWay));
        body.add(new SnakeBody(new Point(2*DELAY, 5*DELAY), headWay));
        body.add(new SnakeBody(new Point(2*DELAY, 4*DELAY), headWay));
        body.add(new SnakeBody(new Point(2*DELAY, 3*DELAY), headWay));
        body.add(new SnakeBody(new Point(2*DELAY, 2*DELAY), headWay));
        tailPoint = body.get(body.size()-1).point;
    }

    /** Рисуемся на текущих координатах */
    public void paint(Graphics g) {
        g.drawImage(HEAD[headWay], headPoint.x, headPoint.y, null);
        for (SnakeBody sb: body) sb.paint(g);
        controlWay = true;
    }

    /** Делаем шаг, определяем координаты головы в
     * соответсвии с ограничениями */
    public void move(){
        int x = headPoint.x;
        int y = headPoint.y;
        switch (headWay){
            case DOWN: y += DELAY; break;
            case UP: y -= DELAY; break;
            case RIGHT: x += DELAY; break;
            case LEFT: x -= DELAY; break;
        }
        if (x >= RESTRICTIONS_MIN.x && x <= RESTRICTIONS_MAX.x
                && y >= RESTRICTIONS_MIN.y && y <= RESTRICTIONS_MAX.y) {
            headPoint = new Point(x,y);
            body.forEach(SnakeBody::move);
        }
    }

    /** Изменение направление головы
     * и всех блоков туловища */
    public void turn(int way){
        if (controlWay) {
            controlWay = false;
            if ((way == DOWN && headWay == UP)
                    || (way == UP && headWay == DOWN)
                    || (way == LEFT && headWay == RIGHT)
                    || (way == RIGHT && headWay == LEFT))
                return;
            headWay = way;
            for (SnakeBody sb : body) sb.turn(headPoint, way);
        }
    }

    public Rectangle getRect()
    {
        return new Rectangle(headPoint.x, headPoint.y, 16, 16);

    }

    public void bodyIncrease(){
        SnakeBody sb = body.get(body.size() - 1);
        SnakeBody nsb = new SnakeBody(sb.point, sb.way);
        for (Point point: sb.wayPoint) nsb.wayPoint.add(new Point(point.x, point.y));
        for (Integer integer: sb.wayTurn) nsb.wayTurn.add(integer);
        System.out.println("NEW BLOCK");
        body.add(nsb);
        length = body.size();
    }
    public void  testCollisionWithYouself(){
        int i;
        for (i = 0; i < body.size(); ++i) {
            if( body.get(i).getRect().intersects(getRect())){
//                JOptionPane.showMessageDialog(null,"Себя кушать нельзя");
//                System.exit(0);
                break;
        }
        }
        for(int j = body.size()-1; j>=i;j--) {

            Paint.apples.add(new Apple(body.get(j).x, body.get(j).y));

            body.remove(j);

        }
//        for(int j = i; j<body.size();j+=2) {
//            body.remove(j);
//
//        }
    }

//    private void bodyIncrease(){
//        if (length == 1) {
//            body.add(new SnakeBody())
//        }
//    }

}
