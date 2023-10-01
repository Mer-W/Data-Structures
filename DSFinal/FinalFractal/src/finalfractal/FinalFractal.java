/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalfractal;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author mer
 */
public class FinalFractal extends JFrame {

    public static void main(String[] args) {

        FinalFractal mainWindowForDrawing = new FinalFractal();

    }

    public FinalFractal() {
        setLayout(new BorderLayout());
        setSize(500, 500);
        setTitle("Fractal Squares");
        DrawingArea drawingArea = new DrawingArea();
        add("Center", drawingArea);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class DrawingArea extends Canvas {

        @Override
        public void paint(Graphics g) {
            int aX = getWidth() / 4;
            int aY = getHeight() / 4;
            int width = getWidth() / 2;
            int height = getHeight() / 2;

            drawSquares(g, aX, aY, width, height, 0);
        }
    }

    private void drawSquares(Graphics g, int aX, int aY, int width, int height, int type) {

        if (width < 2 || height < 2) {
            return;
        }

        // calculate vertices
        int bX = aX + width;
        int bY = aY;
        int cX = bX;
        int cY = bY + height;
        int dX = aX;
        int dY = aY + height;

        // draw square (after initial, omit overlapping segment)
        switch (type) {
            
            case 0 -> {
                g.drawLine(aX, aY, bX, bY);
                g.drawLine(bX, bY, cX, cY);
                g.drawLine(cX, cY, dX, dY);
                g.drawLine(dX, dY, aX, aY);
            }
            case 1 -> {
                g.drawLine(aX, aY, bX, bY);
                g.drawLine(bX, bY, cX, cY);
                g.drawLine(dX, dY, aX, aY);
            }
            case 2 -> {
                g.drawLine(aX, aY, bX, bY);
                g.drawLine(bX, bY, cX, cY);
                g.drawLine(cX, cY, dX, dY);

            }
            case 3 -> {
                g.drawLine(bX, bY, cX, cY);
                g.drawLine(cX, cY, dX, dY);
                g.drawLine(dX, dY, aX, aY);
            }
            case 4 -> {
                g.drawLine(aX, aY, bX, bY);
                g.drawLine(cX, cY, dX, dY);
                g.drawLine(dX, dY, aX, aY);
            }
            default -> {
            }
        }

        width = width / 3;
        height = height / 3;

        // calculate next starting points
        int eX = aX + width;
        int eY = aY - height;
        int fX = bX;
        int fY = bY + height;
        int gX = eX;
        int gY = cY;
        int hX = aX - width;
        int hY = fY;

        // draw next 4
        drawSquares(g, eX, eY, width, height, 1);
        drawSquares(g, fX, fY, width, height, 2);
        drawSquares(g, gX, gY, width, height, 3);
        drawSquares(g, hX, hY, width, height, 4);
    }

}
