package ru.example.java_se_1;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Main class.
 */
public class App
{	
	/**
	 * Main method where get n and k
	 * @param args string parameters
	 */
    public static void main( String[] args )
    {
    	try (Scanner scan = new Scanner(System.in)) {
			System.out.print("Введите число n: ");
			int n = reader(scan);
			System.out.print("Введите число k: ");
			int k = reader(scan);

			int randVar = 1 + (int) (Math.random() * n);

			System.out.println("Попробуйте угадать чилсо: ");
			Store storeObj = new Store(randVar, n, k, scan);
			System.out.println(chooser(storeObj));
		}catch (NoSuchElementException | IllegalStateException e){
    		System.out.println("Извините, найдена ошибка. Приложение будет закрыто.");
    		Runtime.getRuntime().exit(1);
		}
    }

	/**
	 * Checks selected number for validation and compares random number with selected
	 * @param storeObj Store object
	 * @return returning result of guessing by string
	 */
	private static String chooser(Store storeObj) {

		int chosen;
		for(int i = 0; i < storeObj.getK(); i++) {
			chosen = reader(storeObj.getScan());
			if( ( chosen > storeObj.getN() ) || ( chosen < 1) ) {
				System.out.println("Выбраное число вне диапазона [1,n]");
				i--;
			}else {
				if( storeObj.getRandVar() > chosen ) {
					System.out.println("Загаданное чило больше");
				}else if( storeObj.getRandVar() < chosen ) {
					System.out.println("Загаданное чило меньше");
				}else {
					return "Вы угадали";
				}
			}
		}
		return "Попытки закончились";
	}

    /**
     * Gets guessing number
     * @param scan scanner
     * @return n number that was successfully input
     */
	private static int reader(Scanner scan) {
		Store store = new Store(0, " ",true);
		while( store.isR() ) {
			store.setR(false);
		    store.setLine(scan.nextLine());
		    store = getInteger(store);
		}
		
		return store.getN();
	}
	
	/**
	 * Gets integer from the string in Store object and checks for validation
	 * @param store Store object
	 * @return Store object with changed number n and indicator r
	 */
	private static Store getInteger(Store store) {
		store.setLine(store.getLine().trim());
        	store = parse(store);
		return store;
	}

	/**
	 * Checks n, k in Store object for validation
	 * @param store Store object
	 * @return Store object with changed n and indicator r
	 */
	private static Store parse(Store store) {
		try {
	        store.setN(Integer.parseInt(store.getLine()));
	        if( store.getN() <= 0 ) {
				store.setR(true);
				System.out.println("Введите число > 0");
			}
        }catch (NumberFormatException e) {
        	System.out.println("Введите одно  целое число");
        	store.setR(true);
        }
		return store;
	}
}
