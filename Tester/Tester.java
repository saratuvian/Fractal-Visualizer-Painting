import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Tester {

    public static FractalsPanel leftPanel;
    public static JPanel rightPanel;
    public static JSpinner S_lengthSpinner;
    public static JSpinner S_resSpinner;
    public static JSpinner S_fillTypeSpinner;
    public static JPanel centerPanel;
    public static JRadioButton RB_Squares;
    public static JRadioButton RB_Triangles;

    public static void main(String[] args) {

        // Create the window
        JFrame fullScreenWindow = new JFrame("Fractal Tester");
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        device.setFullScreenWindow(fullScreenWindow);
        fullScreenWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the top panel
        JPanel topPanel = new JPanel();
        topPanel.setSize(fullScreenWindow.getWidth() - 20, fullScreenWindow.getHeight() / 10);
        Border topPanelBorder = new LineBorder(Color.BLACK, 1, true);
        topPanel.setBorder(topPanelBorder);
        fullScreenWindow.add(topPanel, BorderLayout.NORTH);

        // Add shapes label
        JLabel txt_shapes = new JLabel("Shapes:");
        topPanel.add(txt_shapes);

        // Create a button group for radio buttons
        ButtonGroup BG_options = new ButtonGroup();

        // Radio buttons for shapes
        RB_Squares = new JRadioButton("Squares");
        RB_Triangles = new JRadioButton("Triangles");

        // Add radio buttons to button group
        BG_options.add(RB_Squares);
        BG_options.add(RB_Triangles);

        // Add radio buttons to the panel
        topPanel.add(RB_Squares);
        topPanel.add(RB_Triangles);

        // Add length spinner
        JLabel txt_Length = new JLabel("        Length:");
        topPanel.add(txt_Length);
        SpinnerModel SM_lengthSpinnerModel = new SpinnerNumberModel(100, 10, 500, 1);
        S_lengthSpinner = new JSpinner(SM_lengthSpinnerModel);
        topPanel.add(S_lengthSpinner);

        // Add resolution spinner
        JLabel txt_res = new JLabel("        Resolution:");
        topPanel.add(txt_res);
        SpinnerModel SM_resSpinnerModel = new SpinnerNumberModel(2, 2, 20, 1);
        S_resSpinner = new JSpinner(SM_resSpinnerModel);
        topPanel.add(S_resSpinner);

        // Add fill type spinner
        JLabel txt_fillType = new JLabel("        Fill type:");
        topPanel.add(txt_fillType);
        SpinnerModel SM_fillTypeSpinnerModel = new SpinnerNumberModel(2, -1, 3, 1);
        S_fillTypeSpinner = new JSpinner(SM_fillTypeSpinnerModel);
        topPanel.add(S_fillTypeSpinner);

        // Create the left panel
        leftPanel = new FractalsPanel((int) S_fillTypeSpinner.getValue(), (int) S_lengthSpinner.getValue());
        leftPanel.setPreferredSize(new Dimension(fullScreenWindow.getWidth() , fullScreenWindow.getHeight()));
        Border leftPanelBorder = new LineBorder(Color.BLACK, 1, true);
        leftPanel.setBorder(leftPanelBorder);
        
        // Create the center panel
        centerPanel = new JPanel(new GridLayout(1, 2));
        centerPanel.add(leftPanel);

        // Add panels to content pane
        fullScreenWindow.add(centerPanel, BorderLayout.CENTER);

        // Add radio button listeners
        RB_Squares.addItemListener(e -> updateFractal());
        RB_Triangles.addItemListener(e -> updateFractal());

        // Add spinners listeners
        S_lengthSpinner.addChangeListener(e -> updateFractal());
        S_resSpinner.addChangeListener(e -> updateFractal());
        S_fillTypeSpinner.addChangeListener(e -> updateFractal());

        // Create an exit button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0)); // Exit the program when the button is clicked
        topPanel.add(exitButton);

        // Set the window visible
        fullScreenWindow.setVisible(true);
    }

    private static void updateFractal() {
        int length = (int) S_lengthSpinner.getValue();
        int res = (int) S_resSpinner.getValue();
        int fillType = (int) S_fillTypeSpinner.getValue();

        if (RB_Squares.isSelected()) {
            leftPanel.setFractal(new SquareFractal(length, res));
        } else if (RB_Triangles.isSelected()) {
            leftPanel.setFractal(new TriangleFractal(length, res));
        }
        leftPanel.setFillType(fillType);
        leftPanel.repaint();
    }
}
