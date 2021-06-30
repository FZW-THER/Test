/**
 * @项目名: Test
 * @类名: SynchronizedLock
 * @Author acer
 * @创建时间: 2021/6/9 15:20
 * @描述: 对象锁示例1，代码块形式
 */
public class SynchronizedLock implements Runnable{

    static SynchronizedLock instance = new SynchronizedLock();

    Object object1 = new Object();
    Object object2 = new Object();

    @Override
    public void run() {
        synchronized (object1) {
            System.out.println("我是对象锁代码形式块lock1，我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "lock1部分运行结束。");
      }

        synchronized (object2) {
            System.out.println("我是对象锁代码形式块lock2，我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "lock2部分运行结束。");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }
}