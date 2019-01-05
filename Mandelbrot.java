package fractals;

class Mandelbrot extends Fractals {

    //constructor
    public Mandelbrot(int width, int height,int xs,int xr,int ys,int yr, double xMin, double xMax, double yMin, double yMax, int iterations) {
        super(width, height,xs,xr,ys,yr);
        this.mapxMin = xMin;
        this.mapxMax = xMax;
        this.mapyMin = yMin;
        this.mapyMax = yMax;
        this.iteration = iterations;
    }

    //mapping function
    

    @Override
    //check whether points are in mandelbrot set or not
    protected int checking(double[] z) {

        double z_x = 0, z_y = 0;
        int i = 0;
        for (i = 0; i < iteration; i++) {
            double Zx = (z_x * z_x) - (z_y * z_y) + z[0];
            double Zy = (2 * z_x * z_y) + z[1];
            z_x = Zx;
            z_y = Zy;

            if ((z_x * z_x + z_y * z_y) > 4) {
                return i;
            }
        }
        return i;
    }

}
