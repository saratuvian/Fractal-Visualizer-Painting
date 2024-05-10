import java.awt.*;

public class TriangleFractal extends FractalPainter {
    private int length;

    public TriangleFractal(int length, int res){
        super(res);
        this.length=length;
    }
    public void drawTriangle (Graphics g,int w,int h,int length, int fillType) {
        if (getResolution() > length)
            return;
        int [] x ={w-length/2,w,w+length/2};
        int [] y ={h+length/4,h-length/2,h+length/4};
        g.drawPolygon(x,y,3);
        drawTriangle(g,w-length/4,h+length/8,length/2,1);
     drawTriangle(g,w+length/4,h+length/8,length/2,1);
     drawTriangle(g,w,h-length/4,length/2,1);
    }
    public void draw(Graphics g, int w, int h, int fillType){
        drawTriangle(g,w/2,h/2,length,fillType);
    }

}
