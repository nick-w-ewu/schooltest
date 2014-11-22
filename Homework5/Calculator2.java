//Nicholas Witmer
//CSCD 300-01
//11/20/2014
//Homework 5/6

import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
 
class Calculator2 extends JFrame implements ActionListener
{ 

	private static final long serialVersionUID = 1L;
	JButton btn1 = new JButton("1");
	JButton btn2 = new JButton("2");
	JButton btn3 = new JButton("3");
	JButton btn_add = new JButton("+");
	JButton btn4 = new JButton("4");
	JButton btn5 = new JButton("5");
	JButton btn6 = new JButton("6");
	JButton btn_sub = new JButton("-");
	JButton btn7 = new JButton("7");
	JButton btn8 = new JButton("8");
	JButton btn9 = new JButton("9");
	JButton btn_mult = new JButton("*");
	JButton btn0 = new JButton("0");
	JButton btn_dot = new JButton(".");
	JButton btn_del = new JButton("DEL");
	JButton btn_div = new JButton("/");
	
	JButton btn_lpr = new JButton("(");
	JButton btn_rpr = new JButton(")");
	JButton btn_pow = new JButton("^");
	JButton btn_equ = new JButton("=");
	
	JTextArea txt = new JTextArea();
	String str_number = "";
	boolean newExpression;
	
	public Calculator2()
	{
		JFrame frame = new JFrame("Simple Java Caculator2");
		frame.setSize(320,420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLayout(new GridLayout(2,1));
		txt.setLineWrap(true);
		newExpression = false;

		JPanel HeadPanel = new JPanel();
		JPanel NumberPanel = new JPanel();
		JPanel LabelPanel = new JPanel();

		LabelPanel.setBackground(Color.LIGHT_GRAY);
		HeadPanel.setBackground(Color.LIGHT_GRAY);
		NumberPanel.setLayout(new GridLayout(5,4));
		//LabelPanel.setLayout(new BorderLayout());
		LabelPanel.setLayout(new GridLayout(1,1));

		NumberPanel.add(btn1);
		btn1.addActionListener(this);
		NumberPanel.add(btn2);
		btn2.addActionListener(this);
		NumberPanel.add(btn3);
		btn3.addActionListener(this);
		NumberPanel.add(btn_add);
		btn_add.addActionListener(this);

		NumberPanel.add(btn4);
		btn4.addActionListener(this);
		NumberPanel.add(btn5);

		btn5.addActionListener(this);
		NumberPanel.add(btn6);
		btn6.addActionListener(this);
		NumberPanel.add(btn_sub);
		btn_sub.addActionListener(this);

		NumberPanel.add(btn7);
		btn7.addActionListener(this);
		NumberPanel.add(btn8);
		btn8.addActionListener(this);
		NumberPanel.add(btn9);
		btn9.addActionListener(this);
		NumberPanel.add(btn_mult);
		btn_mult.addActionListener(this);

		NumberPanel.add(btn0);
		btn0.addActionListener(this);
		NumberPanel.add(btn_dot);
		btn_dot.addActionListener(this);
		NumberPanel.add(btn_del);
		btn_del.addActionListener(this);
		NumberPanel.add(btn_div);
		btn_div.addActionListener(this);
		LabelPanel.add(txt);

		//LabelPanel.add(btn_equ);
		NumberPanel.add(btn_lpr);
		btn_lpr.addActionListener(this);
		NumberPanel.add(btn_rpr);
		btn_rpr.addActionListener(this);
		NumberPanel.add(btn_pow);
		btn_pow.addActionListener(this);
		NumberPanel.add(btn_equ);
		btn_equ.addActionListener(this);

		txt.setEditable(false);
		//btn_del.setEnabled(false);
		HeadPanel.add(new JLabel("A Java Calculator"));
		frame.add(LabelPanel);
		frame.add(NumberPanel);
		frame.setVisible(true);
	}
	
	private void isNewExpression()
	{
		if(this.newExpression == true)
		{
			this.newExpression = false;
			this.str_number = "";
			txt.setText(str_number);
		}
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==btn1) {
			isNewExpression();
			str_number+="1";
			txt.setText(str_number); }
		else if(e.getSource()==btn2) {
			isNewExpression();
			str_number+="2";
			txt.setText(str_number); }
		else if(e.getSource()==btn3) {
			isNewExpression();
			str_number+="3";
			txt.setText(str_number); }
		else if(e.getSource()==btn4) {
			isNewExpression();
			str_number+="4";
			txt.setText(str_number); }
		else if(e.getSource()==btn5) {
			isNewExpression();
			str_number+="5";
			txt.setText(str_number); }
		else if(e.getSource()==btn6) {
			isNewExpression();
			str_number+="6";
			txt.setText(str_number); }
		else if(e.getSource()==btn7) {
			isNewExpression();
			str_number+="7";
			txt.setText(str_number); }
		else if(e.getSource()==btn8) {
			isNewExpression();
			str_number+="8";
			txt.setText(str_number); }
		else if(e.getSource()==btn9) {
			isNewExpression();
			str_number+="9";
			txt.setText(str_number); }
		else if(e.getSource()==btn0) {
			isNewExpression();
			str_number+="0";
			txt.setText(str_number); }
		else if(e.getSource()==btn_lpr) {
			isNewExpression();
			str_number+="(";
			txt.setText(str_number); }
		else if(e.getSource()==btn_rpr) {
			isNewExpression();
			str_number+=")";
			txt.setText(str_number); }
		else if(e.getSource()==btn_pow) {
			isNewExpression();
			str_number+="^";
			txt.setText(str_number); }
		else if(e.getSource()==btn_add) {
			isNewExpression();
			str_number+="+";
			txt.setText(str_number);}
		else if(e.getSource()==btn_sub) {
			isNewExpression();
			str_number+="-";
			txt.setText(str_number);}
		else if(e.getSource()==btn_mult) {
			isNewExpression();
			str_number+="*";
			txt.setText(str_number);}
		else if(e.getSource()==btn_div) {
			isNewExpression();
			str_number+="/";
			txt.setText(str_number);}
		else if(e.getSource()==btn_equ) {
			System.out.println("you clicked equal sign!");
			
			this.newExpression = true;
			ExpressionEvaluator inputExpression = processInput(str_number);
			inputExpression.solvePostfix();
			txt.setText(printResult(inputExpression, str_number));
		}	
		else if(e.getSource()==btn_dot) {
			isNewExpression();
			System.out.println("you clicked dot button!");
			str_number+=".";	
			txt.setText(str_number);
		}
		else if(e.getSource()==btn_del) 
		{
			System.out.println("you clicked Delete button!");
		}
	}
	
	private ExpressionEvaluator processInput(String text)
	{
		String patternString = "((\\d+)(\\.\\d*)?|(\\.\\d*))"; //find all string format of double numbers in target string, learn why use this?

		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(text);
		String infix = "";
		int end;
		if(!Character.isDigit(text.charAt(0)))
		{
			infix += text.charAt(0);
			end = 1;
		}
		else
		{
			end = 0;
		}
		Hashtable<Character, Double> values = new Hashtable<Character, Double>();
		
		while(matcher.find())
		{
			infix += text.substring(end, matcher.start());
			Character varaible = parseDouble(values, text.substring(matcher.start(), matcher.end()));
			infix += varaible;
			end = matcher.end();
		}
		if(!Character.isDigit(text.charAt(text.length() - 1)))
		{
			infix += text.charAt(text.length() - 1);
		}
		ExpressionEvaluator expression = new ExpressionEvaluator(infix, values);
		return expression;
	}

	private Character parseDouble(Hashtable<Character, Double> values, String toDouble)
	{
		Double newDouble = Double.parseDouble(toDouble);
		int curr = 64;
		int currInt, nextInt;
		Enumeration<Character> keys = values.keys();
		while(keys.hasMoreElements())
		{
			currInt = curr;
			nextInt = keys.nextElement();
			if(nextInt > currInt)
			{
				curr = nextInt;
			}
		}
		int currValue = curr;
		Character resultKey = Character.valueOf((char)(currValue + 1));
		values.put(resultKey, newDouble);
		return resultKey;
	}
	
	private String printResult(ExpressionEvaluator expression, String userExperssion)
	{
		String retString = "";
		if(expression.getErrorFlag())
		{
			retString = retString + userExperssion + "--> " + expression.getErrorString();
		}
		else
		{
			retString = retString + userExperssion + "=" + expression.getResult();
		}
		return retString;
	}
    
	public static void main(String[] args)
	{
		new Calculator2();
	
	}
}

