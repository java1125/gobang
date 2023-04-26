package gobang;

import java.awt.*;

/**
 * TODO
 * 棋子类
 * @author edda
 * @date 2023/04/24 15:36
 **/
public class Point {
    /**
     * 棋盘中的x索引
     */
    private int x;
    /**
     * 棋盘中的y索引
     */
    private int y;
    /**
     * 颜色
     */
    private Color color;
    /**
     * 直径
     */
    public static final int DIAMETER = 30;

    public Point(int x,int y,Color color){
        this.x=x;
        this.y = y;
        this.color=color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }
}
