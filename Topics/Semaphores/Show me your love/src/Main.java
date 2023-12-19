import java.util.concurrent.*;

class Mouth {
    //declare your attributes here

    private final Semaphore semaphore1;
    private final Semaphore semaphore2;

    public Mouth() throws InterruptedException {
        semaphore1 = new Semaphore(1);
        semaphore2 = new Semaphore(1);
        semaphore1.acquire();
        semaphore2.acquire();

        //init your attributes here
    }

    // Update the method
    public void first() throws InterruptedException {
        System.out.print("I "); // Do not change or remove this line
        semaphore1.release();
    }

    // Update the method
    public void second() throws InterruptedException {
        semaphore1.acquire();
        System.out.print("love ");
       semaphore2.release();
        // Do not change or remove this line
    }

    // Update the method
    public void third() throws InterruptedException {
        semaphore2.acquire();
        System.out.print("programming!"); // Do not change or remove this line
    }
}