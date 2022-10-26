import java.awt.Dimension;
import javax.swing.*;

public class Menu{
    JFrame frame;
    JPanel myPanel;
    JLabel label;

    public Menu(){
        frame = new JFrame ("GPA Calculator");
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setLocation(200,200);

        myPanel = new JPanel();
        label = new JLabel("GPA Calculator");

        myPanel.add(label);
        frame.add(myPanel);
        frame.pack();
        frame.setVisible(true);
        
    }

    public static void main(String[] args){
        new Menu();
    }

}