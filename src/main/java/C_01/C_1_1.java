package C_01;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 *
 * Hints: #44, #7 7 7, #732
 */
public class C_1_1 {
    public static void main(String[] args) {
        C_1_1 c = new C_1_1();
        boolean answer = c.isChartUnique("AaaZz");
        System.out.println("answer: " + answer);
    }

    public boolean isChartUnique(String str) {
        boolean[] check = new boolean[128];
        if (str.length() > 128) {
            return false;
        }
        for (int ch : str.toCharArray()) {
            if (check[ch] == true) {
                return false;
            }
            check[ch] = true;
        }
        return true;
    }
}
