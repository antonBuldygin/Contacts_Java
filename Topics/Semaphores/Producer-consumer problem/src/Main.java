import java.util.concurrent.Semaphore;

class Buffer {
    // the data stored in Buffer. Do not change or remove this line.
    private char data;
    Semaphore semaphore1;
    Semaphore semaphore2;
    {
        semaphore1= new Semaphore(0);
        semaphore2 = new Semaphore(1);

    }
    //init your attributes here

    // to get data from Buffer
    public void get() throws InterruptedException {
        //complete this method
semaphore1.acquire();
        // consumer consuming data, do not change or remove this line
        System.out.println("Consumer consumed data : " + data);
        semaphore2.release();
    }

    // to put data in buffer
    public void put(char data) throws InterruptedException {
        //complete this method

        // producer producing an data, do not change or remove this lines
        semaphore2.acquire();
        this.data = data;
        System.out.println("Producer produced data : " + data);

        semaphore1.release(1);
    }
}