public class MyThread extends Thread{

    @Override
    public synchronized void run() {
        try {
            this.wait();
            System.out.println("After wait");
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("Resume");
    }




    ///----main-------
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        Thread.sleep(1000);
        synchronized (t){
            t.notify();
        }
        t.interrupt();
        if (t.isInterrupted()){
            System.out.println("is interrupted");
        }

    }
}
