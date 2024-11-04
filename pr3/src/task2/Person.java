package task2;

import java.util.Random;

public class Person extends Thread {
    private final String category;
    private final Window[] windows;
    private static final int[] leftCount = new int[3]; // 0 - молодой, 1 - пожилой, 2 - бизнесмен

    public Person(String category, Window[] windows) {
        this.category = category;
        this.windows = windows;
    }

    @Override
    public void run() {
        // Попытка выбрать случайное окно
        Window selectedWindow = windows[new Random().nextInt(windows.length)];
        boolean served = selectedWindow.service(this);

        if (!served) {
            System.out.println(category + " ушел(а) от окна " + selectedWindow.getWindowNumber() + ".");
            leftClient(category);
        }
    }

    public String getCategory() {
        return category;
    }

    public static void leftClient(String category) {
        switch (category) {
            case "молодой":
                leftCount[0]++;
                break;
            case "пожилой":
                leftCount[1]++;
                break;
            case "бизнесмен":
                leftCount[2]++;
                break;
        }
    }

    public static int[] getLeftCount() {
        return leftCount;
    }
}
