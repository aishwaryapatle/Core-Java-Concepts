import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Display {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//Step 1 : Driver Registration
		
  		Class.forName("com.mysql.cj.jdbc.Driver");
  		System.out.println("Driver Registered");
  		
  		//Step 2 : Connection Building
  		
  		Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB","root","abc123");
  		System.out.println("connected");	
  		
		JFrame frame2 = new JFrame("Employee Management System");
		JButton insert = new JButton("Insert");
		insert.setBounds(10, 10, 100, 25);
		frame2.getContentPane().setLayout(null);
		
		DefaultListModel model = new DefaultListModel();
		Statement s = null;

		try {
			s = con1.createStatement();
			String sql = "SELECT * FROM  EmployeeDB.Emp";
			
			ResultSet rs = s.executeQuery(sql);
			while((rs!=null) && (rs.next()))
            {		
				model.addElement(rs.getString("empno") + " - " + rs.getString("empname")+ " - " + rs.getString("salary"));
            }

			rs.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			if(s != null) {
				s.close();
				con1.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		// Label Result
		final JLabel lblResult = new JLabel("Result");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(62, 154, 272, 14);
		frame2.getContentPane().add(lblResult);
	    
	    // Scroll Pane
	    JScrollPane scrollPane = new JScrollPane();
	    
	    final JList list = new JList(model);
	    list.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent evt) {
	            lblResult.setText(list.getSelectedValue().toString());
	        }
	    });
	    
	    scrollPane.setViewportView(list);
	    scrollPane.setBounds(113, 48, 200, 100);
	    frame2.getContentPane().add(scrollPane);
	    frame2.setSize(1100, 400);
		  frame2.setLayout(null);
		  frame2.setVisible(true);

	}
	
	}

