package thread;

public class MultithreadingDemo extends Thread {
    @Override
    public void run() {
        System.out.println("My thread is in running state");
    }

    public static void main(String[] args) {
        MultithreadingDemo multithreadingDemo = new MultithreadingDemo();
        multithreadingDemo.start();
    }
}
