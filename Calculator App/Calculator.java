import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculator extends JFrame implements ActionListener
{
	JTextField field;
	JButton[] number_button = new JButton[10];//HOLDS ALL THE BUTTONS (0-9)
	JButton[] operator_button = new JButton[9];//HOLDS ALL OPERATORS
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton,equalsButton,delButton,clearButton,negButton;
	JPanel panel;
	
	Font font = new Font("Arial",Font.BOLD,30);//FONT AND SIZE FOR ALL BUTTONS
	double num1=0,num2=0,result=0;
	String operator;
	
	Calculator()
	{
		this.setSize(410,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Calculator APP by Deepak");
		this.setLayout(null); //NO LAYOUT
		this.setResizable(false);
		field = new JTextField(); //SHOWS NUMBERS AND RESULT
		field.setBounds(50,25,300,50);
	    field.setFont(font);
		field.setEditable(false);
		
		addButton = new JButton("+");
        subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equalsButton = new JButton("=");
		delButton = new JButton("DEL");
		clearButton = new JButton("CLR");
		negButton = new JButton("neg");
	    //adding all buttons to the operator array!	
		operator_button[0] = addButton;
		operator_button[1] = subButton;
		operator_button[2] = mulButton;
		operator_button[3] = divButton;
		operator_button[4] = decButton;
		operator_button[5] = equalsButton;
		operator_button[6] = delButton;
		operator_button[7] = clearButton;
		operator_button[8] = negButton;
		
		for(int i=0; i<9; i++)
		{
			operator_button[i].addActionListener(this);//do action with all 8 buttons
            operator_button[i].setFont(font);
            operator_button[i].setFocusable(false);			
		}
		
	    for(int j=0; j<10; j++)
		{
			number_button[j] = new JButton(String.valueOf(j)); //INSTANTIATE NUMBER BUTTONS
			number_button[j].addActionListener(this);
			number_button[j].setFont(font);
			number_button[j].setFocusable(false);
		}
		delButton.setBounds(150,430,100,50);
		clearButton.setBounds(250,430,100,50);
		negButton.setBounds(50,430,100,50);
		
		panel = new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setBackground(Color.GRAY);
		panel.setLayout(new GridLayout(4,4,10,10)); //4 rows,4 coloumns, distance between each buttons 10 pixels(x,y).
		//ADDING ALL BUTTONS TO PANEL
		panel.add(number_button[1]);
		panel.add(number_button[2]);
		panel.add(number_button[3]);
		panel.add(addButton);
		panel.add(number_button[4]);
		panel.add(number_button[5]);
		panel.add(number_button[6]);
		panel.add(subButton);
		panel.add(number_button[7]);
		panel.add(number_button[8]);
		panel.add(number_button[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(number_button[0]);
		panel.add(equalsButton);
		panel.add(divButton);
			
		this.add(panel);
		this.add(delButton); //ADD DEL AND CLEAR BUTTONS IN FRAME,OUTSIDE PANEL
		this.add(clearButton);
		this.add(negButton);
		this.add(field);// Cannot write inside text field
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		for(int i=0; i<10; i++)
		{
			if(e.getSource().equals(number_button[i])) //ITERATE THROUGH ALL THE BUTTONS!
	        {
				//update text field with the number typed...
				field.setText(field.getText().concat(String.valueOf(i)));
			}	
		}
		if(e.getSource().equals(decButton))
		{
			field.setText(field.getText().concat(String.valueOf(".")));
		}
		if(e.getSource().equals(addButton))
		{
			num1 = Double.parseDouble(field.getText()); //converting user entered string number in textfield into Double data_type.
			operator = "+";
			field.setText("");
		}
		if(e.getSource().equals(subButton))
		{
			num1 = Double.parseDouble(field.getText());
			operator = "-";
			field.setText("");
		}
		if(e.getSource().equals(divButton))
		{
			num1 = Double.parseDouble(field.getText());
			operator = "/";
			field.setText("");
		}
		if(e.getSource().equals(mulButton))
		{
			num1 = Double.parseDouble(field.getText());
			operator = "*";
			field.setText("");
		}
		if(e.getSource()==equalsButton)
		{
			num2 = Double.parseDouble(field.getText());
			switch(operator)
			{
				case "+":
				{ result = num1 + num2;
				  break;
				}
				case "-":
				{result = num1-num2;
				 break;
				}
				case "*":
				{
					result = num1*num2;
					break;
				}
				case "/":
				{
					result = num1/num2;
				}
			}
			field.setText(String.valueOf(result));
			num1 = result; //reuse same number for later operations.
		}
		if(e.getSource().equals(clearButton))
		{
			field.setText("");
		}
		if(e.getSource().equals(delButton))
		{
			String s = field.getText();
			field.setText("");
			for(int k=0; k<s.length()-1; k++) //ITERATE UPTO(END OF STRING -1)
			{
				field.setText(field.getText() + s.charAt(k));
			}
		}
		if(e.getSource()==negButton)
		{
			double temp = Double.parseDouble(field.getText());
			temp = -temp;
			field.setText(String.valueOf(temp));
		}
	}
}