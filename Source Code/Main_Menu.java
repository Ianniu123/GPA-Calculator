import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main_Menu implements ActionListener{
    JFrame frame;
    JPanel myPanel;
    JLabel label;
    JButton button1, button2, button3;

    public Main_Menu(){
        frame = new JFrame ("GPA Calculator");
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setLocation(200,200);

        myPanel = new JPanel();

        button1 = new JButton("Add Courses");
        button1.setActionCommand("add_course");
        button1.addActionListener(this);
        button1.setAlignmentX(JButton.CENTER_ALIGNMENT);

        button2 = new JButton("View Courses");
        button2.setActionCommand("view_course");
        button2.addActionListener(this);
        button2.setAlignmentX(JButton.CENTER_ALIGNMENT);

        button3 = new JButton("Exit");
        button3.setActionCommand("exit_program");
        button3.addActionListener(this);
        button3.setAlignmentX(JButton.CENTER_ALIGNMENT);

        label = new JLabel("GPA Calculator");
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        label.setFont(new Font("Arial", Font.PLAIN, 25));

        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        myPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        myPanel.add(label);
        myPanel.add(Box.createRigidArea(new Dimension(0,10)));
        myPanel.add(button1);
        myPanel.add(Box.createRigidArea(new Dimension(0,15)));
        myPanel.add(button2);
        myPanel.add(Box.createRigidArea(new Dimension(0,15)));
        myPanel.add(button3);
     

        frame.add(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed (ActionEvent event){
        String eventName = event.getActionCommand();
        if (eventName.equals("add_course")){
            frame.setVisible(false);
            new Add_Courses();
        }
        else if (eventName.equals("view_course")){
            frame.setVisible(false);
            new View_Courses(4);
        }
        else if (eventName.equals("exit_program")){
            System.exit(0);
        }
    }

    public static void main(String[] args){
        new Main_Menu();
    }

}