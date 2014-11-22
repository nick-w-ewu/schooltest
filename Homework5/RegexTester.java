import java.util.Enumeration;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTester
{
	public static void main(String[] args)
	{

		String text = "7-(5+6)";
		System.out.println(text.length());

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
		int count = 0;
		while(matcher.find())
		{
		    count++;
		    //BECARE the end index is not inclusive
		    infix += text.substring(end, matcher.start());
		    System.out.println( "" + count +  ":found a double num between index: " + " : "
		    		+ matcher.start() + " - " + matcher.end());
		    Character varaible = parseDouble(values, text.substring(matcher.start(), matcher.end()));
		    infix += varaible;
		    end = matcher.end();
		}
		if(!Character.isDigit(text.charAt(text.length() - 1)))
		{
			infix += text.charAt(text.length() - 1);
		}
		System.out.println("\nNOTE THAT: the end index is not inclusive!");
		System.out.println(values);
		System.out.println(infix);
	}
	
	private static Character parseDouble(Hashtable<Character, Double> values, String toDouble)
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

}
