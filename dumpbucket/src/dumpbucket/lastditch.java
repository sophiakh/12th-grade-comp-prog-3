package dumpbucket;

import java.io.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lastditch 
{
	public static void main(String[] args) throws Exception
	{
		String urlString = "http://www.pythonchallenge.com/pc/def/linkedlist.php?nothing=82682";
	    
	    //Create the URL
	    URL url = new URL(urlString);

	    // open the url stream, wrap it an a few "readers"

	    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	    
	    Pattern pattern4 = Pattern.compile("and the next nothing is (\\d+)");

	    // write the output to print
	    String line;
	    String nums;
	    
	    while ((line = reader.readLine()) != null)
	    {
	    	System.out.println(line);
	    	nums = find2(line, pattern4);
	    	
	    	if(nums == "none")
	    	{
	    		System.out.println("NONE FOUND!");
	    		break;
	    	}

	    	//System.out.println(nums);
	    	String nURLString = urlString.substring(0, 61) + nums;
	    	//System.out.println(nURLString);
	    	URL nURL = new URL(nURLString);
	    	reader = new BufferedReader(new InputStreamReader(nURL.openStream()));
	    }
	    
	    // close our reader
	    reader.close();
	}
	
	public static String find2(String input, Pattern pat)
    {
    	String result = "none";
    	//a matcher is an object that matches the elements within the string with the pattern
        Matcher matcher = pat.matcher(input);
        //this boolean turns true if you find what you're looking for
        boolean matchFound = matcher.find();
        //keep looking as long as we keep finding more matches
        while (matchFound) {
          //print out each match and look for the next one
          result = (matcher.group(1));
          matchFound = matcher.find();
        } 
        return result;
    }
}
