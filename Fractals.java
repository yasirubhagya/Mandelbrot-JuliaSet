/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractals;

/**
 *
 * @author yasiru
 */


abstract class Fractals implements Runnable {

    protected int width, height;
    protected double mapxMin;
    protected double mapxMax;
    protected double mapyMin;
    protected double mapyMax;
    protected int iteration;
    protected double  Cx, Cy;
    protected int xstart;
    protected int xend;
    protected int ystart;
    protected int yend;
    public static int[][] matrix;
    

    
    //constructor
    public Fractals(int width, int height,int xs,int xr,int ys,int yr) {
        this.width = width;
        this.height = height;
        this.xstart =xs;
        this.xend=xr;
        this.ystart =ys;
        this.yend=yr;
    }

    //mapping function
    private double[] map(int p, int q){
     double[] z = new double[2];
        z[0] = (double) (p* (mapxMax - mapxMin) / width) + (mapxMin);
        z[1] = (double) (q *(mapyMax - mapyMin) / height) +(mapyMin);
        return z;
    }

    //check whether points are in mandelbrot set or not
    protected abstract int checking(double [] z);
    
    public  void  generateMatrix(){
        
         for (int j = ystart; j < yend; j++) {   //checking for all pixels
            for (int i = xstart; i < xend; i++) {
               double[] z = map(i,j);
               matrix[j][i]=checking(z);
            }
         }
       
    }
    
    public void run(){
        generateMatrix();
    }
    
}
