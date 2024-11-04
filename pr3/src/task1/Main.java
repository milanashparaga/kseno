package task1;

import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> listOfNumbers = new CopyOnWriteArrayList<>();

        Thread readerThread = new Thread(new NumberReader(listOfNumbers));
        Thread writerThread = new Thread(new NumberWriter(listOfNumbers));

        readerThread.start();
        writerThread.start();

        // Программа будет работать вечно.
    }
}
