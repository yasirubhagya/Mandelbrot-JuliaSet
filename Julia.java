package fractals;

class Julia extends Fractals {

   

    //constructor
    public Julia(int width, int height,int xs,int xr,int ys,int yr, double Cx, double Cy, int iterations) {
        super(width,height,xs,xr,ys,yr);
       
        this.mapxMin = -1;
        this.mapxMax = 1;
        this.mapyMin = -1;
        this.mapyMax = 1;
        this.Cx = Cx;
        this.Cy = Cy;
        this.iteration = iterations;
    }

    //mapping function
    @Override
    
    //check whether points are in mandelbrot set or not
 
    protected int checking(double[] z) {

        double z_x = z[0], z_y = z[1];
        int i = 0;
        for (i=0; i < iteration; i++) {
            double Zx = (z_x * z_x) - (z_y * z_y) + this.Cx;
            double Zy = (2 * z_x * z_y) + this.Cy;
            z_x = Zx;
            z_y = Zy;
          

            if ((z_x * z_x + z_y * z_y) > 4) {
                return i;
            }
        }
        return i;
    }
    
    
}

