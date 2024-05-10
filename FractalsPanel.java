import java.awt.*;
public class FractalsPanel extends JPanel{
    private FractalPainter fractalPainter ;
    public int fillType;
    public void setFillType(int fillType){
        this.fillType=fillType;
    };
    public FractalsPanel(int fillType,int length){this.fillType= fillType;}
    public void setFractal (FractalPainter fractal) {this.fractalPainter=fractal;}
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        fractalPainter.draw(g,getWidth(),getHeight(),fillType);
    }
}
