import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//Student class
class Student {
    String name, adress, category, usn;
    int age;
    double cgpa;

    Student(String name, String usn, String adress, String category, int age, double cgpa) {
        this.name = name;
        this.usn = usn;
        this.adress = adress;
        this.category = category;
        this.age = age;
        this.cgpa = cgpa;
    }

    String getDetails() {
        return ("Name: " + this.name + " Age: " + this.age + " USN: " + this.usn + " Adress: " + this.adress
                + " Category: " + this.category + " CGPA: " + this.cgpa);
    }
}

//Class for cgpa
class cgpa implements ActionListener {
    JFrame frame;
    JTextField name, age, usn, adress, category, sgpa1, sgpa2, sgpa3, sgpa4, sgpa5, sgpa6, sgpa7, sgpa8;
    JTextArea display_area;
    JLabel name_label, age_label, usn_label, adress_label, category_label, sgpa;
    JButton done, compute, display;
    ArrayList<Student> list;

    cgpa() {
        frame = new JFrame("CGPA Calculation");
        frame.setLayout(new FlowLayout());
        list = new ArrayList<Student>();
        name = new JTextField(20);
        name_label = new JLabel("Enter name");
        name_label.setBounds(120, 50, 25, 5);
        frame.add(name_label);
        frame.add(name);

        age = new JTextField(3);
        age_label = new JLabel("Enter age");
        frame.add(age_label);
        frame.add(age);

        usn = new JTextField(20);
        usn_label = new JLabel("Enter USN");
        frame.add(usn_label);
        frame.add(usn);

        adress = new JTextField(20);
        adress_label = new JLabel("Enter the adress: ");
        frame.add(adress_label);
        frame.add(adress);

        category = new JTextField(10);
        category_label = new JLabel("Enter the Category: ");
        frame.add(category_label);
        frame.add(category);

        sgpa = new JLabel("Enter the SGPA for 8 semesters: ");
        frame.add(sgpa);
        sgpa1 = new JTextField(5);
        frame.add(sgpa1);
        sgpa2 = new JTextField(5);
        frame.add(sgpa2);
        sgpa3 = new JTextField(5);
        frame.add(sgpa3);
        sgpa4 = new JTextField(5);
        frame.add(sgpa4);
        sgpa5 = new JTextField(5);
        frame.add(sgpa5);
        sgpa6 = new JTextField(5);
        frame.add(sgpa6);
        sgpa7 = new JTextField(5);
        frame.add(sgpa7);
        sgpa8 = new JTextField(5);
        frame.add(sgpa8);

        done = new JButton("Done");
        done.addActionListener(this);
        frame.add(done);

        compute = new JButton("Compute");
        compute.addActionListener(this);
        frame.add(compute);

        display = new JButton("Display");
        display.addActionListener(this);
        frame.add(display);

        display_area = new JTextArea();
        display_area.setBounds(300, 250, 500, 300);
        frame.add(display_area);

        // frame.setLayout(null);
        frame.setBounds(250, 300, 500, 300);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == done) {
            String name = this.name.getText(), adress = this.adress.getText(), category = this.category.getText(),
                    usn = this.usn.getText();
            int age = Integer.parseInt(this.age.getText());
            double c1 = Double.parseDouble(this.sgpa1.getText());
            double c2 = Double.parseDouble(this.sgpa2.getText());
            double c3 = Double.parseDouble(this.sgpa3.getText());
            double c4 = Double.parseDouble(this.sgpa4.getText());
            double c5 = Double.parseDouble(this.sgpa5.getText());
            double c6 = Double.parseDouble(this.sgpa6.getText());
            double c7 = Double.parseDouble(this.sgpa7.getText());
            double c8 = Double.parseDouble(this.sgpa8.getText());
            double cgpa = (c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8) / 8;
            Student s = new Student(name, usn, adress, category, age, cgpa);
            this.list.add(s);

        } else if (e.getSource() == compute) {
            double c1 = Double.parseDouble(this.sgpa1.getText());
            double c2 = Double.parseDouble(this.sgpa2.getText());
            double c3 = Double.parseDouble(this.sgpa3.getText());
            double c4 = Double.parseDouble(this.sgpa4.getText());
            double c5 = Double.parseDouble(this.sgpa5.getText());
            double c6 = Double.parseDouble(this.sgpa6.getText());
            double c7 = Double.parseDouble(this.sgpa7.getText());
            double c8 = Double.parseDouble(this.sgpa8.getText());
            double cgpa = (c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8) / 8;
            JOptionPane.showMessageDialog(null, "CGPA :" + cgpa);
        } else if (e.getSource() == display) {
            StringBuilder build = new StringBuilder();
            for (Student s : this.list) {
                build.append(s.getDetails()).append("\n");
            }
            JOptionPane.showMessageDialog(null, build.toString());
        }
    }
}

//MainClass
public class StudentSGPA {
    public static void main(String args[]) {
		 new cgpa();
	}

}