package myjava;

/**
 * Класс умножения
 */
public class Mult implements Operations{

    private String line;

    /**
     * Конструктор
     * @param line строка
     */
    Mult(String line){
        this.line = line;
    }

    /**
     * Переопределенный метод интерфейса Operations. Перемножает числа с плавающей точкой
     */
    @Override
    public void count() throws NullPointerException, NumberFormatException{
        double variable;
        double result = 1.;
        App app = new App();
        String[] lineArray = line.split("\\s");
        for(String lines: lineArray){
            variable = Double.parseDouble(lines);
            result = result * variable;
        }
        app.setResult(result);
    }
}
