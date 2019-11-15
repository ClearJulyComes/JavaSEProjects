package myjava;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Класс побочного потока для работы с файлами
 */
public class ThreadMaker extends Thread {

    private Path path;
    private int typeInt;
    private String line = "";
    final static Logger logger = Logger.getLogger(ThreadMaker.class);

    /**
     * Метод запускающийся при создании потока
     */
    @Override
    public void run() {

        try(FileChannel channel = (FileChannel) Files.newByteChannel(path)){

            inputLoad(channel);

            Operations operations = createObject();

            operations.count();
        }catch (IOException | NullPointerException e){
            logger.warn("IO Exc. Обнаружена ошибка." + e);
        }catch (NumberFormatException e){
            logger.warn("Неправильно оформлен файл." + e);
        } catch (Exception e) {
            logger.warn(e);
        }
    }

    /**
     * Конструктор
     * @param path путь
     */
    public ThreadMaker(Path path) {
        this.path = path;
    }

    /**
     * Считывает данные с файла. Определяет тип операции по первой строке и записывает числа с плавающей
     * точкой в массив чаров
     * @param channel канал для работы с файлом
     * @throws IOException может возникнуть ошибка
     */
    private void inputLoad(FileChannel channel) throws IOException {
        MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
        CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer);
        char bufferChar;
        if(channel.size() > 100000){
            throw new IOException("Слишком большой файл");
        }
        char[] chars = new char[(int) channel.size()];
        for(int i = 0; i < channel.size(); i++){
            bufferChar = charBuffer.get();
            chars[i] = bufferChar;
        }
        String[] analyse = String.valueOf(chars).split("\n");

        getType(analyse);
    }

    /**
     * Парсит тип операции в int. Парсит массив чаров с числами с плавающей точкой в строку.
     * @param analyse string array
     */
    private void getType(String[] analyse) throws IndexOutOfBoundsException, NumberFormatException{
        if(analyse.length>2){
            for(int i = 2; i<analyse.length; i++){
                analyse[i] = analyse[i].trim();
                if(!analyse[i].isEmpty()){
                    throw new NumberFormatException();
                }
            }
        }
        this.setTypeInt(Integer.parseInt(analyse[0].trim()));
        this.line = analyse[1];
    }

    /**
     * Создает объект класса Add/Mult/Quad в зависимости от типа операции.
     * @return объект интерфейса с ссылкой на объект Add/Mult/Quad
     */
    private Operations createObject() throws Exception{
        Operations operations;
        switch (this.typeInt){
            case 1: operations = new Add(this.line);
                break;
            case 2: operations = new Mult(this.line);
                break;
            case 3: operations = new Quad(this.line);
                break;
            default: throw new Exception();
        }
        return operations;
    }

    /**
     * Сеттер для typeInt
     * @param typeInt сохраняет в приватном поле
     */
    public void setTypeInt(int typeInt) {
        this.typeInt = typeInt;
    }

}
