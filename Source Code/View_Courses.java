import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

public class View_Courses {
    JFrame frame;
    JPanel myPanel;
    JLabel label;
    JScrollPane jsp;
    ArrayList<Course_Information> list = new ArrayList<>();
    
    public View_Courses(){
        frame = new JFrame("View Courses");
        frame.setPreferredSize(new Dimension(400, 400));
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
}
