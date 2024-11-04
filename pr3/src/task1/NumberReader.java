package task1;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

class NumberReader implements Runnable {
    private final CopyOnWriteArrayList<Integer> listOfNumbers;
    private int lastReadIndex = -1;

    public NumberReader(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    @Override
    public void run() {
        while (true) {
            if (lastReadIndex + 1 < listOfNumbers.size()) {
                Integer currentNumber = listOfNumbers.get(lastReadIndex + 1);
                System.out.println("Читаем: " + currentNumber);
                lastReadIndex++;
            } else {
                System.out.println("Список пуст или нет новых чисел.");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(500); // Задержка 500 мс
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
