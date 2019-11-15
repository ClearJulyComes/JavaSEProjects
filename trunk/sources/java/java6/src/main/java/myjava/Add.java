package myjava;

/**
 * Класс сложения
 */
public class Add implements Operations{

    private String line;

    /**
     * Конструктор
     * @param line строка
     */
    Add(String line){
        this.line = line;
    }

    /**
     * Переопределенный метод интерфейса Operations. Складывает числа с плавающей точкой, записывая
     * результат в сеттер result
     */
    @Override
    public void count() throws NullPointerException, NumberFormatException{
        double variable;
        double result = 0.;
        App app = new App();
        String[] lineArray = line.split("\\s");
        for(String lines: lineArray){
            variable = Double.parseDouble(lines);
            result = result + variable;
        }
        app.setResult(result);
    }
}
