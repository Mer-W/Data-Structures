/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package day09triangle02;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;

public class Day09Triangle02 extends JFrame {

    public static void main(String[] args) {

        Day09Triangle02 mainWindowForDrawing = new Day09Triangle02();
    }

    public Day09Triangle02() {
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

        if (cX - aX < 10 || aY - bY < 10) {
            return;
        }

        if (count == 0) {

            g.setColor(Color.magenta);

            g.drawLine(aX, aY, bX, bY);
            g.drawLine(bX, bY, cX, cY);
            g.drawLine(cX, cY, aX, aY);
        }

        // calc midpoints
        int dX = (aX + bX) / 2;
        int dY = (aY + bY) / 2;
        int eX = (bX + cX) / 2;
        int eY = (bY + cY) / 2;
        int fX = (cX + aX) / 2;
        int fY = (cY + aY) / 2;
        
        Polygon def = new Polygon();

        def.addPoint(dX, dY);
        def.addPoint(eX, eY);
        def.addPoint(fX, fY);


        g.setColor(Color.white);

        g.fillPolygon(def);

        g.setColor(Color.magenta);

        count++;

        g.drawLine(dX, dY, eX, eY);
        g.drawLine(eX, eY, fX, fY);
        g.drawLine(fX, fY, dX, dY);

        drawTriangle(g, aX, aY, dX, dY, fX, fY, count);
        drawTriangle(g, dX, dY, bX, bY, eX, eY, count);
        drawTriangle(g, fX, fY, eX, eY, cX, cY, count);

    }

}
