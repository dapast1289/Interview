public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        int answer =  f.fibonacci(3);
        System.out.println("answer: " + answer);
    }

    int fibonacci(int i) {
        if (i == 0 || i == 1) return i;
        return fibonacci(i - 1) + fibonacci(i - 2);
    }
}
