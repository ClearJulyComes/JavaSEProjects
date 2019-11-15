package myjava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Класс для реализации паттерна Factory
 */
public class Factory {

    /**
     * Сверяет по шаблону  и принимает действие основываясь на типе функции
     * @param lineBuild строка с функцией
     * @return строка с результатом операции calc()
     * @throws PatternSyntaxException исключения
     * @throws IndexOutOfBoundsException исключения
     */
    public String getEqualution(String lineBuild) throws PatternSyntaxException, IndexOutOfBoundsException

    {
        Equalution obj;
        String first;
        String second;
        int i;
        Pattern pattern = Pattern.compile("[maxin]+\\(([maxin0-9\\(\\)\\-,]*)");
        Matcher matcher = pattern.matcher(lineBuild);
        if(lineBuild.matches("[maxin]+\\(([maxin0-9\\(\\)\\-,]*)")) {
            while (matcher.find()) {
                String type = lineBuild.substring(0, lineBuild.indexOf('('));
                i = 0;
                int scoreA = 2;
                int scoreB = 1;
                while(scoreA != scoreB){
                    scoreA = 0;
                    scoreB = 0;
                    i = matcher.group(1).substring(0,matcher.group(1).length()-1).indexOf(',', i+1);
                    char[] params = matcher.group(1).substring(0, i).toCharArray();
                    for(int n = 0; n < i; n++){
                        if(params[n] == ')'){
                            scoreA++;
                        }else if (params[n] == '('){
                            scoreB++;
                        }
                    }
                }
                if (type.equals("max")) {
                    first = matcher.group(1).substring(0, i);
                    second = matcher.group(1).substring(i+1, matcher.group(1).length()-1);
                    first = parseParam(first);
                    second = parseParam(second);
                    obj = new Max(first, second);
                    return String.valueOf(obj.calc());
                } else if (type.equals("min")) {
                    first = matcher.group(1).substring(0, i);
                    second = matcher.group(1).substring(i+1, matcher.group(1).length()-1);
                    first = parseParam(first);
                    second = parseParam(second);
                    obj = new Min(first, second);
                    return String.valueOf(obj.calc());
                } else {
                    System.out.println("Неправильно введена формула: " + type);
                    Runtime.getRuntime().exit(1);
                    return "Nothing";
                }
            }
        }
        if(lineBuild.matches("\\-?\\d+")) {
            try {
                Integer.parseInt(lineBuild);
            } catch (NumberFormatException e) {
                System.out.println("Число за пределами диапазона: " + lineBuild);
                Runtime.getRuntime().exit(1);
            }
            try {
                Integer.parseInt(lineBuild);
            } catch (NumberFormatException e) {
                System.out.println("Число за пределами диапазона: " + lineBuild);
                Runtime.getRuntime().exit(1);
            }
        }
        System.out.println("Неправильно введена формула: " + lineBuild);
        Runtime.getRuntime().exit(1);
        return "Nothing";
    }

    /**
     * Проверяет, константе это или нет. Если не констатта, происходит рекурсия.
     * @param param строка параметр
     * @return вычисленный результат
     */
    public String parseParam(String param){
        try{
            Integer.parseInt(param);
        }catch (NumberFormatException e){
            param = this.getEqualution(param);
        }
        return param;
    }
}