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
        }catch(IllegalStateException e) {
        	System.out.println(e);
        }catch(NoSuchElementException e) {
        	System.out.println(e);
        }
        App app = new App();
        app.setText(textHelper);
        ByRegEx stream1 = new ByRegEx();
        stream1.start();
        ByParsing stream2 = new ByParsing();
        stream2.start();
        
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
