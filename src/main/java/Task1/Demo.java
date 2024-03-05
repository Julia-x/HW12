package Task1;

import java.time.Duration;
import java.time.Instant;

public class Demo {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread timeThread = new Thread(() -> {
            while (true) {
                long currentTime = System.currentTimeMillis();
                long elapsedTime = currentTime - startTime;
                System.out.println("Час, що минув: " + elapsedTime/1000 + " сек");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        timeThread.start();

        Thread messageThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Минуло 5 секунд");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        messageThread.start();
    }
}
