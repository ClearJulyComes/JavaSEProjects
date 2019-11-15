package myjava;

/**
 * Класс суммы квадратов
 */
public class Quad implements Operations{

    private String line;

    /**
     * Конструктор
     * @param line строка
     */
    Quad(String line){
        this.line = line;
    }

    /**
     * Переопределенный класс интерфейса Operations. Складывает квадраты чисел с плавающей точкой и записывает
     * через сеттер result
     */
    @Override
    public void count() throws NullPointerException, NumberFormatException{
        double variable;
        double result = 0.;
        App app = new App();
        String[] lineArray = line.split("\\s");
        for(String lines: lineArray){
            variable = Double.parseDouble(lines);
            result = result + Math.pow(variable, 2);
        }
        app.setResult(result);
    }
}
