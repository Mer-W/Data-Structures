/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package day09triangle01;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;

public class Day09Triangle01 extends JFrame {

    public static void main(String[] args) {

        Day09Triangle01 mainWindowForDrawing = new Day09Triangle01();
    }

    public Day09Triangle01() {
        setLayout(new BorderLayout());
        setSize(500, 500);
        setTitle("first drawing window");
        DrawingArea drawingArea = new DrawingArea();
        add("Center", drawingArea);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class DrawingArea extends Canvas {

        @Override
        public void paint(Graphics g) {
            
            int aX = 5;
            int aY = getHeight() - 5;
            int bX = getWidth() / 2;
            int bY = 5;
            int cX = getWidth() - 5;
            int cY = getHeight() - 5;

            drawTriangle(g, aX, aY, bX, bY, cX, cY, 0);

        }

    }

    private void drawTriangle(Graphics g, int aX, int aY, int bX, int bY, int cX, int cY, int count) {

        if (bX > aX && bX - aX < 4 ||
                bX < aX && aX - bX < 4 ||
                aY > bY && aY - bY < 2 ||
                aY < bY && bY - aY < 2) {
            return;
        }

        if (count == 0) {
                    Polygon abc = new Polygon();

            abc.addPoint(aX, aY);
            abc.addPoint(bX, bY);
            abc.addPoint(cX, cY);
            g.setColor(Color.white);

            g.fillPolygon(abc);

            g.setColor(Color.magenta);

            g.drawLine(aX, aY, bX, bY);
            g.drawLine(bX, bY, cX, cY);
            g.drawLine(cX, cY, aX, aY); 
            
        }

        switch (count % 4) {
            
            case 1 -> g.setColor(Color.orange);
            case 2 -> g.setColor(Color.magenta);
            case 3 -> g.setColor(Color.yellow);
            default -> g.setColor(Color.red);
        }
  
        
        // calc midpoints
        int dX = (aX + bX) / 2;
        int dY = (aY + bY) / 2;
        int eX = (bX + cX) / 2;
        int eY = (bY + cY) / 2;
        int fX = (cX + aX) / 2;
        int fY = (cY + aY) / 2;


        count++;

        g.drawLine(dX, dY, eX, eY);
        g.drawLine(eX, eY, fX, fY);
        g.drawLine(fX, fY, dX, dY);
        
         drawTriangle(g, dX, dY, eX, eY, fX, fY, count);
//        drawTriangle(g, aX, aY, dX, dY, fX, fY, count);
//        drawTriangle(g, dX, dY, bX, bY, eX, eY, count);
//        drawTriangle(g, fX, fY, eX, eY, cX, cY, count);

//        drawTriangle(g, gX, gY, hX, hY, iX, iY, count);
//        drawTriangle(g, jX, jY, kX, kY, lX, lY, count);
//        drawTriangle(g, mX, mY, nX, nY, oX, oY, count);

    }

    public boolean isExp(double x) {

        x = x - 1;

        if (x == 2) {

            return true;
        }

        while (x > 2) {

            x = x / 2;

            System.out.println(x);

            if (x == 2) {

                return true;
            }
        }

        return false;
    }
}
