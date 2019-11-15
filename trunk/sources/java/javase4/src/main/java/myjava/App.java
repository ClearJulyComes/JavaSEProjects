package myjava;


import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

/**
 * Класс с методом main()
 */
public class App {

    /**
     * Основной метод
     * @param args входные параметры
     */
    public static void main(String[] args){
        System.out.println("Введите функцию:");
        try(Scanner scanner = new Scanner(System.in)){
            String line = scanner.nextLine();
            Factory factory = new Factory();
            line = factory.getEqualution(line);

            System.out.println("Ответ: " + line);
        }catch (NoSuchElementException | IllegalStateException | PatternSyntaxException|IndexOutOfBoundsException e){
            System.out.println("Обнаружена ошибка.");
            Runtime.getRuntime().exit(1);
        }
    }

}