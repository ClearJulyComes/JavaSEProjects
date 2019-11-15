package myjava;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.log4j.Logger;
import java.util.stream.Stream;

/**
 * Класс с методом main().
 */
public class App
{
    private static ArrayList<ThreadMaker> threadList;
    protected static double result = 0.;
    private static Path folderPath;
    private static Path path;
    final static Logger logger = Logger.getLogger(App.class);

    /**
     * Считывает директорию рабочей папки, запускает потоки для чтения файлов и загружает результат в файл
     * @param args массив string
     */
    public static void main( String[] args ){
        try{
            if(args.length > 1){
                throw new NumberFormatException("Введите один параметр");
            }
            reader(args[0]);

            threadOpener();

            threadsEndWaiter();

            outputLoad();
            System.out.println(result);
        }catch (NoSuchElementException | IllegalStateException | InterruptedException |
                InvalidPathException | SecurityException | IOException | ArrayIndexOutOfBoundsException e){
            logger.warn("Обнаружена ошибка. Приложение будет остановлено." + e);
        }catch (NumberFormatException e){
            logger.warn(e);
        }
    }

    /**
     * Сканнером считывает директорию рабочей папки
     * @param string  строка с дирикторией рабочей папки
     */
    public static void reader(String string) throws InvalidPathException, SecurityException, NullPointerException {
         folderPath = Paths.get(string);
         if(!Files.exists(folderPath, LinkOption.NOFOLLOW_LINKS)){
            throw new NullPointerException("Такой папки не существует");
         }
    }

    /**
     * Запускает отдельный поток для считывания каждого из файлов и передает в него некоторые параметры
     */
    public static void threadOpener() throws IOException {
        threadList = new ArrayList<>();
        Stream<Path> filesList = Files.list(folderPath);
        path = folderPath.resolve("out.dat");
        for(Iterator<Path> iterator = filesList.iterator(); iterator.hasNext();){
            Path myPath = iterator.next();
            if(myPath.getFileName().toString().matches("in_\\d+?\\.dat")){
                ThreadMaker thread = new ThreadMaker(myPath);
                thread.start();
                threadList.add(thread);
            }
        }
    }

    /**
     * Ждет пока завершаться все побочные потоки
     * @throws InterruptedException может появиться ошибка
     */
    public static void threadsEndWaiter() throws InterruptedException {
        for (ThreadMaker myThread : threadList) {
            myThread.join();
        }
    }

    /**
     * Запуск потока для записи результата в файл
     */
    public static void outputLoad(){
        OutputLoader outputLoader = new OutputLoader();
        outputLoader.start();
    }

    /**
     * Геттер для folderPath
     * @return folderPath
     */
    public static Path getPath() {
        return path;
    }

    /**
     * Геттер для result
     * @return result
     */
    public synchronized static double getResult() {
        return result;
    }

    /**
     * Модифицированный сеттер для result
     * @param result величина увеличения приватной переменной result
     */
    public synchronized void setResult(double result) {
        App.result = App.getResult() + result;
    }

}
