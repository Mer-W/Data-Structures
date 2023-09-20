/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package day09firstfractal;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author mer
 */
public class MainWindow extends JFrame {

    public static void main(String[] args) {

        MainWindow mainWindowForDrawing = new MainWindow();
    }

    public MainWindow() {
        setLayout(new BorderLayout());
        setSize(500, 375);
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

            g.drawLine(10, 10, getWidth() - 10, 10);

            drawFractal(g, 10, getWidth() - 10, 20, 20);
        }

    }

    // set base case: number of rows? window height / stepY
    // 
    private void drawFractal(Graphics g, int fromX, int toX, int levelY, int stepY) {
        int segWidth = toX - fromX;
        
        if (segWidth <= 1) {
            return;
        }
       // System.out.println(toX);

       // System.out.println(segWidth);

        int width = segWidth;
      //  System.out.println("width: " + width);

        segWidth /= 3;
       // System.out.println("segWidth: " + segWidth);

        //fromX /= 3;
        toX = segWidth + fromX;
       // System.out.println("toX: " + toX);

        levelY += stepY;

        g.drawLine(fromX, levelY, toX, levelY);
        
        drawFractal(g, fromX, toX, levelY, stepY);

        g.drawLine(toX - segWidth, levelY, toX + (2 * segWidth), levelY);
        
        drawFractal(g, fromX + (2 * segWidth), toX + (2 * segWidth), levelY, stepY); 

    }
}
