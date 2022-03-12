import java.util.Arrays;

public class Prime {

    public static void main(String[] args) {
        Prime prime = new Prime();
        boolean[] result = prime.sieveOfEratosthenes(17);
        prime.printFlags(result);
    }

    public boolean[] sieveOfEratosthenes(int max) {
        boolean[] flags = new boolean[max + 1];
        int count = 0;

        init(flags);
        int prime = 2;

        while (prime <= Math.sqrt(max)) {
            crossOff(flags, prime);

            prime = getNextPrime(flags, prime);
        }
        return flags;
    }

    private void init(boolean[] flags) {
        Arrays.fill(flags, true);
    }

    public void printFlags(boolean[] flags) {
        for (int i = 0; i < flags.length; i++) {
            System.out.println("flags[" + i + "]: " + flags[i]);
        }
    }

    void crossOff(boolean[] flags, int prime) {
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }

    int getNextPrime(boolean[] flags, int prime) {
        int next = prime + 1;
        while (next < flags.length && !flags[next]) {
            next++;
        }
        return next;
    }

}
