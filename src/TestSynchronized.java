public class TestSynchronized implements Runnable{

    static TestSynchronized sychronized = new TestSynchronized();

    static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(sychronized);
        Thread thread2 = new Thread(sychronized);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(a);

    }

    @Override
    public void run() {
        for (int i = 0; i <= 100000; i++) {
            a ++ ;
        }
    }
}
