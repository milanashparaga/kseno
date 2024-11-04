package task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(clinic::servePatients);

        // Добавление пациентов в очередь
        for (int i = 1; i <= 10; i++) {
            final int patientId = i;
            executor.submit(() -> clinic.addPatient(new Patient(patientId)));
            try {
                Thread.sleep(500); // Симуляция времени прихода нового пациента
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Максимальная длина очереди: " + clinic.getMaxQueueLength());
    }
}
