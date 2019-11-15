package myjava;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/**
 * Класс побочного потока, для записи результата операций в файл
 */
public class OutputLoader extends Thread {

    final static Logger logger = Logger.getLogger(OutputLoader.class);

    /**
     * Запускается при создании потока. Записывает результат операций в файл, если он не существует, то создает новый
     */
    @Override
    public void run() {
        try(FileChannel channel = (FileChannel) Files.newByteChannel(App.getPath(), StandardOpenOption.WRITE,
                StandardOpenOption.READ, StandardOpenOption.CREATE)){
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 10000);
            char[] chars = String.valueOf(App.getResult()).toCharArray();
            for (char charVar: chars){
                buffer.put((byte) charVar);
            }

        }catch (IOException e){
            logger.warn("IO error. Не удалось сохранить результат в файл" + e);
            Runtime.getRuntime().exit(1);
        }
    }
}
