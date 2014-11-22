//Nicholas Witmer
//CSCD 300-01
//11/20/2014
//Homework 5/6

import java.util.Enumeration;
import java.util.Hashtable;


public class ExpressionEvaluator 
{
	private String infixExpression;
	private String postfixExpression;
	private double result;
	private boolean errorFlag;
	private String errorMessege;
	private Hashtable<Character, Double> varibleValues;
	private Hashtable<Character, Integer> currPrecedence;
	private Hashtable<Character, Integer> stackPrecedence;
	
	public ExpressionEvaluator(String infix, Hashtable<Character, Double> values)
	{
		this.varibleValues = values;
		this.infixExpression = infix;
		populatePrecedence();
		infixToPostfix();
	}
	
	private void populatePrecedence()
	{
		this.currPrecedence = new Hashtable<Character, Integer>();
		this.currPrecedence.put((Character)'(', (Integer)100);
		this.currPrecedence.put((Character)')', (Integer)0);
		this.currPrecedence.put((Character)'^', (Integer)6);
		this.currPrecedence.put((Character)'*', (Integer)3);
		this.currPrecedence.put((Character)'/', (Integer)3);
		this.currPrecedence.put((Character)'%', (Integer)3);
		this.currPrecedence.put((Character)'+', (Integer)1);
		this.currPrecedence.put((Character)'-', (Integer)1);
		
		this.stackPrecedence = new Hashtable<Character, Integer>();
		this.stackPrecedence.put((Character)'(', (Integer)0);
		this.stackPrecedence.put((Character)')', (Integer)0);
		this.stackPrecedence.put((Character)'^', (Integer)5);
		this.stackPrecedence.put((Character)'*', (Integer)4);
		this.stackPrecedence.put((Character)'/', (Integer)4);
		this.stackPrecedence.put((Character)'%', (Integer)4);
		this.stackPrecedence.put((Character)'+', (Integer)2);
		this.stackPrecedence.put((Character)'-', (Integer)2);
	}
	
	public boolean getErrorFlag()
	{
		return this.errorFlag;
	}
	
	public String getErrorString()
	{
		return this.errorMessege;
	}
	
	public double getResult()
	{
		return this.result;
	}
	
	private void infixToPostfix()
	{
		if(!ParensMatch.parenMatch(this.infixExpression))
		{
			this.errorFlag = true;
			this.errorMessege = "Parens Not Match Error!";
			return;
		}
		
		MyStack<Character> temp = new MyStack<Character>();
		String postfix = "";
		int i = 0;
		while(i < this.infixExpression.length())
		{
			if(this.infixExpression.charAt(i) != ' ')
			{
				if(Character.isAlphabetic(this.infixExpression.charAt(i)))
				{
					postfix += this.infixExpression.charAt(i);
				}
				else if(this.infixExpression.charAt(i) == '(')
				{
					temp.push(this.infixExpression.charAt(i));
				}
				else if(this.infixExpression.charAt(i) == ')')
				{
					while(!temp.peek().equals('('))
					{
						postfix += temp.pop();
					}
					temp.pop();
				}
				else
				{
					while(!temp.isEmpty() && (getPrecedence(temp.peek(), false) > getPrecedence(this.infixExpression.charAt(i), true)))
					{
						postfix += temp.pop();
					}
					temp.push(this.infixExpression.charAt(i));
				}
			}
			i++;
		}
		while(!temp.isEmpty())
		{
			postfix += temp.pop();
		}
		if(postfix.length() == 0)
		{
			this.errorFlag = true;
			this.errorMessege = "Empty infix expression Error!";
		}
		else
		{
			this.postfixExpression = postfix;
		}
	}
	
	private int getPrecedence(Character operator, boolean curr)
	{
		if(curr)
		{
			return this.currPrecedence.get(operator);
		}
		return this.stackPrecedence.get(operator);
	}
	
	public void solvePostfix()
	{
		if(this.errorFlag)
		{
			return;
		}
		int i = 0;
		MyStack<Character> temp = new MyStack<Character>();
		while(i < this.postfixExpression.length())
		{
			if(Character.isAlphabetic(this.postfixExpression.charAt(i)))
			{
				temp.push(this.postfixExpression.charAt(i));
			}
			else
			{
				Character right = temp.pop();
				Character left = temp.pop();
				Character result = evaluate(right, left, this.postfixExpression.charAt(i));
				temp.push(result);
			}
			i++;
		}
		if(temp.size() > 1)
		{
			this.errorFlag = true;
			this.errorMessege = "Infix Syntax Error!";
		}
		else
		{
			this.result = this.varibleValues.get(temp.pop());
		}
	}
	
	private Character evaluate(Character right, Character left, Character operator)
	{
		Double result;
		if(operator == '+')
		{
			result = this.varibleValues.get(left) + this.varibleValues.get(right);
		}
		else if(operator == '-')
		{
			if(this.varibleValues.get(right) < 0)
			{
				result = this.varibleValues.get(left) + Math.abs(this.varibleValues.get(right));
			}
			else
			{
				result = this.varibleValues.get(left) - this.varibleValues.get(right);
			}
		}
		else if(operator == '*')
		{
			result = this.varibleValues.get(left) * this.varibleValues.get(right);
		}
		else if(operator == '/')
		{
			result = this.varibleValues.get(left) / this.varibleValues.get(right);
		}
		else
		{
			result = Math.pow(this.varibleValues.get(left), this.varibleValues.get(right));
		}
		
		int curr = 'A';
		int currInt, nextInt;
		Enumeration<Character> keys = this.varibleValues.keys();
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
		this.varibleValues.put(resultKey, result);
		return resultKey;
	}
	
	public String toString()
	{
		String retString = "";
		if(this.errorFlag)
		{
			retString = this.infixExpression + " --> " + this.errorMessege;
		}
		else
		{
			String postfix = "";
			for(int i = 0; i < this.postfixExpression.length(); i++)
			{
				postfix =  postfix + this.postfixExpression.charAt(i) + " ";
			}
			retString = this.infixExpression + " --> " + postfix + " --> " + this.result;
		}
		return retString;
	}
}
