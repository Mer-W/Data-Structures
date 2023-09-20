/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package day09squarecross;

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
public class Day09SquareCross extends JFrame {

    public static void main(String[] args) {

        Day09SquareCross mainWindowForDrawing = new Day09SquareCross();

    }

    public Day09SquareCross() {
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
            int aY = 5;
            int width = getWidth() - 10;
            int height = getHeight() - 10;

            drawCross(g, aX, aY, width, height, 0);

            /*
            //square
            g.drawLine(10, 10, 20, 10);
            g.drawLine(10, 10, 10, 20);
            g.drawLine(20, 10, 20, 20);
            g.drawLine(10, 20, 20, 20);

            //cross
            g.drawLine(14, 10, 14, 14);
            g.drawLine(10, 14, 14, 14);

            g.drawLine(17, 10, 17, 14);
            g.drawLine(17, 14, 21, 14);

            g.drawLine(10, 17, 14, 16);
            g.drawLine(14, 17, 14, 20);

            g.drawLine(16, 16, 20, 16);
            g.drawLine(16, 16, 16, 20);

            //smallest
            g.drawLine(11, 11, 11, 11);
            g.drawLine(13, 13, 13, 13);
            g.drawLine(11, 13, 11, 13);
            g.drawLine(13, 11, 13, 11);
             */
        }

    }

    private void drawCross(Graphics g, int aX, int aY, int width, int height, int type) {

        if (width < 2 || height < 2) {
            return;
        }

        int bX = aX + width;
        int bY = aY;
        int cX = bX;
        int cY = bY + height;
        int dX = aX;
        int dY = aY + height;

        switch (type) {

            case 1 -> {
                g.drawLine(bX, bY, cX, cY);
                g.drawLine(cX, cY, dX, dY);
            }
            case 2 -> {
                g.drawLine(cX, cY, dX, dY);
                g.drawLine(dX, dY, aX, aY);
            }
            case 3 -> {
                g.drawLine(aX, aY, bX, bY);
                g.drawLine(dX, dY, aX, aY);
            }
            case 4 -> {
                g.drawLine(aX, aY, bX, bY);
                g.drawLine(bX, bY, cX, cY);
            }
            default -> {
                g.drawLine(aX, aY, bX, bY);
                g.drawLine(bX, bY, cX, cY);
                g.drawLine(cX, cY, dX, dY);
                g.drawLine(dX, dY, aX, aY);
            }

        }
        
        int eX = bX - 2 * width / 5;
        // double eX = bX -  width / 3;

        int eY = aY;
        int fX = eX;
        int fY = dY - 2 * height / 5;
        //int fY = dY - height / 3;

        int gX = aX;
        int gY = fY;

        width = 2 * width / 5;
        height = 2 * height / 5;

        drawCross(g, aX, aY, width, height, 1);
        drawCross(g, (int) eX, eY, width, height, 2);
        drawCross(g, (int) fX, fY, width, height, 3);
        drawCross(g, gX, gY, width, height, 4);

    }
    /*
    public static boolean isPow(double x) {

        for (int i = 1; Math.pow(5, i) <= x; i++) {

            if (Math.pow(2, i) == x) {

                return true;
            }
        }

        return false;
    }
     */
 /*
    public int resize(double x) {

        double pow = Math.log10(x) / Math.log10(5);
        pow = Math.floor(pow);

        return (int) Math.pow(5, pow);
    }
     */

}
