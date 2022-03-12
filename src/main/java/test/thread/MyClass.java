package test.thread;

public class MyClass extends Thread {
    private String name;
    private MyObject myObject;

    public MyClass(MyObject obj, String n) {
        name = n;
        myObject = obj;
    }

    @Override
    public void run() {
        if (name.equals("1")) MyObject.foo(name);
        else if (name.equals("2")) MyObject.bar(name);
    }

    public static void main(String[] args) {
        MyObject obj1 = new MyObject();
        MyClass thread1 = new MyClass(obj1, "1");
        MyClass thread2 = new MyClass(obj1, "2");
        thread1.start();
        thread2.start();
    }

}
