package youtube;

public class ReverseWord {

    public static void main(String[] args) {
//        char input[] = {'p', 'e', 'r', 'f', 'a', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ',
//                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
//        char output[] = {'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', ' ', 'm', 'a', 'k', 'e', 's', ' ',
//                'p', 'e', 'r', 'f', 'a', 'c', 't'};
        char input[] = {'a', ' ' , 'b', ' ', 'c', ' '};
        char output[] = {' ', 'c', ' ', 'b', ' ' , 'a'};
        reverseTheWord(input);
        System.out.println("input: " + input.toString());
        System.out.println("output: " + output.toString());
        // output == input
    }

    public static void reverseTheWord(char[] inputArray) {
        reversWord(inputArray, 0, inputArray.length - 1);
        int frontSingleWordIdx = -1; // -1 means null
        for (int idx = 0; idx < inputArray.length; idx++) {
            // first, find idx that char isn't ' ' to become frontSingleWordIdx
            // second, if frontSingleWordIdx has value, find  tailSingleWordIdx from char is ' ', and tha idx minus 1
            // if frontSingleWordIdx and tailSingleWordIdx have value, go to reverseSingleWord, then clean those two values
            if (inputArray[idx] != ' ' && !isNotNull(frontSingleWordIdx)) {
                frontSingleWordIdx = idx;
            } else if (isNotNull(frontSingleWordIdx)) {
                if (inputArray[idx] == ' ') {
                    reversWord(inputArray, frontSingleWordIdx, idx - 1);
                    frontSingleWordIdx = -1;
                } else if (idx == inputArray.length - 1) {
                    reversWord(inputArray, frontSingleWordIdx, idx);
                    frontSingleWordIdx = -1;
                }
            }
        }
    };

    public static boolean isNotNull(int idx) {
        if (idx == -1) {
            return false;
        }
        return true;
    }

    public static void reversWord(char[] inputArray, int front, int tail) {
        for (; front < tail; front++, tail--) {
            char temp = inputArray[front];
            inputArray[front] = inputArray[tail];
            inputArray[tail] = temp;
        }
    }
}
