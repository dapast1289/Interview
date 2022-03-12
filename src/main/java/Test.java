import java.util.LinkedList;

// fsdfds
public class Test {


    public static void main(String[] args) {
        Test test = new Test();
        boolean getBitResult = test.getBit(16, 4);
        int setBitResult = test.setBit(0, 3);
        int i = 0x0b;
        System.out.println("i: " + i);
        System.out.println("getBit result: "  + getBitResult);
        System.out.println("result: "  + setBitResult);
    }

    public boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0 );
    }

    public int setBit(int num, int i) {
        return num | (1 << i);
    }


}
