/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yasiru
 */
package fractals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.*;

public class Display extends JPanel {

    private int width; //frame width
    private int height; //frame height
    private int maxiteration = 0;
    public int[][] matrix;

    //constructor
    public Display(int w, int h, int[][] mat, int maxit) {
        this.width = w;
        this.height = h;
        this.matrix = mat;
        this.maxiteration = maxit;
        setPreferredSize(new Dimension(width, height));
    }

    //constructor overloading
    //paint points
    private static void printPoint(Graphics2D frame, Color c, double x, double y) {
        frame.setColor(c);
        frame.draw(new Line2D.Double(x, y, x, y));
    }

    @Override
    public void paintComponent(Graphics g) {
        // call paintComponent from parent class 
        super.paintComponent(g);

        for (int j = 0; j < this.height; j++) {   //checking for all pixels
            for (int i = 0; i < this.width; i++) {
                int niter = this.matrix[j][i];
                if (niter >= this.maxiteration) {
                    printPoint((Graphics2D) g, Color.BLACK, i, j); //colour the points in the set
                } else {
                    Color color = Color.getHSBColor((float) niter * 10.0f / (float) this.maxiteration, 1.0f, 1.0f);
                    printPoint((Graphics2D) g, color, i, j); //colour the points outside the set
                }

            }
        }
    }

}
