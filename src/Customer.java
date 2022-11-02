import java.util.concurrent.Semaphore;

public class Customer extends Thread {
    private volatile Semaphore door;
    private volatile Semaphore nap;
    private volatile Semaphore servicing;
    private ThreadGroup group;
    private int num;

    public Customer(Semaphore newNap, Semaphore newServicing, Semaphore newDoor, ThreadGroup newGroup, int newNum) {
        super(newGroup, "customer");
        nap = newNap;
        servicing = newServicing;
        door = newDoor;
        num = newNum;
    }

    @Override
    public void run() {
        try {
            System.out.println("New Customer attempting to enter restaurant");
            door.acquire();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Customer " + num + " has entered restaurant and is seated");
        System.out.println("Customer " + num + " is waiting for the waiter");
        nap.release();

        if (!servicing.tryAcquire()) {
            try {
                servicing.acquire();

                System.out.println("Waiter is servicing customer " + num);
                System.out.println("Customer " + num + " has been served");
                System.out.println("Customer " + num + " is leaving");
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        door.release();
    }
}
