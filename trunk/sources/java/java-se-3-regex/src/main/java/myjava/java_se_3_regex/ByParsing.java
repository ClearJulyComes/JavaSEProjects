package myjava.java_se_3_regex;

public class ByParsing extends Thread implements Exchanger{

	public static int startNum, endNum;
	public static char[] chars;

	@Override
	public void run() {
		double time = System.currentTimeMillis();
		App appObj = new App();
		String text = appObj.getText();
		text = findSite(text);
		time = System.currentTimeMillis() - time;
		System.out.println(text + " - by parsing, time = "+ time);
		super.run();
	}

	public ByParsing (int startNum, int endNum, char[] chars){
		this.startNum = startNum;
		this.endNum = endNum;
		this.chars = chars;
	}

	public ByParsing(){

	}

	@Override
	public String findSite(String text) {
		int i = 0;
		int n = 0;
		char[] charArray = text.toCharArray();
		ByParsing myObj = new ByParsing(i,n,charArray);
		for(i=0; i<charArray.length;i++) {
			myObj.startNum = i;
			myObj.endNum = n;
			myObj.chars = charArray;
			myObj = checker(myObj);
			i = myObj.startNum;
			n = myObj.endNum;
			charArray = myObj.chars;
		}
		text = String.valueOf(charArray);
		return text;
	}

	private ByParsing checker(ByParsing myObj) {
		int i = myObj.startNum;
		int n = myObj.endNum;
		char[] charArray = myObj.chars;

		try {
			if (charArray[i] == ' ') {
				myObj.startNum = i;
				myObj.endNum = n;
				myObj.chars = charArray;
				myObj = spaceFinded(myObj);
				i = myObj.startNum;
				n = myObj.endNum;
				charArray = myObj.chars;
			} else if (i == 0) {
				myObj.startNum = i;
				myObj.endNum = n;
				myObj.chars = charArray;
				myObj = firstWord(myObj);
				i = myObj.startNum;
				n = myObj.endNum;
				charArray = myObj.chars;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		myObj.startNum = i;
		myObj.endNum = n;
		myObj.chars = charArray;
		return myObj;
	}

	private ByParsing firstWord(ByParsing myObj) {
		int i = myObj.startNum;
		int n = myObj.endNum;
		char[] charArray = myObj.chars;

		if ((charArray[i] == 'w') && (charArray[i + 1] == 'w')
				&& (charArray[i + 2] == 'w') && (charArray[i + 3] == '.')&&
				(Character.isLetter(charArray[i+4]))) {
			n = i + 5;
			myObj.startNum = i;
			myObj.endNum = n;
			myObj.chars = charArray;
			myObj = findCom(myObj);
			i = myObj.startNum;
			n = myObj.endNum;
			charArray = myObj.chars;
		} else if ((charArray[i] == 'h') && (charArray[i + 1] == 't')
				&& (charArray[i + 2] == 't') && (charArray[i + 3] == 'p') &&
				(charArray[i + 4] == ':') && (charArray[i + 5] == '/') &&
				(charArray[i + 6] == '/')&&
				(Character.isLetter(charArray[i+7]))) {
			n = i + 8;
			myObj.startNum = i;
			myObj.endNum = n;
			myObj.chars = charArray;
			myObj = findCom(myObj);
			i = myObj.startNum;
			n = myObj.endNum;
			charArray = myObj.chars;
		} else if ((charArray[i] != ' ')&&(charArray[i]!='@')) {
			for (n = i; n < charArray.length; n++) {
				if ((charArray[n] == '@')&&(Character.isLetter(charArray[n+1]))) {
					myObj.startNum = i;
					myObj.endNum = n+1;
					myObj.chars = charArray;
					myObj = findCom(myObj);
					i = myObj.startNum;
					n = myObj.endNum;
					charArray = myObj.chars;
					break;
				} else if (charArray[n] == ' ') {
					i = n-1;
					break;
				}
			}
		}else if ((charArray[i] == 'h') && (charArray[i + 1] == 't')
				&& (charArray[i + 2] == 't') && (charArray[i + 3] == 'p') &&
				(charArray[i + 4] == ':') && (charArray[i + 5] == '/') &&
				(charArray[i + 6] == '/')&&
				(Character.isLetter(charArray[i+7]))) {
			n = i + 9;
			myObj.startNum = i + 1;
			myObj.endNum = n;
			myObj.chars = charArray;
			myObj = findCom(myObj);
			i = myObj.startNum;
			n = myObj.endNum;
			charArray = myObj.chars;
		}
		myObj.startNum = i;
		myObj.endNum = n;
		myObj.chars = charArray;
		return myObj;
	}

	private ByParsing spaceFinded(ByParsing myObj) {
		int i = myObj.startNum;
		int n = myObj.endNum;
		char[] charArray = myObj.chars;
		if ((charArray[i + 1] == 'w') && (charArray[i + 2] == 'w')
				&& (charArray[i + 3] == 'w') && (charArray[i + 4] == '.')&&
				(Character.isLetter(charArray[i+5]))) {
			n = i + 6;
			myObj.startNum = i + 1;
			myObj.endNum = n;
			myObj.chars = charArray;
			myObj = findCom(myObj);
			i = myObj.startNum;
			n = myObj.endNum;
			charArray = myObj.chars;
		} else if ((charArray[i + 1] == 'h') && (charArray[i + 2] == 't')
				&& (charArray[i + 3] == 't') && (charArray[i + 4] == 'p') &&
				(charArray[i + 5] == ':') && (charArray[i + 6] == '/') &&
				(charArray[i + 7] == '/')&&
				(Character.isLetter(charArray[i+8]))) {
			n = i + 9;
			myObj.startNum = i + 1;
			myObj.endNum = n;
			myObj.chars = charArray;
			myObj = findCom(myObj);
			i = myObj.startNum;
			n = myObj.endNum;
			charArray = myObj.chars;
		} else if ((charArray[i + 1] != ' ')&&(charArray[i+1]!='@')) {
			for (n = i + 2; n < charArray.length; n++) {
				if ((charArray[n] == '@')&&(Character.isLetter(charArray[n+1]))) {
					myObj.startNum = i + 1;
					myObj.endNum = n+1;
					myObj.chars = charArray;
					myObj = findCom(myObj);
					i = myObj.startNum;
					n = myObj.endNum;
					charArray = myObj.chars;
					break;
				} else if (charArray[n] == ' ') {
					i = n-1;
					break;
				}
			}
		}
		myObj.startNum = i;
		myObj.endNum = n;
		myObj.chars = charArray;
		return myObj;
	}

	private ByParsing findCom(ByParsing myObj) {
		int i = myObj.startNum;
		int n = myObj.endNum;
		char[] charArray = myObj.chars;
		for(n = n;n<charArray.length;n++){
			try {
				if ((charArray[n] == '.') && (charArray[n + 1] == 'c') &&
						(charArray[n + 2] == 'o') && (charArray[n + 3] == 'm') &&
						((n + 4) == charArray.length)) {
					String text = String.valueOf(charArray);
					text = textMaker(i, n + 3, text);
					charArray = text.toCharArray();
					n = n+3;
					i = n;
					break;
				} else if ((charArray[n] == ' ')||((!Character.isLetter(charArray[n]))
						&&(!Character.isDigit(charArray[n])))) {
					if((charArray[n] == '.') && (charArray[n + 1] == 'c') &&
							(charArray[n + 2] == 'o') && (charArray[n + 3] == 'm') &&
							(' ' == charArray[n + 4])) {
						String text = String.valueOf(charArray);
						text = textMaker(i, n + 3, text);
						charArray = text.toCharArray();
						n = n + 3;
						i = n;
						break;
					}else {
						i = n;
						break;
					}
				}
			}catch (ArrayIndexOutOfBoundsException e){
				System.out.println("ArrayIndexOutOfBoundsException");
			}
		}
		myObj.startNum = i;
		myObj.endNum = n;
		myObj.chars = charArray;
		return myObj;
	}

	@Override
	public String textMaker(int start, int end, String text) {
		char[] charArray = text.toCharArray();
		for(start=start;start<(end+1);start++){
			charArray[start] = '*';
		}
		text = String.valueOf(charArray);
		return text;
	}
}
