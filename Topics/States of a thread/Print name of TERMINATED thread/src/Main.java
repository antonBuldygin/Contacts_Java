class ThreadUtil {
    static void printNameOfTerminatedThread(Thread[] threads) {
        // implement the method
        for(Thread it:threads){
            if(it.getState()==(Thread.State.TERMINATED)){
                System.out.println(it.getName());
                return;
            }
else continue;
        }
    }
}