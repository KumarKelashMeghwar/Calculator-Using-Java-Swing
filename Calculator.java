import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener{
	
	JTextField textfield;
	JButton operationalButtons[] = new JButton[5];
	JButton numberButtons[] = new JButton[11];
	JButton equButton, plusButton, minusButton,multiButton,divButton,delButton,clearButton;
	JPanel panel;
	double num1,num2,result;
	char operator;

	Font font = new Font("Ink Free",Font.BOLD,25);
	
	public Calculator() {
		
		this.setTitle("Calculator By 19SW28");
		this.setBounds(200,50,400, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.gray);
		this.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(40,20,300,30);
		textfield.setFont(font);
		
		
		
		operationalButtons[1] = plusButton;
		operationalButtons[2] = minusButton;
		operationalButtons[3] = multiButton;
		operationalButtons[4] = divButton;
		
		for(int i=1; i<=4; i++) {
			operationalButtons[i] = new JButton();
			operationalButtons[i].setFocusable(false);
			operationalButtons[i].setFont(font);
			operationalButtons[i].addActionListener(this);
		}
		
		operationalButtons[0] = equButton;
		operationalButtons[0] = new JButton("=");
		operationalButtons[0].addActionListener(this);
		operationalButtons[0].setFont(font);
		operationalButtons[0].setFocusable(false);
		
		operationalButtons[1].setText("+"); 
		operationalButtons[2].setText("-"); 
		operationalButtons[3].setText("x");
		operationalButtons[4].setText("/"); 
		

		for(int i=0; i<10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].setFocusable(false);
			numberButtons[i].setFont(font);
			numberButtons[i].addActionListener(this);
			
		}
		
		numberButtons[10] = new JButton(".");
		numberButtons[10].setFocusable(false);
		numberButtons[10].setFont(font);
		numberButtons[10].addActionListener(this);
		
		panel = new JPanel();
		panel.setBounds(40,75,300,300);
		panel.setLayout(new GridLayout(4,4,4,4));
		panel.setBackground(Color.gray);
		
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(operationalButtons[4]);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(operationalButtons[3]);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(operationalButtons[2]);
		panel.add(operationalButtons[0]);
		panel.add(numberButtons[10]);
		panel.add(numberButtons[0]);
		panel.add(operationalButtons[1]);
		
		
		
		
		delButton = new JButton("DEL");
		delButton.addActionListener(this);
		delButton.setBounds(80,390,100,50);
		delButton.setFocusable(false);
		delButton.setFont(font);
		
		clearButton = new JButton("CLEAR");
		clearButton.addActionListener(this);
		clearButton.setBounds(200,390,130,50);
		clearButton.setFocusable(false);
		clearButton.setFont(font);
		
		this.add(panel);
		this.add(textfield);
		this.add(delButton);
		this.add(clearButton);
	
	}
	

	public static void main(String[] args) {
	
		new Calculator();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0; i<11; i++)
		{
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(numberButtons[i].getText()));
			}
		}
		
		if(e.getSource() == operationalButtons[1]) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		
		if(e.getSource() == operationalButtons[2]) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		
		if(e.getSource() == operationalButtons[3]) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		
		if(e.getSource() == operationalButtons[4]) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		
		
		if(e.getSource() == operationalButtons[0]) {

			num2 = Double.parseDouble(textfield.getText());
			
			switch (operator) {
				case '+':
					result = num1 + num2;
					break;
					
				case '-':
					result = num1 - num2;
					break;
					
				case '*':
					result = num1 * num2;		
					break;
					
				case '/':					
					result = num1 / num2;					
					break;
			}
			
			textfield.setText(String.valueOf(result));
			num1 = result;
		}
		
		
		if(e.getSource() == clearButton) {
			textfield.setText("");
		}
		
		if(e.getSource() == delButton) {
			
			String string = textfield.getText();
			textfield.setText("");
			
			for(int i=0; i<string.length()-1; i++)
			{
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		
	}
}
