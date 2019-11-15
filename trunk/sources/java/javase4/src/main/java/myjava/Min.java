package myjava;

/**
 * Класс функции min
 */
public class Min implements Equalution {
    private String first;
    private String second;

    /**
     * Конструктор
     * @param first строка содержащая первый параметр в виде константы
     * @param second строка содержащая второй параметр в виде константы
     */
    public Min(String first, String second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Выполняет сравнение двух чисел
     * @return наименьшее из них
     */
    @Override
    public int calc(){
        return Math.min(Integer.parseInt(first), Integer.parseInt(second));
    }
}
