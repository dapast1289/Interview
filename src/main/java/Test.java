import java.util.ArrayList;
import java.util.LinkedList;

// fsdfds
public class Test {

//    2126753390
//1702766719
    private int pick = 1702766719;
    public static void main(String[] args) {
        ArrayList<Integer> f = new ArrayList<>();
        f.add(0); // 1
        f.add(1); // 2
        f.add(1); // 3
        f.add(f.get(2) + f.get(1) + f.get(0)); // 4
        f.add(f.get(3) + f.get(2) + f.get(1)); // 5
        System.out.println();
        Test test = new Test();
        test.guessNumber(2126753390);
    }

    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        int count = 0;
        while (low <= high) {
            count++;
//            int mid = low + (high - low) / 2;
            int mid = (high + low) / 2;
            int res = guess(mid);
            System.out.println("count: " + count + ", n: " + n + ", low: " + low + ", mid: " + mid + ", high: " + high);
            if (res == 1) {
                low = mid + 1;
            } else if (res == -1) {
                high = mid - 1;
            } else {
                return mid;
            }
            if (count > 100) {
                break;
            }
        }
        return -1;
    }

    public int guess(int num) {
        if (num > pick) {
            return -1;
        } else if (num < pick){
            return 1;
        }
        return 0;
    }

}
