package test.thread;

public class RunnableThreadExample implements Runnable{
    public int count = 0;

    @Override
    public void run() {
        System.out.println("RunnableThreadExample starting.");
        try {
            while (count < 5) {
                Thread.sleep(500);
                count++;
            }
        } catch (InterruptedException exc) {
            System.out.println("RunnableThreadExample interrupted.");
        }
        System.out.println("RunnableThreadExample terminating.");
    }

    public static void main(String[] args) {
        RunnableThreadExample instance = new RunnableThreadExample();
        Thread thread = new Thread(instance);
        thread.start();

        /* 等待執行緒(慢慢的)數到5 */
        while (instance.count != 5) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }

}
