import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame("Calculator");
		
		JLabel firstNumber = new JLabel("First Number");
		firstNumber.setBounds(100,20,100,25);
		
		JLabel secondNumber = new JLabel("Second Number");
		secondNumber.setBounds(250,20,100,25);
		
		JLabel result = new JLabel();
		result.setBounds(175,150,200,25);
		
		JTextField fnum = new JTextField();
		fnum.setBounds(90,50,100,25);
		
		JTextField snum = new JTextField();
		snum.setBounds(247,50,100,25);
		
		JButton addition = new JButton("Addition");
		addition.setBounds(10, 100, 100, 25);
		
		addition.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int num1 = Integer.parseInt(fnum.getText());
				int num2 = Integer.parseInt(snum.getText());

				result.setText("Addition = "+(num1+num2));
			}
		});
		
		JButton subtraction = new JButton("Subtraction");
		subtraction.setBounds(120, 100, 100, 25);
		
		subtraction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int num1 = Integer.parseInt(fnum.getText());
				int num2 = Integer.parseInt(snum.getText());

				result.setText("Subtraction = "+(num1-num2));
			}
		});

		JButton multiplication = new JButton("Multiplication");
		multiplication.setBounds(230, 100, 110, 25);
		
		multiplication.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int num1 = Integer.parseInt(fnum.getText());
				int num2 = Integer.parseInt(snum.getText());

				result.setText("Multiplication = "+(num1*num2));
			}
		});

		JButton division = new JButton("Division");
		division.setBounds(350, 100, 100, 25);
		
		division.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int num1 = Integer.parseInt(fnum.getText());
				int num2 = Integer.parseInt(snum.getText());

				result.setText("Division = "+(num1/num2));
			}
		});

		frame.add(firstNumber);
		frame.add(secondNumber);
		frame.add(fnum);
		frame.add(snum);
		frame.add(addition);
		frame.add(subtraction);
		frame.add(multiplication);
		frame.add(division);
		frame.add(result);
		
		frame.setSize(500, 400);
		frame.setLayout(null);
		frame.setVisible(true);
	}

}
