package task1;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

class NumberWriter implements Runnable {
    private final CopyOnWriteArrayList<Integer> listOfNumbers;
    private int numberToWrite = 0;

    public NumberWriter(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    @Override
    public void run() {
        while (true) {
            // Запись в список
            listOfNumbers.add(numberToWrite);
            System.out.println("Записываем: " + numberToWrite);
            numberToWrite++;

            try {
                TimeUnit.MILLISECONDS.sleep(1000); // Задержка 1000 мс
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
