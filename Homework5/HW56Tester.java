//Nicholas Witmer
//CSCD 300-01
//11/20/2014
//Homework 5/6

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


public class HW56Tester 
{
	public static void main(String[] args)
	{
		Hashtable<Character, Double> varibles = new Hashtable<Character, Double>();
		Scanner fin = openInputFile("hw5_input2.txt");
		Scanner fin2 = openInputFile("hw5_input3.txt");
		PrintStream fout = openOutputFile("hw5_output.txt");
		readVaraibles(varibles, fin);
		ArrayList<String> lines = readLines(fin2);
		solveLines(lines, varibles, fout);
	}
	
	public static Scanner openInputFile(String fileName)
	{
		Scanner fileScanner = null;
		File fileHandle;

		try
		{
			fileHandle = new File(fileName);

			fileScanner = new Scanner(fileHandle);
		}
		catch(Exception e)
		{
			System.out.println("File " + fileName + " was not found.");
		}

		return fileScanner;
	}
	
	private static PrintStream openOutputFile(String filename)
	{
		try
		{
			PrintStream fout = new PrintStream(filename);
			return fout;
		}

		catch(Exception e)
		{
			System.out.println ("Open failed for " + filename);
			System.exit(-1);
		}
		return null;
	}
	
	public static void readVaraibles(Hashtable<Character, Double> varibles, Scanner fin)
	{
		while(fin.hasNext())
		{
			Character key = fin.next().charAt(0);
			fin.next();
			Double value = fin.nextDouble();
			varibles.put(key, value);
		}
	}
	
	public static ArrayList<String> readLines(Scanner lines)
	{
		ArrayList<String> expressions = new ArrayList<String>();
		
		while(lines.hasNext())
		{
			expressions.add(lines.nextLine());
		}
		return expressions;
	}
	
	public static void solveLines(ArrayList<String> lines, Hashtable<Character, Double> varibles, PrintStream fout)
	{
		ExpressionEvaluator expression;
	
		for(String line : lines)
		{
			expression = new ExpressionEvaluator(line, varibles);
			expression.solvePostfix();
			System.out.println(expression);
			fout.println(expression);
		}
	}
}
