package ru.example.java_se_1;
import java.util.Scanner;

/**
 * Class for store
 */
public class Store {
	public int getRandVar() {
		return randVar;
	}

	/**
	 * Getter for n
	 * @return n
	 */
	public int getN() {
		return n;
	}

	/**
	 * Setter for n
	 * @param n will be saved at private field
	 */
	public void setN(int n) {
		this.n = n;
	}

	/**
	 * Getter for k
	 * @return k
	 */
	public int getK() {
		return k;
	}

	/**
	 * Setter for k
	 * @param k will be saved at private field
	 */
	public void setK(int k) {
		this.k = k;
	}

	/**
	 * Getter for scanner
	 * @return scan
	 */
	public Scanner getScan() {
		return scan;
	}

	/**
	 * Getter for r
	 * @return r
	 */
	public boolean isR() {
		return r;
	}

	/**
	 * Setter for r
	 * @param r will be saved at private field
	 */
	public void setR(boolean r) {
		this.r = r;
	}

	/**
	 * Getter for line
	 * @return line
	 */
	public String getLine() {
		return line;
	}

	/**
	 * Setter for line
	 * @param line will be saved at private field
	 */
	void setLine(String line) {
		this.line = line;
	}

	private int randVar;
	private int n;
	private int k;
	private Scanner scan;
	private boolean r;
	private String line;

	/**
	 * Constructor which uses in chooser()
	 * @param randVar random variable from [1;n]
	 * @param n range for guessing
	 * @param k number of tries
	 * @param scan scanner for reading numbers
	 */
	public Store(int randVar, int n, int k, Scanner scan) {
		this.randVar = randVar;
		this.k = k;
		this.n = n;
		this.scan = scan;
	}

	/**
	 * Constructor which uses in getInteger() and parse()
	 * @param n range for guessing
	 * @param line input string for parsing
	 * @param r indicator
	 */
	public Store(int n, String line, boolean r) {
		this.n = n;
		this.line = line;
		this.r = r;
	}
}
