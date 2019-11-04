package myjava.java_se_3_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ByRegEx extends Thread implements Exchanger{

	@Override
	public void run() {
		double time = System.currentTimeMillis();
		App appObj = new App();
		String text = appObj.getText();
        text = findSite(text);
        time = System.currentTimeMillis() - time;
        System.out.println(text + " - by RegEx, time = "+time);
        	
		super.run();
	}

	@Override
	public String findSite(String text) {
		Pattern[] patterns = new Pattern[3];
		patterns[0] = Pattern.compile("\\bwww\\.[^\\s]+?\\.com\\b");
        patterns[1] = Pattern.compile("\\bhttp://[^\\s]+?\\.com\\b");
        patterns[2] = Pattern.compile("\\b[^\\s]+?@[a-z]+?\\.com\\b");
		for(Pattern pattern:patterns) {
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
		        	text = textMaker(start, end, text);
	        	}
	        }
		}
		return text;
	}

	@Override
	public String textMaker(int start, int end, String text) {
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

	public String makeStars(int n) {
		String result = "";
		for(int i=0; i<n; i++) {
			result = result + "*";
		}
		return result;
	}
}
