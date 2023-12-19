class ThreadProcessor {
    public static void findAndStartThread(Thread... threads) throws InterruptedException {
        // implement this method
        Thread r = new Thread();
        for (Thread it : threads) {
            if (it.getState().equals(Thread.State.NEW)) {
                r = it;
                it.start();
                break;
            }


        }
        r.join();
    }
}