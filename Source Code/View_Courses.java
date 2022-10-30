import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

import javax.swing.*;

public class View_Courses implements ActionListener {
    JFrame frame;
    JPanel myPanel;
    JLabel label, label1; 
    JScrollPane jsp;
    JButton button;
    ArrayList<Course_Information> list = new ArrayList<>();
    
    public View_Courses(){
        frame = new JFrame("View Courses");
        frame.setPreferredSize(new Dimension(815, 265));
        frame.setLocation(200,200);

        list = read_data(list);

        myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(0,5, 5, 5));
        
        create_first_row();

        for (int i = 0; i < list.size(); i++){
            JTextField text = new JTextField(list.get(i).get_course());
            JTextField text1 = new JTextField(list.get(i).get_date());
            JTextField text2 = new JTextField(list.get(i).get_credit() + "");
            JTextField text3 = new JTextField(list.get(i).get_letter());
            JTextField text4 = new JTextField(list.get(i).get_percentage() + "");

            text.setEditable(false);
            text1.setEditable(false);
            text2.setEditable(false);
            text3.setEditable(false);
            text4.setEditable(false);

            myPanel.add(text);
            myPanel.add(text1);
            myPanel.add(text2);
            myPanel.add(text3);
            myPanel.add(text4);
        }

        button = new JButton("Back");
        button.setActionCommand("back");
        button.addActionListener(this);
        
        label = new JLabel("4.0 GPA: " + (calculate_gpa(list))[0]);
        label1 = new JLabel("12-Point: "+ (calculate_gpa(list))[1]);

        myPanel.add(button);
        myPanel.add(label);
        myPanel.add(label1);
        
        jsp = new JScrollPane(myPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS) ;

        frame.add(jsp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    
    }

    public static void main(String[] args){
        new View_Courses();
    }

    public void create_first_row(){
        JTextField text = new JTextField("Course Name");
                JTextField text1 = new JTextField("Date Added");
                JTextField text2 = new JTextField("Credit Weight");
                JTextField text3 = new JTextField("Letter Grade");
                JTextField text4 = new JTextField("Percentage Grade");

                text.setEditable(false);
                text1.setEditable(false);
                text2.setEditable(false);
                text3.setEditable(false);
                text4.setEditable(false);

                myPanel.add(text);
                myPanel.add(text1);
                myPanel.add(text2);
                myPanel.add(text3);
                myPanel.add(text4);
    }

    public ArrayList<Course_Information> read_data(ArrayList<Course_Information> list){
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/98568/OneDrive/Desktop/Github/GPA-Calculator/Resources/Database.txt"));
            String line;

            while((line = br.readLine()) != null){
                String[] elements = line.split(",");
                Course_Information obj = new Course_Information();
                obj.set_course(elements[0]);
                obj.set_date(elements[1]);
                obj.set_credit(Double.parseDouble(elements[2]));
                obj.set_letter(elements[3]);
                obj.set_percentage(Double.parseDouble(elements[4]));
                list.add(obj);
            }

            br.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("File not found");
        }
        catch(IOException ex){
            System.out.println("Reader Error");
        }
        return list;
    }

    public void actionPerformed (ActionEvent event){
        String eventName = event.getActionCommand();
        if (eventName.equals("back")){
            this.frame.setVisible(false);
            new Main_Menu();
        }
    }

    public double[] calculate_gpa(ArrayList<Course_Information> list){
        double[] arr = new double[2];
        double total_grade4pt = 0;
        double total_grade12pt = 0;
        double total_credits = 0;
        for (int i = 0; i < list.size(); i++){
            String s = list.get(i).get_letter();
            total_credits += list.get(i).get_credit();

            if (s.equals("A+")){
                total_grade4pt += 4;
                total_grade12pt += 12; 
            }
            else if (s.equals("A")){
                total_grade4pt += 4;
                total_grade12pt += 11;
            }
            else if (s.equals("A-")){
                total_grade4pt += 3.7;
                total_grade12pt += 10;
            }
            else if (s.equals("B+")){
                total_grade4pt += 3.3;
                total_grade12pt += 9;
            }
            else if (s.equals("B")){
                total_grade4pt += 3.0;
                total_grade12pt += 8;
            }
            else if (s.equals("B-")){
                total_grade4pt += 2.7;
                total_grade12pt += 7;

            }
            else if (s.equals("C+")){
                total_grade4pt += 2.3;
                total_grade12pt += 6;

            }
            else if (s.equals("C")){
                total_grade4pt += 2.0;
                total_grade12pt += 5;
            }   
            else if (s.equals("C-")){
                total_grade4pt += 1.7;
                total_grade12pt += 4;
            }
            else if (s.equals("D+")){
                total_grade4pt += 1.3;
                total_grade12pt += 3;
            }
            else if (s.equals("D")){
                total_grade4pt += 1.0;
                total_grade12pt += 2;
            }
            else if (s.equals("D-")){
                total_grade4pt += 0.7;
                total_grade12pt += 1;
            }
        }
        
        arr[0] = total_grade4pt / total_credits;
        arr[1] = total_grade12pt / total_credits;

        return arr;
    }
}
