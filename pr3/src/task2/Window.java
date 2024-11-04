package task2;

public class Window {
    private boolean isBusy = false;
    private final int windowNumber;

    public Window(int windowNumber) {
        this.windowNumber = windowNumber;
    }

    public synchronized boolean service(Person person) {
        if (isBusy) {
            return false; // Окно занято
        }

        // Проверка категории
        if (!canServe(person.getCategory())) {
            return false; // Неверная категория
        }

        isBusy = true;
        System.out.println(person.getCategory() + " обслуживается в окне " + windowNumber + ".");

        // Симуляция обслуживания
        try {
            Thread.sleep(1000); // Задержка на обслуживание
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            isBusy = false; // Освобождение окна
        }

        return true;
    }

    private boolean canServe(String category) {
        // Окно 1 принимает все категории
        if (windowNumber == 1) return true;
        // Окно 2 принимает только пожилых
        if (windowNumber == 2) return "пожилой".equals(category);
        // Окно 3 принимает только бизнесменов
        if (windowNumber == 3) return "бизнесмен".equals(category);
        return false;
    }

    public int getWindowNumber() {
        return windowNumber;
    }
}
