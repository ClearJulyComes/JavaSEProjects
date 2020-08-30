package myjava.java_se_3_regex;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class App 
{
    private static String text;

	public static void main( String[] args )
    {
    	Scanner scan = new Scanner(System.in);
    	String textHelper = "";
        try{
        	textHelper = scan.nextLine();
        }catch(IllegalStateException | NoSuchElementException e) {
        	System.out.println(e);
        }
        ByRegEx byRegEx = new ByRegEx();
        byRegEx.setText(textHelper);
        textHelper = byRegEx.findSite();
        System.out.println("Output in App: " + textHelper);
        try {
        	scan.close();
        }catch(IllegalStateException e) {
        	System.out.println(e);
        }
    }
	
	public void setText(String name) {
	       this.text = name;
	   }
	public String getText() {
	       return this.text;
	   }
}
