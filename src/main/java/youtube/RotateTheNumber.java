package youtube;

public class RotateTheNumber {
    // 16891 -> 16891
    // 0 -> 0, 1 -> 1, 6 -> 9, 8 -> 8, 9 -> 6

    public static void main(String[] args) {
        System.out.println(isValid("16891"));
    }

    public static boolean isValid(String inputStr) {
        char input[] = inputStr.toCharArray();
        char output[] = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            int outputIdx = input.length - 1 - i;
            if (input[i] != '0' && input[i] != '1' && input[i] != '6' && input[i] != '8' && input[i] != '9') {
                return false;
            } else if (input[i] == '6') {
                output[outputIdx] = '9';
            } else if (input[i] == '9') {
                output[outputIdx] = '6';
            } else {
                output[outputIdx] = input[i];
            }
        }

        for (int i = 0; i < input.length; i++) {
            if (input[i] != output[i]) {
                return false;
            }
        }
        return true;
    }
}
