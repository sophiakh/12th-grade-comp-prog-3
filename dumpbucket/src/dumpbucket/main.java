package dumpbucket;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main 
{
	private int grade;
	private double gpa;
	private int id;
	
	public main()
	{
		grade = 11;
		gpa = 4.0;
	}
	
	public main(int id)
	{
		this();
		this.id = id;
	}
	
	public static void main(String[] args)
	{
		main m = new main(70);
		
		System.out.println(m.grade);
		System.out.println(m.gpa);
		System.out.println(m.id);
	}
}
