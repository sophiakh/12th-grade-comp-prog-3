package dumpbucket;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main 
{
	public static void main(String args[])
	{
		//Warmup
	    long k=2;
	    for (int i=0; i<37; i++)
	    {
	    	k*=2;
	    }
	    
	    System.out.println(k);
	    
	    //http://www.pythonchallenge.com/pc/def/map.html
	    //Exercise 1
	    
	    //http://www.pythonchallenge.com/pc/def/ocr.html
	    //Exercise 2
	    
	    //this specifies what sequence of characters you want to find. 
	    //in this case i'm looking for lowercase letters a through z
	    Pattern pattern = Pattern.compile("[a-z]");
	    
	    //We need to use two strings because the data is so large!
	    String str1 = "first half of the really long string you don't want to look at";
	    
	    String str2 = "second half of the really long string you don't want to look at";
	    
	    //call find to look through our strings
	    find(str1, pattern);
	    find(str2, pattern);
	}
	
	//This function looks for matches inside input that match the 
	//pattern 'pat' and prints out all instances found
	public static void find(String input, Pattern pat)
	{
		// a matcher is an object that matches the elements within 
		//the string with the pattern
		Matcher matcher = pat.matcher(input);
		
		//this boolean turns true if you find what you're looking for
		boolean matchFound = matcher.find();
		
		//keep looking as long as we keep finding more matches
		while (matchFound)
		{
			//print out each match and look for the next one
			System.out.println(matcher.group());
			matchFound =  matcher.find();
		}
	}
}
