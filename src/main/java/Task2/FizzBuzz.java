package Task2;


import java.util.concurrent.Semaphore;

public class FizzBuzz {
    private int n;
    private int currentNumber = 1;
    private Object monitor = new Object();

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz() {
        synchronized (monitor) {
            while (currentNumber <= n) {
                if (currentNumber % 3 == 0 && currentNumber % 5 != 0) {
                    System.out.print("fizz, ");
                    currentNumber++;
                    monitor.notifyAll();
                } else {
                    waitForNotification();
                }
            }
        }
    }

    public void buzz() {
        synchronized (monitor) {
            while (currentNumber <= n) {
                if (currentNumber % 5 == 0 && currentNumber % 3 != 0) {
                    System.out.print("buzz, ");
                    currentNumber++;
                    monitor.notifyAll();
                } else {
                    waitForNotification();
                }
            }
        }
    }

    public void fizzbuzz() {
        synchronized (monitor) {
            while (currentNumber <= n) {
                if (currentNumber % 3 == 0 && currentNumber % 5 == 0) {
                    System.out.print("fizzbuzz, ");
                    currentNumber++;
                    monitor.notifyAll();
                } else {
                    waitForNotification();
                }
            }
        }
    }

    public void number() {
        synchronized (monitor) {
            while (currentNumber <= n) {
                if (currentNumber % 3 != 0 && currentNumber % 5 != 0) {
                    System.out.print(currentNumber + ", ");
                    currentNumber++;
                    monitor.notifyAll();
                } else {
                    waitForNotification();
                }
            }
        }
    }

    private void waitForNotification() {
        try {
            monitor.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
