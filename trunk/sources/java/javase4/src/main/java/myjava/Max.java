package myjava;

/**
 * Класс функции max
 */
public class Max implements Equalution {
    private String first;
    private String second;

    /**
     * Конструктор
     * @param first строка содержащая первый параметр в виде константы
     * @param second строка содержащая второй параметр в виде константы
     */
    public Max(String first, String second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Выполняет сравнение двух чисел
     * @return наибольшее число
     */
    @Override
    public int calc(){
        return Math.max(Integer.parseInt(first), Integer.parseInt(second));
    }
}
