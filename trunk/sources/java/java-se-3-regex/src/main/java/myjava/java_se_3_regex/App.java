package myjava.java_se_3_regex;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class App 
{
    public static void main( String[] args )
    {
    	String text = "";
    	Scanner scan = new Scanner(System.in);
        try{
        	text = scan.nextLine();
        }catch(IllegalStateException e) {
        	System.out.println(e);
        }catch(NoSuchElementException e) {
        	System.out.println(e);
        }
        String result;
        Pattern patternSite1 = Pattern.compile("www\\..+?\\.com");
        Pattern patternSite2 = Pattern.compile("http://.+?\\.com");
        Pattern patternEmail = Pattern.compile("\\b[^\\s]+?@.+?\\.com\\b");
        result = findSite(text, patternSite1);
        text = findSite(result, patternSite2);
        text = findSite(text, patternEmail);
        
        System.out.println(text);
        try {
        	scan.close();
        }catch(IllegalStateException e) {
        	System.out.println(e);
        }
    }

	private static String findSite(String text, Pattern pattern) {
		
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()) {
        	int start=0;
        	int end=0;
        	System.out.println("Find");
        	try{
        		start= matcher.start();
        		end = matcher.end();
        	}catch(IllegalStateException e) {
        		System.out.println(e);
        	}
        	String webAdress="";
        	try{
        		webAdress = text.substring(start, end);
        	}catch(IndexOutOfBoundsException e) {
        		System.out.println(e);
        	}
        	if(!webAdress.contains(" ")) {
	        	text = textmaker(start, end, text);
        	}
        }
		return text;
	}

	private static String textmaker(int start, int end, String text) {
		String helper = makeStars(end-start);
    	String stringBegins="";
    	String stringEnds="";
		try {
			stringBegins = text.substring(0, start);
	    	stringEnds = text.substring(end);
    	}catch(IndexOutOfBoundsException e) {
    		System.out.println(e);
    	}
    	String result = stringBegins + helper + stringEnds;
		return result;
	}

	private static String makeStars(int n) {
		String result = "";
		for(int i=0; i<n; i++) {
			result = result + "*";
		}
		return result;
	}
}
