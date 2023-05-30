import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//Creating a class which holds all the data, methods and is also implementing ActionListener abstract class
public class LoginInfo implements ActionListener {

    // instantiating collections to hold data
    HashMap<Integer, String> customerList = new HashMap<Integer, String>();
    HashMap<Integer, Integer> itemList = new HashMap<Integer, Integer>();

    // variables
    String username = "admin";
    int password = 123;
    int total = 0;
    String discounts[] = { "0", "10", "20", "30" };
    double grandTotal = 0, discount = 0;
    String input_username;
    String input_password;
    JFrame f;
    JPanel p1, p2, p3;
    JTextField custId, itemId, itemQty;
    JButton b1, b2, b3;
    JLabel custId_label, itemId_label, itemQty_label, discount_label, total_price_label;
    JComboBox discount_options;
    CardLayout layout;

    // Constructor
    LoginInfo() {

        // this layout helps in switching between different panels
        this.layout = new CardLayout();

        // calling method to authenticate the user
        boolean auth = authentication();

        // if user is authenticated, we perform the necessary operations
        if (auth) {
            this.customerList.put(101, "7870809990");
            this.customerList.put(102, "8777943526");
            this.customerList.put(103, "6361693878");

            this.itemList.put(201, 200);
            this.itemList.put(202, 500);
            this.itemList.put(203, 100);

            this.f = new JFrame("Welcome to Ramaiah General Store");

            this.p1 = new JPanel();
            this.custId = new JTextField(10);
            this.custId_label = new JLabel("Enter your CustID:-");
            this.b1 = new JButton("Done");
            this.b1.addActionListener(this);
            p1.add(custId_label);
            p1.add(custId);
            p1.add(b1);

            this.p2 = new JPanel();
            this.b2 = new JButton("Done");
            this.b2.addActionListener(this);
            this.itemId = new JTextField(10);
            this.itemQty = new JTextField(3);
            this.itemId_label = new JLabel("Enter your itemID:-");
            this.itemQty_label = new JLabel("Enter item quantity");
            p2.add(itemId_label);
            p2.add(itemId);
            p2.add(itemQty_label);
            p2.add(itemQty);
            p2.add(b2);

            this.p3 = new JPanel();
            this.b3 = new JButton("Done");
            this.b3.addActionListener(this);
            this.discount_options = new JComboBox(discounts);
            this.discount_label = new JLabel("Select Discount:-");

            f.add(p1);
            this.f.setBounds(100, 100, 500, 400);
            this.f.setVisible(true);
            this.f.setLayout(new FlowLayout());

        }

    }

    // method to checking the user credentials
    boolean authentication() {
        this.input_username = JOptionPane.showInputDialog("Enter the username");
        if (this.input_username.equals(username)) {
            this.input_password = JOptionPane.showInputDialog("Enter Password");
            if (Integer.parseInt(input_password) == password)
                return true;
            else {
                JOptionPane.showMessageDialog(null, "Wrong Password");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Wrong Username");
            return false;
        }
    }

    // implementation of abstract method to perform necessary operations when button
    // is clicked
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String s = this.custId.getText();
            int cid = Integer.parseInt(s);
            if (!this.customerList.containsKey(cid)) {
                String tempNumber = JOptionPane.showInputDialog("Write customer number:- ");
                this.customerList.put(cid, tempNumber);
            }

            // switching to other panel
            this.f.remove(p1);
            this.f.add(p2);
            this.f.pack();
            this.f.setBounds(100, 100, 500, 400);
        } else if (e.getSource() == b2) {
            String s = this.itemId.getText();
            int iid = Integer.parseInt(s);
            if (!this.itemList.containsKey(iid)) {
                JOptionPane.showMessageDialog(null, "No item with item id:- " + iid);
            } else {
                s = this.itemQty.getText();
                int qty = Integer.parseInt(s);
                this.total = this.itemList.get(iid) * qty;
                this.total_price_label = new JLabel("Total Price:- " + this.total);
                p3.add(total_price_label);
                p3.add(discount_label);
                p3.add(discount_options);
                p3.add(b3);

                // switching to other panel
                this.f.remove(p2);
                this.f.add(p3);
                this.f.pack();
                this.f.setBounds(100, 100, 500, 400);
            }
        } else if (e.getSource() == b3) {
            String s = (String) this.discount_options.getSelectedItem();
            int d = Integer.parseInt(s);
            this.discount = (this.total * d) / 100;
            this.grandTotal = this.total - this.discount;
            JOptionPane.showMessageDialog(null, "Final Price:- " + this.grandTotal);
        }

    }

    public static void main(String[] args) {
		// instantiating pgm4_v2 object to call the constructor
		new LoginInfo();
	}
}