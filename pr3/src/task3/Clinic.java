package task3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Clinic {
    private final Queue<Patient> patientQueue = new LinkedList<>();
    private int maxQueueLength = 0;
    private final Object lock = new Object();

    public void addPatient(Patient patient) {
        synchronized (lock) {
            patientQueue.offer(patient);
            maxQueueLength = Math.max(maxQueueLength, patientQueue.size());
            System.out.println("Пациент " + patient.id() + " добавлен в очередь. Длина очереди: " + patientQueue.size());
            lock.notifyAll();
        }
    }

    public void servePatients() {
        while (true) {
            Patient patient;
            synchronized (lock) {
                while (patientQueue.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                patient = patientQueue.poll();
            }
            serveTherapist(patient);
            serveMRT(patient);
        }
    }

    private void serveTherapist(Patient patient) {
        System.out.println("Пациент " + patient.id() + " принимает терапевта.");
        try {
            TimeUnit.SECONDS.sleep(2); // Симуляция времени осмотра
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void serveMRT(Patient patient) {
        System.out.println("Пациент " + patient.id() + " направляется на МРТ.");
        try {
            TimeUnit.SECONDS.sleep(3); // Симуляция времени обследования
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int getMaxQueueLength() {
        return maxQueueLength;
    }
}
