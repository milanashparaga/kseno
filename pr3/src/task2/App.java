package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    private static final int NUMBER_OF_PERSONS = 100; // Количество граждан
    private static final String[] CATEGORIES = {"молодой", "пожилой", "бизнесмен"};

    public static void main(String[] args) {
        Window[] windows = new Window[3];
        for (int i = 0; i < 3; i++) {
            windows[i] = new Window(i + 1);
        }

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_PERSONS; i++) {
            String category = CATEGORIES[new Random().nextInt(CATEGORIES.length)];
            persons.add(new Person(category, windows));
        }

        // Запуск потоков
        for (Person person : persons) {
            person.start();
        }

        // Ожидание завершения потоков
        for (Person person : persons) {
            try {
                person.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Подсчет ушедших клиентов
        int[] leftCount = Person.getLeftCount();
        System.out.println("Процент ушедших клиентов:");
        System.out.printf("Молодые: %.2f%%\n", (leftCount[0] / (double) NUMBER_OF_PERSONS) * 100);
        System.out.printf("Пожилые: %.2f%%\n", (leftCount[1] / (double) NUMBER_OF_PERSONS) * 100);
        System.out.printf("Бизнесмены: %.2f%%\n", (leftCount[2] / (double) NUMBER_OF_PERSONS) * 100);
    }
}
