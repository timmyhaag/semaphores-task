import java.util.concurrent.Semaphore;

public class Waiter extends Thread {
    private volatile Semaphore nap;
    private volatile Semaphore servicing;

    public Waiter(Semaphore newNap, Semaphore newServicing) {
        nap = newNap;
        servicing = newServicing;
    }

    @Override
    public void run() {
        //System.out.println("Waiter is sleeping");
        do {
            if (!nap.tryAcquire()) {
                System.out.println("Waiter is sleeping");
                try {
                    nap.acquire();
                    System.out.println("Waiter is now awake");
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                    //return;
                }
            }
            try {
                Thread.sleep((int)(Math.random() * 450) + 50);
                servicing.release();
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        } while(true);
    }
}
