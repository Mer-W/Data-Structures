/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package day09snowflake;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;

/**
 *
 * @author mer
 */
public class Day09Snowflake extends JFrame {

    public static void main(String[] args) {

        Day09Snowflake mainWindowForDrawing = new Day09Snowflake();
    }

    public Day09Snowflake() {
        setLayout(new BorderLayout());
        setSize(700, 750);
        // setBackground(Color.WHITE);
        setTitle("snowflake");
        DrawingArea drawingArea = new DrawingArea();
        add("Center", drawingArea);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class DrawingArea extends Canvas {

        @Override
        public void paint(Graphics g) {
            int ax = getWidth() / 11;
            //int ax = 5;
            int ay = getHeight() / 4;
            int bx = getWidth() - getWidth() / 11;
            //int bx = 772;
            int by = getHeight() / 4;
            Polygon p = new Polygon();
            drawSnowflake(g, ax, ay, bx, by, 0);
//            g.setColor(Color.white);
//            g.fillPolygon(p);
        }

    }

    private void drawSnowflake(Graphics g, int ax, int ay, int bx, int by, int type) {

        if (bx > ax && bx - ax < 8 || ax > bx && ax - bx < 8) {
            return;
        }

        int width = bx - ax;

        switch (type) {
            case 0 -> {
                /* if (!isPow(width/3)) {
                    
                    int newWidth = resize(width/3);
                    
                    width = 3 * (width/3);
                    newWidth *= 3;
                    
                    while (width != newWidth) {
                        ax++;
                        bx--;
                        
                        width = bx - ax;
                    }
                }
                 */
                // draw first iteration
                int cx = (bx + ax) / 2;
                double cy = ay + (bx - ax) * (Math.sqrt(3) / 2);
                g.setColor(Color.blue);
                g.drawLine(ax, ay, bx, by);
                g.drawLine(bx, by, cx, (int) cy);
                g.drawLine(cx, (int) cy, ax, ay);

                Polygon p = new Polygon();
                p.addPoint(ax, ay);
                p.addPoint(cx, (int) cy);
                p.addPoint(bx, by);
                g.setColor(Color.white);
                  g.fillPolygon(p);
                  
                drawSnowflake(g, ax, ay, bx, by, 1);
                                drawSnowflake(g, bx, by, cx, (int) cy, 5);
                drawSnowflake(g, cx, (int) cy, ax, (int) ay, 6);

            }
            case 1 -> {
                // calc midpoints
                int dx = ax + width / 3;
                int dy = ay;

                int fx = bx - width / 3;
                int fy = ay;

                int ex = (dx + fx) / 2;
                double ey = ay - (fx - dx) * (Math.sqrt(3) / 2);
                g.setColor(Color.blue);

                g.drawLine(dx, dy, ex, (int) ey);
                g.drawLine(ex, (int) ey, fx, fy);
                g.setColor(Color.white);
                g.drawLine(dx, dy, fx, fy);

                Polygon p = new Polygon();
                p.addPoint(dx, dy);
                p.addPoint(ex, (int) ey);
                p.addPoint(fx, fy);

                g.setColor(Color.white);
                 g.fillPolygon(p);

                drawSnowflake(g, ax, ay, dx, dy, 1);
                drawSnowflake(g, fx, fy, bx, by, 1);

                drawSnowflake(g, dx, dy, ex, (int) ey, 2);
                drawSnowflake(g, ex, (int) ey, fx, (int) fy, 3);              
            }
            case 2 -> {
                // calc midpoints
                int dx = ax + (bx - ax) / 3;
                int dy = ay - (ay - by) / 3;

                int fx = ax + (bx - ax) * 2 / 3;
                int fy = ay - (ay - by) * 2 / 3;

                int ex = dx - (fx - dx);
                ex = ax;
                int ey = fy;
                // g.setColor(Color.white);
                g.drawLine(dx, dy, fx, fy);
                g.setColor(Color.blue);
                g.drawLine(dx, dy, ex, (int) ey);
                g.drawLine(ex, (int) ey, fx, fy);

                Polygon p = new Polygon();

                p.addPoint(dx, dy);
                p.addPoint(ex, (int) ey);
                p.addPoint(fx, fy);
                g.setColor(Color.white);
                 g.fillPolygon(p);

                drawSnowflake(g, ex, (int) ey, fx, (int) fy, 1);
                drawSnowflake(g, ax, ay, dx, dy, 2);
                drawSnowflake(g, fx, fy, bx, by, 2);
                drawSnowflake(g, dx, dy, ex, ey, 6);
            }
            case 3 -> {
                // calc midpoints
                int dx = bx - (bx - ax) * 2 / 3;
                int dy = by - (by - ay) * 2 / 3;

                int fx = bx - (bx - ax) / 3;
                int fy = by - (by - ay) / 3;

                int ex = fx + (fx - dx);
                int ey = dy;

                g.drawLine(dx, dy, fx, fy);
                g.setColor(Color.blue);
                g.drawLine(dx, dy, ex, (int) ey);
                g.drawLine(ex, (int) ey, fx, fy);

                Polygon p = new Polygon();
                p.addPoint(dx, dy);
                p.addPoint(ex, (int) ey);
                p.addPoint(fx, fy);
                g.setColor(Color.white);
                g.fillPolygon(p);

                drawSnowflake(g, dx, (int) dy, ex, (int) ey, 1);
                drawSnowflake(g, ex, (int) ey, fx, (int) fy, 5);
                drawSnowflake(g, ax, ay, dx, dy, 3);
                drawSnowflake(g, fx, fy, bx, by, 3);

            }
            case 4 -> {
                // calc midpoints
                int dx = bx + (ax - bx) * 2 / 3;
                int dy = ay;

                int fx = bx + (ax - bx) / 3;
                int fy = ay;

                int ex = dx - (dx - fx) / 2;
                double ey = by + (dx - fx) * (Math.sqrt(3) / 2);
                g.setColor(Color.blue);

                g.drawLine(dx, dy, ex, (int) ey);
                

                g.drawLine(ex, (int) ey, fx, fy);
                
                g.setColor(Color.white);
                g.drawLine(dx, dy, fx, fy);

                Polygon p = new Polygon();
                p.addPoint(dx, dy);
                p.addPoint(ex, (int) ey);
                p.addPoint(fx, fy);
                g.fillPolygon(p);

                drawSnowflake(g, ax, ay, dx, dy, 4);
                drawSnowflake(g, dx, dy, ex, (int) ey, 5);
                drawSnowflake(g, ex, (int) ey, fx, (int) fy, 6);
                                drawSnowflake(g, fx, fy, bx, by, 4);
            }
            case 5 -> {
                // calc midpoints
                int dx = ax - (ax - bx) / 3;
  
                int dy = ay + (by - ay) / 3;

                int fx = ax - (ax - bx) * 2 / 3;
   
                int fy = ay + (by - ay) * 2 / 3;

                int ex = dx + (dx - fx);
                int ey = fy;
                g.setColor(Color.white);
                g.drawLine(dx, dy, fx, fy);
                g.setColor(Color.blue);
                g.drawLine(dx, dy, ex, (int) ey);
                g.drawLine(ex, (int) ey, fx, fy);

                Polygon p = new Polygon();

                p.addPoint(dx, dy);
                p.addPoint(ex, (int) ey);
                p.addPoint(fx, fy);
                g.setColor(Color.white);
                 g.fillPolygon(p);

                drawSnowflake(g, ex, (int) ey, fx, (int) fy, 4);
                drawSnowflake(g, ax, ay, dx, dy, 5);
                drawSnowflake(g, fx, fy, bx, by, 5);
                drawSnowflake(g, dx, dy, ex, ey, 3);
            }
                        case 6 -> {
                // calc midpoints
                int dx = bx + (ax - bx) * 2 / 3;
                int dy = by + (ay - by) * 2 / 3;

                int fx = bx + (ax - bx) / 3;
                int fy = by + (ay - by) / 3;

                int ex = fx + (fx - dx);
                int ey = dy;
                g.setColor(Color.white);
                g.drawLine(dx, dy, fx, fy);
                g.setColor(Color.blue);
                g.drawLine(dx, dy, ex, (int) ey);
                g.drawLine(ex, (int) ey, fx, fy);

                Polygon p = new Polygon();

                p.addPoint(dx, dy);
                p.addPoint(ex, (int) ey);
                p.addPoint(fx, fy);
                g.setColor(Color.white);
                 g.fillPolygon(p);

                drawSnowflake(g, ex, (int) ey, fx, (int) fy, 2);
                drawSnowflake(g, ax, ay, dx, dy, 6);
                drawSnowflake(g, fx, fy, bx, by, 6);
                drawSnowflake(g, dx, dy, ex, ey, 4);
            }
            default -> {
                return;
            }
        }

    }

    public static boolean isPow(double x) {

        for (int i = 1; Math.pow(4, i) <= x; i++) {

            if (Math.pow(4, i) == x) {

                return true;
            }
        }

        return false;
    }

    public int resize(double x) {

        if (x > 768) {

            x = 768;
        }

        double pow = Math.log10(x) / Math.log10(4);
        pow = Math.floor(pow);

        return (int) Math.pow(4, pow);
    }
}
