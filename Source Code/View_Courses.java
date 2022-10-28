import java.awt.*;
import javax.swing.*;

public class View_Courses {
    JFrame frame;
    JPanel myPanel;
    JLabel label;
    JScrollPane jsp;

    public View_Courses(int num){
        frame = new JFrame("View Courses");
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setLocation(200,200);

        myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(25,40));
        
        for (int i = 1; i < 1001; i++){
            JTextField text = new JTextField();
            text.setEditable(false);
            myPanel.add(text);
        }

        jsp = new JScrollPane(myPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS) ;

        frame.add(jsp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    
    }

    public static void main(String[] args){
        new View_Courses(6);
    }
}
