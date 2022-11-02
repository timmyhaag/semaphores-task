import java.util.*;
import java.util.concurrent.Semaphore;

public class Main {
    private volatile static Semaphore door;
    private volatile static Semaphore nap;
    private volatile static Semaphore servicing;

    public static void main(String[] args) {
        door = new Semaphore(15, true);
        nap = new Semaphore(0, true);
        servicing = new Semaphore(0, true);

        Scanner input = new Scanner(System.in);
        ThreadGroup rushHour = new ThreadGroup("Rush Hour");
        ThreadGroup slowTime = new ThreadGroup("Slow Time");

        System.out.print("Press \"enter\" to start rush hour simulation.");
        input.nextLine();

        Waiter waiterThread = new Waiter(nap, servicing);
        waiterThread.start();
        Customer[] customerThread = new Customer[100];

        for (int i = 0; i < 100; i++) {
            if (i < 50) {
                customerThread[i] = new Customer(nap, servicing, door, rushHour, i);
            }
            else {
                customerThread[i] = new Customer(nap, servicing, door, slowTime, i);
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < 50; i++) {
            customerThread[i].start();
        }

        while (rushHour.activeCount() > 0) {

        }

        System.out.print("\nPress \"enter\" to start slow time simulation.");
        input.nextLine();

        for (int i = 50; i < 100; i++) {
            customerThread[i].start();
            try {
                Thread.sleep((int)(Math.random() * 450) + 50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        while (slowTime.activeCount() > 0) {

        }

        System.out.println("\nDone");
        System.exit(0);
    }
}
