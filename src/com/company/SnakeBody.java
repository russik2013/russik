package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class SnakeBody {
    private static final Image body;

    public int way;
    public Point point;
    public Queue<Integer> wayTurn = new LinkedList<>(); //Очередь изменений напрвлений блока
    public Queue<Point> wayPoint = new LinkedList<>(); //Очередь точек поворота

    static {
        Image image;
        try {
            image = ImageIO.read(new File("src/Images/body.png"));
        } catch (IOException e) {
            image = null;
            e.printStackTrace();
        }
        body = image;
    }

    public SnakeBody(Point point, int way){
        this.point = point;
        this.way = way;
    }

    /** Добавляем новую точку поворота в очередь */
    public void turn(Point point, int way){
        wayPoint.add(point);
        wayTurn.add(way);
    }

    /** Делаем шаг, если дошли до точки поворота - поворачиваем
     * и убераем точку из очереди */
    int x;
    int y;
    public void move(){
        x = point.x;
        y = point.y;
        switch (way){
            case Snake.DOWN: y += Snake.DELAY; break;
            case Snake.UP: y -= Snake.DELAY; break;
            case Snake.RIGHT: x += Snake.DELAY; break;
            case Snake.LEFT: x -= Snake.DELAY; break;
        }
        point = new Point(x,y);
        if (!wayPoint.isEmpty())
        if (point.equals(wayPoint.element())) {
            wayPoint.remove();
            way = wayTurn.remove();
        }
    }

    public Rectangle getRect()
    {
        return new Rectangle(x, y, 16, 16);

    }

    /** Рисуемся на текущих координатах */
    public void paint(Graphics g){
        g.drawImage(body, point.x, point.y, null);
    }
}
