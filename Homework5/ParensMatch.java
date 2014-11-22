//Nicholas Witmer
//CSCD 300-01
//11/20/2014
//Homework 5/6
//This class has been adapted from CSCD 300 ArrayStack demo code

public class ParensMatch
{
	
	public static boolean parenMatch(String in)
	{
		MyStack<Character> stk = new MyStack<Character>();
		for(int i = 0; i < in.length(); i ++) 
		{
			char cur = in.charAt(i);
			if( isOpen(cur) )
			{
				stk.push(cur);
			}
			else if( isClose(cur) )
			{
				if( stk.isEmpty() )
				{
					return false;
				}
				if(!isMatch(stk.pop(), cur))
				{
					return false;
				}
			}
		}//end of for
		if( stk.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private static boolean isOpen(char c) 
	{
		return c == '(' || c == '{' || c == '[' ;
	}
	
	private static boolean isClose(char c) 
	{
		return c == ')' || c == '}' || c == ']' ;
	}
	
	private static boolean isMatch(char c1, char c2) {
		//We assume in this method c2 is one of closing parens
		if(c2 == ')')
		{
			return c1 == '(';
		}
		if(c2 == ']')
		{
			return c1 == '[';
		}
		if(c2 == '}')
		{
			return c1 == '{';
		}
		return false;
	}
}