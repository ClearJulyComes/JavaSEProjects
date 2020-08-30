package myjava.java_se_3_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ByRegEx {

	private String text;

	public String findSite() {
		text = " " + text + " ";
		System.out.println("findSite");
		Pattern[] patterns = new Pattern[1];
		patterns[0] = Pattern.compile("(\\s|\\t)\\[b](.+)\\[/b](\\s|\\t)");
		/*patterns[1] = Pattern.compile("(\\s|\\t)\\[i](^(\\[i])+?[^\\s\\t])?\\[/i](\\s|\\t)");
		patterns[2] = Pattern.compile("(\\s|\\t)\\[u](^(\\[u])+?[^\\s\\t])?\\[/u](\\s|\\t)");
		patterns[3] = Pattern.compile("(\\s|\\t)\\[s](^(\\[s])+?[^\\s\\t])?\\[/s](\\s|\\t)");
		patterns[4] = Pattern.compile("(\\s|\\t)\\[s].+?\\[/s](\\s|\\t)");
		//patterns[5] = Pattern.compile("(\\s|\\t)\\[color=\"([^\\s\\t]?^(\\[color=\"([^\\s\\t].+?[^\\s\\t])\"])].+?[^\\s\\t])\"]([^\\s\\t(\\[color=\"([^\\s\\t].+?[^\\s\\t])\"])].+?[^\\s\\t])\\[/color](\\s|\\t)");
		patterns[5] = Pattern.compile("(\\s|\\t)\\[url](^(\\[url])+?)\\[/url](\\s|\\t)");
		patterns[6] = Pattern.compile("(\\s|\\t)\\[url=\"([^\\s\\t]+?)\"](.+?)\\[/url](\\s|\\t)");
		patterns[7] = Pattern.compile("(\\s|\\t)\\[size=(\\d+)](.+?)\\[/size](\\s|\\t)b"); */
		//patterns[8] = Pattern.compile("(\\s|\\t)\\[size=\"(\\d+px)\"]([^\\s\\t].+?[^\\s\\t])\\[/size](\\s|\\t)");
		//patterns[9] = Pattern.compile("(\\s|\\t)\\[font=\"(.+?)\"]([^\\s\\t].+?[^\\s\\t])\\[/font](\\s|\\t)");
		for(Pattern pattern:patterns) {
	        Matcher matcher = pattern.matcher(text);
	        while(matcher.find()) {
	        	int start=0;
	        	int end=0;
	        	try{
	        		start= matcher.start();
	        		end = matcher.end();
	        		System.out.println(start+ " " + end);
	        	}catch(IllegalStateException e) {
	        		System.out.println(e);
	        	}
	        	String webAdress="";
	        	try{
	        		webAdress = text.substring(start, end);
	        		System.out.println(webAdress);
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

	public String workBtch(String workingText, int num) {
		workingText = " " + workingText + " ";
		System.out.println("findSite");
		Pattern[] patterns = new Pattern[1];
		patterns[0] = Pattern.compile("(\\s|\\t)\\[b]");
		/*patterns[1] = Pattern.compile("(\\s|\\t)\\[i](^(\\[i])+?[^\\s\\t])?\\[/i](\\s|\\t)");
		patterns[2] = Pattern.compile("(\\s|\\t)\\[u](^(\\[u])+?[^\\s\\t])?\\[/u](\\s|\\t)");
		patterns[3] = Pattern.compile("(\\s|\\t)\\[s](^(\\[s])+?[^\\s\\t])?\\[/s](\\s|\\t)");
		patterns[4] = Pattern.compile("(\\s|\\t)\\[s].+?\\[/s](\\s|\\t)");
		//patterns[5] = Pattern.compile("(\\s|\\t)\\[color=\"([^\\s\\t]?^(\\[color=\"([^\\s\\t].+?[^\\s\\t])\"])].+?[^\\s\\t])\"]([^\\s\\t(\\[color=\"([^\\s\\t].+?[^\\s\\t])\"])].+?[^\\s\\t])\\[/color](\\s|\\t)");
		patterns[5] = Pattern.compile("(\\s|\\t)\\[url](^(\\[url])+?)\\[/url](\\s|\\t)");
		patterns[6] = Pattern.compile("(\\s|\\t)\\[url=\"([^\\s\\t]+?)\"](.+?)\\[/url](\\s|\\t)");
		patterns[7] = Pattern.compile("(\\s|\\t)\\[size=(\\d+)](.+?)\\[/size](\\s|\\t)b"); */
		//patterns[8] = Pattern.compile("(\\s|\\t)\\[size=\"(\\d+px)\"]([^\\s\\t].+?[^\\s\\t])\\[/size](\\s|\\t)");
		//patterns[9] = Pattern.compile("(\\s|\\t)\\[font=\"(.+?)\"]([^\\s\\t].+?[^\\s\\t])\\[/font](\\s|\\t)");

		Matcher matcher = patterns[num].matcher(text);
		while(matcher.find()) {
			ByRegEx helper = new ByRegEx();
			helper.setText(workingText);
		}
		return text;
	}



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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
