package fractals;

import javax.swing.*;

public class Main {

    private static final int width = 800; //frame width
    private static final int height = 800; //frame height
   

    public static void main(String[] args) {
        double xMin = 0, xMax = 0, yMin = 0, yMax = 0, cx = 0, cy = 0;
        int n = 0;
        
        if (args.length >= 1) {
            //for Mandelbrot
            if (args[0].equals("Mandelbrot")) {

                switch (args.length - 1) {
                    case 0:                    //default values
                        xMin = -1;
                        xMax = 1;
                        yMin = -1;
                        yMax = 1;
                        n = 1000;

                        break;
                    case 4:                 //set passed values from command line arguments
                        xMin = Double.parseDouble(args[1]);
                        xMax = Double.parseDouble(args[2]);
                        yMin = Double.parseDouble(args[3]);
                        yMax = Double.parseDouble(args[4]);
                        n = 1000;

                        break;
                    case 5:                 //set passed values from command line arguments
                        xMin = Double.parseDouble(args[1]);
                        xMax = Double.parseDouble(args[2]);
                        yMin = Double.parseDouble(args[3]);
                        yMax = Double.parseDouble(args[4]);
                        n = Integer.parseInt(args[5]);

                        break;
                    default:
                        System.out.println("Not enough arguments for Mandelbrot");
                        return;
                }
                 Mandelbrot.matrix=new int [height][width];
                Thread manb1 = new Thread( new Mandelbrot(width, height, 0,width/2,0,height/2, xMin, xMax, yMin, yMax, n),"first thread");
                Thread manb2 = new Thread( new Mandelbrot(width, height, width/2,width,0,height/2, xMin, xMax, yMin, yMax, n),"second thread");
                Thread manb3 = new Thread( new Mandelbrot(width, height, 0,width/2,height/2,height, xMin, xMax, yMin, yMax, n),"third thread");
                Thread manb4 = new Thread( new Mandelbrot(width, height, width/2,width,height/2,height, xMin, xMax, yMin, yMax, n),"fourth thread");
                      manb1.start();
                      manb2.start();
                      manb3.start();
                      manb4.start();
                try {
                        manb1.join();
                        manb2.join();
                        manb3.join();
                        manb4.join();
                } catch (InterruptedException e) {
                    System.out.println("Not good");
                    return;
                }

               
            } else if (args[0].equals("Julia")) {  //for Julia set

                switch (args.length - 1) {
                    case 0:            //default values
                        cx = -0.4;
                        cy = 0.6;
                        n = 1000;
                        break;
                    case 3:    //set passed values form command line arguments
                        cx = Double.parseDouble(args[1]);
                        cy = Double.parseDouble(args[2]);
                        n = Integer.parseInt(args[3]);
                        break;
                    default:
                        System.out.println("Not enough arguments for Julia set");
                        return;
                }
                Julia.matrix = new int [height][width];
                Thread jul1 = new Thread( new Julia(width, height, 0,width/2,0,height/2, cx, cy, n),"first thread");
                Thread jul2 = new Thread( new Julia(width, height, width/2,width,0,height/2, cx, cy, n),"second thread");
                Thread jul3 = new Thread( new Julia(width, height, 0,width/2,height/2,height, cx, cy, n),"third thread");
                Thread jul4 = new Thread( new Julia(width, height, width/2,width,height/2,height, cx, cy, n),"fourth thread");
                
                      jul1.start();
                      jul2.start();
                      jul3.start();
                      jul4.start();
                try {
                        jul1.join();
                        jul2.join();
                        jul3.join();
                        jul4.join();

                } catch (InterruptedException e) {
                    System.out.println("Not good");
                    return;
                }
                
            } else {
                System.out.println("Not a Fractal");
                return;
            }

        } else {
            System.out.println("Enter a valid fractal name, Julia or Mandelbrot");
            return;
        }
        JFrame frame = new JFrame(args[0]);
        frame.setContentPane(new Display(width, height, Fractals.matrix, n));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
