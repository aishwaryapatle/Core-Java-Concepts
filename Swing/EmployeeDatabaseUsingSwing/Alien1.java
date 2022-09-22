import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Alien1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Step 1 : Driver Registration
		
  		Class.forName("com.mysql.cj.jdbc.Driver");
  		System.out.println("Driver Registered");
  		
  		//Step 2 : Connection Building
  		
  		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB","root","abc123");
  		System.out.println("connected");	
  		
		//Swing
		JFrame frame = new JFrame("Employee Management System");
		JOptionPane pane = new JOptionPane();
		
		//Insert
		JLabel label = new JLabel("Insert data");
		label.setBounds(180,20,100,25);
		
		JLabel id = new JLabel("Employee ID");
		id.setBounds(100,60,100,25);
		
		JTextField idText = new JTextField();
		idText.setBounds(250,60,100,25);
		
		JLabel name = new JLabel("Employee Name");
		name.setBounds(100,100,100,25);
		
		JTextField nameText = new JTextField();
		nameText.setBounds(250,100,100,25);
		
		JLabel sal = new JLabel("Employee Salary");
		sal.setBounds(100,140,100,25);
		
		JTextField salaryText = new JTextField();
		salaryText.setBounds(250,140,100,25);
		
		JButton insert = new JButton("Insert");
		insert.setBounds(160, 200, 100, 25);
		
		insert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int empno = Integer.parseInt(idText.getText());
				String empname = nameText.getText();
				String salary = salaryText.getText();
				
				
				//Insert Statement
				int a=0;
				PreparedStatement st;
				try {
					st = con.prepareStatement("INSERT INTO EmployeeDB.Emp VALUES(?,?,?)");
					System.out.println("\nStatement created");
					st.setInt(1, empno);
					st.setString(2, empname);
					st.setString(3, salary);
					a = st.executeUpdate();
					
					idText.setText(null);
					nameText.setText(null);
					salaryText.setText(null);
					
					pane.showMessageDialog(frame, "Data Successfully Inserted!");
					pane.setBounds(160, 250, 100, 25);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(a>0)
				{
					System.out.println("data inserted successfully!");
				}
				else
				{
					System.out.println("data is not inserted :(");
				}
			}
		});
		
		
		//Update
		JLabel label1 = new JLabel("Update data");
		label1.setBounds(1080,20,100,25);
		
		JLabel updateId = new JLabel("Employee ID");
		updateId.setBounds(1000,60,100,25);
		
		JTextField updateIdText = new JTextField();
		updateIdText.setBounds(1140,60,100,25);
		
		JLabel comboId = new JLabel("<html>What do you<br>want to update?</html>");
		comboId.setBounds(1000,100,100,40);
		frame.add(comboId);
		
		String updateElements [] = {"Employee Name", "Employee Salary"};
		
		final JComboBox cb = new JComboBox(updateElements);
		cb.setBounds(1140,100,100,25);
	
		frame.add(cb); 
		
		JButton submit = new JButton("Submit");
		submit.setBounds(1140, 140, 100, 25);
		frame.add(submit);
		
		JLabel updateName = new JLabel("Employee Name");
		updateName.setBounds(1000,180,100,25);
		updateName.setVisible(false);
		
		JTextField updateNameText = new JTextField();
		updateNameText.setBounds(1140,180,100,25);
		updateNameText.setVisible(false);
		
		JLabel updateSal = new JLabel("Employee Salary");
		updateSal.setBounds(1000,180,100,25);
		updateSal.setVisible(false);
		
		JTextField updateSalText = new JTextField();
		updateSalText.setBounds(1140,180,100,25);
		updateSalText.setVisible(false);
		
		JButton update = new JButton("Update");
		update.setBounds(1060, 240, 100, 25);
		update.setVisible(false);
		
		String s1 = "Employee Name";
		String s2 = "Employee Salary";
	
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String data = (String) cb.getItemAt(cb.getSelectedIndex());
				if(data.equals(s1))
				{
					updateName.setVisible(true);
					updateNameText.setVisible(true);
					updateSal.setVisible(false);
					updateSalText.setVisible(false);
					update.setVisible(true);
				}
				else if(data.equals(s2))
				{
					updateSal.setVisible(true);
					updateSalText.setVisible(true);
					updateName.setVisible(false);
					updateNameText.setVisible(false);
					update.setVisible(true);
				}	
			}
		});
		
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	
				int empno = Integer.parseInt(updateIdText.getText());
				
				//Update Statement
				int a=0;
				PreparedStatement st;
				String data = (String) cb.getItemAt(cb.getSelectedIndex());

				if(data.equals(s1))
				{
					String empname = updateNameText.getText();
					try {
						st = con.prepareStatement("UPDATE EmployeeDB.Emp SET empname=? WHERE empno = ?");
						System.out.println("\nStatement created");
						st.setString(1, empname);
						st.setInt(2, empno);
						a = st.executeUpdate();
						
						updateName.setText(null);
						updateNameText.setText(null);
						updateIdText.setText(null);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				else if(data.equals(s2))
				{
					String salary = updateSalText.getText();
					try {
						st = con.prepareStatement("UPDATE EmployeeDB.Emp SET salary=? WHERE empno = ?");
						System.out.println("\nStatement created");
						st.setString(1, salary);
						st.setInt(2, empno);
						a = st.executeUpdate();
						
						updateSal.setText(null);
						updateSalText.setText(null);
						updateIdText.setText(null);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				if(a>0)
				{
					System.out.println("Employee name is updated successfully!");
				}
				else
				{
					System.out.println("Employee name is not updated :(");
				}
			}
		});
			
		//delete
		JLabel label2 = new JLabel("Delete data");
		label2.setBounds(780,20,100,25);
		
		JLabel deleteId = new JLabel("Employee ID");
		deleteId.setBounds(700,60,100,25);
		
		JTextField deleteIdText = new JTextField();
		deleteIdText.setBounds(850,60,100,25);
		
		JButton delete = new JButton("Delete");
		delete.setBounds(760, 200, 100, 25);
		
		delete.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int empno = Integer.parseInt(deleteIdText.getText());
			
			//Delete Statement
			int a=0;
			PreparedStatement st;
			try {
				st = con.prepareStatement("DELETE FROM EmployeeDB.Emp WHERE empno = ?");
				System.out.println("\nStatement created");
				st.setInt(1, empno);
				a = st.executeUpdate();
				deleteIdText.setText(null);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(a>0)
			{
				System.out.println("Employee name is deleted successfully!");
			}
			else
			{
				System.out.println("Employee name is not deleted :(");
			}
		}
	});
		
	
		//search
		JLabel label4 = new JLabel("Search data");
		label4.setBounds(480,20,100,25);
		
		JLabel searchId = new JLabel("Employee ID");
		searchId.setBounds(400,60,100,25);
		
		JTextField searchIdText = new JTextField();
		searchIdText.setBounds(550,60,100,25);
		
		JLabel searchName = new JLabel("Employee Name");
		searchName.setBounds(400,100,100,25);
		
		JTextField searchNameText = new JTextField();
		searchNameText.setBounds(550,100,100,25);
		
		JLabel searchSal = new JLabel("Employee Salary");
		searchSal.setBounds(400,140,100,25);
		
		JTextField searchSalText = new JTextField();
		searchSalText.setBounds(550,140,100,25);
		
		JButton search = new JButton("Search");
		search.setBounds(460, 200, 100, 25);
		
		searchNameText.setEditable(false);
		searchSalText.setEditable(false);
		
		search.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int empno = Integer.parseInt(searchIdText.getText());
			
			//Update Statement
			int a=0;
			PreparedStatement st;
			try {
				st = con.prepareStatement("SELECT * FROM EmployeeDB.Emp WHERE empno = ?");
				System.out.println("\nStatement created");
				st.setInt(1, empno);
				//Excecuting Query
				ResultSet rs = st.executeQuery();
				if(rs.next())
				{
					String s1 = rs.getString("empname");
					String s2 = rs.getString("salary");
					//Sets Records in TextFields.
					searchNameText.setText(s1);
					searchSalText.setText(s2);
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	});
				
		frame.add(label);
		frame.add(id);
		frame.add(idText);
		frame.add(name);
		frame.add(nameText);
		frame.add(sal);
		frame.add(salaryText);
		frame.add(insert);
		
		frame.add(label1);
		frame.add(updateId);
		frame.add(updateIdText);
		frame.add(updateName);
		frame.add(updateNameText);
		frame.add(updateSal);
		frame.add(updateSalText);
		frame.add(update);
		
		frame.add(label2);
		frame.add(deleteId);
		frame.add(deleteIdText);
		frame.add(delete);
		
		frame.add(label4);
		frame.add(searchId);
		frame.add(searchIdText);
		frame.add(searchName);
		frame.add(searchNameText);
		frame.add(searchSal);
		frame.add(searchSalText);
		frame.add(search);
		
		frame.setSize(1100, 400);
		frame.setLayout(null);
		frame.setVisible(true);

	}

}
