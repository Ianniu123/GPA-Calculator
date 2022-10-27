import javax.swing.*;
import java.awt.*;

public class Add_Courses {
    JFrame frame;
    JPanel myPanel;
    JLabel label;
    
    public Add_Courses(){
        frame = new JFrame("View Courses");
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setLocation(200,200);

        myPanel = new JPanel();

        frame.add(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new Add_Courses();
    }
}
