package myjava.java_se_3_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ByRegEx extends Thread implements Exchanger{

	@Override
	public void run() {
		
		App appObj = new App();
		String text = appObj.getName();
        String result;
        Pattern patternSite1 = Pattern.compile("www\\..+?\\.com");
        Pattern patternSite2 = Pattern.compile("http://.+?\\.com");
        Pattern patternEmail = Pattern.compile("\\b[^\\s]+?@[a-z]+?\\.com\\b");
        result = findSite(text, patternSite1);
        text = findSite(result, patternSite2);
        text = findSite(text, patternEmail);
        System.out.println(text);
        	
		super.run();
	}

private static String findSite(String text, Pattern pattern) {
		
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()) {
        	int start=0;
        	int end=0;
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
