import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.*;

public class JDBC implements ActionListener {
	
	JFrame frame;
	JPanel panel1, panel2;
	JButton button1, button2, button3, button4;
	JLabel name, state, credit_limit, rep_no;
	JTextField CustName, State, Credit_Limit, Rep_No;
	
	JDBC(){
		frame = new JFrame("PROGRAM 5");
		
		button1 = new JButton("Enter Form");
		button1.addActionListener(this);
		button2 = new JButton("Credit Limit");
		button2.addActionListener(this);
		panel1 = new JPanel();
		panel1.add(button1);
		panel1.add(button2);
		
		panel2 = new JPanel();
		name = new JLabel("Name");
		CustName = new JTextField(20);
		state = new JLabel("State");
		State = new JTextField(20);
		credit_limit = new JLabel("Credit Limit");
		Credit_Limit = new JTextField(20);
		rep_no = new JLabel("Rep Number");
		Rep_No = new JTextField(20);
		button3 = new JButton("Enter");
		button3.addActionListener(this);
		button4 = new JButton("Close");
		button4.addActionListener(this);
		panel2.add(name);
		panel2.add(CustName);
		panel2.add(state);
		panel2.add(State);
		panel2.add(rep_no);
		panel2.add(Rep_No);
		panel2.add(credit_limit);
		panel2.add(Credit_Limit);
		panel2.add(button3);
		panel2.add(button4);
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
	
		frame.add(panel1);
		frame.setBounds(500, 250, 300, 200);
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {
			this.frame.remove(panel1);
			this.frame.add(panel2);
			this.frame.pack();
			this.frame.setBounds(500, 250, 500, 400);
		}
		
		else if(e.getSource()==button2) {
			try {
	             Class.forName("com.mysql.cj.jdbc.Driver");
	             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "monu80921");
	             PreparedStatement stmt = con.prepareStatement("SELECT * FROM Customer where Credit_Limit > 15000");
	             ResultSet rs = stmt.executeQuery();
	             while(rs.next()) {
	            	 System.out.println("CustNo:- "+rs.getInt("CustNo")+" Name:- " +rs.getString("CustName")+" State:-"+rs.getString("State")+" RepNo:- "+rs.getInt("RepNo"));
	            	 System.out.println("Credit Limit:- "+rs.getInt("Credit_Limit"));
	             }
			}
			catch (Exception exception) {
                exception.printStackTrace();
		}
		}
		
		else if(e.getSource()==button3) {
			String custName = CustName.getText();
			String stateName = State.getText();
			int repNo = Integer.parseInt(Rep_No.getText());
			int creditLimit = Integer.parseInt(Credit_Limit.getText());
			
			try {
	             Class.forName("com.mysql.cj.jdbc.Driver");
	             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
	             
	             PreparedStatement insertStmt = con.prepareStatement("INSERT INTO Customer (CustName, State, RepNo, Credit_Limit) VALUES (?, ?, ?, ?)");
	             insertStmt.setString(1,custName);
	             insertStmt.setString(2, stateName);
	             insertStmt.setInt(3, repNo);
	             insertStmt.setInt(4,creditLimit);
	             int rowsInserted = insertStmt.executeUpdate();
	             System.out.println("Rows inserted:- "+rowsInserted);
			}
			catch (Exception exception) {
                exception.printStackTrace();
		}

		}
		
		else if(e.getSource()==button4) {
			this.frame.remove(panel2);
			this.frame.add(panel1);
			this.frame.pack();
			this.frame.setBounds(500, 250, 300, 200);
		}
	}
	
	
	public static void main(String args[]) {
	new JDBC();
	}

}