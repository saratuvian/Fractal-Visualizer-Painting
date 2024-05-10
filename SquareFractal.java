import java.awt.*;
public class SquareFractal extends FractalPainter{
    private int res;
    private int length;

    public SquareFractal(int length, int res){
        super(res);
        this.length=length;
    }

    public void drawSquare (Graphics g,int w,int h,int length,int fillType) {
        if (getResolution() > length)
        return;
        if (fillType == EMPTY){
            g.drawRect(w,h,length,length);
        }
        else if(fillType == FILL){
           g.fillRect(w,h,length,length);
        }
        g.drawRect(w,h,length,length);
        drawSquare ( g, w+length/4,  h-length/2 ,length/2,fillType);
        drawSquare(g,w-length/2,h+length/4,length/2,fillType);
        drawSquare(g,w+length,h+length/4,length/2,fillType);
        drawSquare(g, w+length/4,h+length,length/2,fillType);
    }

    public void draw(Graphics g, int w, int h, int fillType){
        drawSquare(g,w/2-length/2,h/2-length/2,length,fillType);

    }

}

