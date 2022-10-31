import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Add_Courses implements ActionListener {
    JFrame frame = new JFrame("View Courses");;
    JPanel myPanel;
    JLabel label, label1, label2;
    JButton button, button1;
    JTextField textfield, textfield1, textfield2;

    public Add_Courses(){
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setLocation(200,200);

        myPanel = new JPanel();
        label = new JLabel("Course Name: ");
        label1 = new JLabel("Percentage Mark: ");
        label2 = new JLabel("Credit Weight");
        textfield = new JTextField(30); 
        textfield1 = new JTextField(30);
        textfield2 = new JTextField(30);

        button = new JButton("Add Course");
        button.addActionListener(this);
        button.setActionCommand("add");

        button1 = new JButton("Back");
        button1.addActionListener(this);
        button1.setActionCommand("back");

        myPanel.add(label);
        myPanel.add(textfield);
        myPanel.add(label1);
        myPanel.add(textfield1);
        myPanel.add(label2);
        myPanel.add(textfield2);
        myPanel.add(button);
        myPanel.add(button1);

        frame.add(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new Add_Courses();
    }

    public void actionPerformed (ActionEvent event){
        String eventName = event.getActionCommand();
        if (eventName.equals("back")){
            this.frame.setVisible(false);
            new Main_Menu();
        }
        else if (eventName.equals("add")){
            String s = textfield.getText();
            String s1 = textfield1.getText();
            String s2 = textfield2.getText();
            add_course(s, s1, s2);
        }
    }

    public void add_course(String s, String s1, String s2){
        try{
            if(!s.isEmpty() && !s1.isEmpty() && !s2.isEmpty()){
                FileWriter fw = new FileWriter("C:/Users/admin/Desktop/Github Projects/GPA-Calculator/Resources/Database.txt", true);
                Double.parseDouble(s1);
                Double.parseDouble(s2);
                
                fw.write("\n" + s + ",");
                fw.write("" + java.time.LocalDate.now() + ",");
                fw.write(s2 + ",");
                fw.write(calculate_letter(s1) + ",");
                fw.write(s1);
                JOptionPane.showMessageDialog(frame, "Successfully added the information!");
                fw.close();
            }
            else{
                JOptionPane.showMessageDialog(frame, "Please don't leave any spaces above empty!");
            }
        }
        catch(IOException e){

        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers for percentage mark and credit weight!");
        }
    }

    public String calculate_letter(String s1){
        double d = Double.parseDouble(s1);
        if (d <= 100 && d >= 90){
            return "A+";
        }
        else if (d < 90 && d >= 85){
            return "A";
        }
        else if (d < 85 && d >= 80){
            return "A-";
        }
        else if (d < 80 && d >= 77){
            return "B+";
        }
        else if (d < 77 && d >= 73){
            return "B";
        }
        else if (d < 73 && d >= 70){
            return "B-";
        }
        else if (d < 70 && d >= 67){
            return "C+";
        }
        else if (d < 67 && d >= 63){
            return "C";
        }
        else if (d < 63 && d >= 60){
            return "C-";
        }
        else if (d < 60 && d >= 57){
            return "D+";
        }
        else if (d < 57 && d >= 53){
            return "D";
        }
        else if (d < 53 && d >= 50){
            return "D-";
        }
        else if (d < 50 && d >= 0){
            return "F";
        }

        return "";
    }
}
