/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package day09triangle03;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;

public class Day09Triangle03 extends JFrame {

    public static void main(String[] args) {

        Day09Triangle03 mainWindowForDrawing = new Day09Triangle03();

    }

    public Day09Triangle03() {
        setLayout(new BorderLayout());
        setSize(512, 512);
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
            int aX = 0;
            int aY = getHeight();
            int bX = getWidth() / 2;
            int bY = 0;
            int cX = getWidth();
            int cY = getHeight();

            drawTriangle(g, aX, aY, bX, bY, cX, cY, 0);

        }

    }

    private void drawTriangle(Graphics g, int aX, int aY, int bX, int bY, int cX, int cY, int count) {

        if (cX - aX < 7 || aY - bY < 7) {
            return;
        }

        if (count == 0) {

            // determine nearest powers of 2
            int width = cX - aX;
            int newWidth = 0;
            int height = aY - bY;
            int newHeight = 0;

            //width
            while (width % 2 != 0) {

                cX--;
                width = cX - aX;
            }

            //height
            while (height % 2 != 0) {

                bY++;
                height = aY - bY;
            }
            if (!isPow2(width)) {

                System.out.println("resizing width");
                newWidth = resize(width);

                for (int i = 0; i < width - newWidth; i += 2) {

                    aX++;
                    cX--;
                }
            }

            if (!isPow2(height)) {

                // System.out.println("resizing height");
                newHeight = resize(height);

                for (int i = 0; i < height - newHeight; i += 2) {

                    bY++;
                    cY--;
                    aY--;
                }
            }

            // draw first iteration
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

        if (dX * 2 < aX + bX) {
            dX++;
        }
        if (dY * 2 < aY + bY) {
            dY++;
        }
        if (eX * 2 > bX + cX) {
            eX--;
        }
        if (eY * 2 < bY + cY) {
            eY++;
        }
        if (fY * 2 > cY + aY) {
            fY--;
        }

        // fill middle
        Polygon def = new Polygon();
        def.addPoint(dX, dY);
        def.addPoint(eX, eY);
        def.addPoint(fX, fY);
        g.setColor(Color.white);
        g.fillPolygon(def);

        // line middle
        g.setColor(Color.magenta);
        g.drawLine(dX, dY, eX, eY);
        g.drawLine(eX, eY, fX, fY);
        g.drawLine(fX, fY, dX, dY);

        count++;

        // outer triangles
        drawTriangle(g, aX, aY, dX, dY, fX, fY, count);
        drawTriangle(g, dX, dY, bX, bY, eX, eY, count);
        drawTriangle(g, fX, fY, eX, eY, cX, cY, count);

    }

    public static boolean isPow(double x) {

        while (x >= 2) {

            if (x == 2) {

                return true;
            }

            x = x / 2;
        }

        return false;
    }

    public static boolean isPow2(double x) {

        for (int i = 1; Math.pow(2, i) <= x; i++) {

            if (Math.pow(2, i) == x) {

                return true;
            }
        }

        return false;
    }

    public int resize(double x) {

        double pow = Math.log10(x) / Math.log10(2);
        pow = Math.floor(pow);

        return (int) Math.pow(2, pow);
    }
}
