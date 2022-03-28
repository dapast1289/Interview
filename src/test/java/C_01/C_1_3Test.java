package C_01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class C_1_3Test {

    @Test
    void replaceSpace() {
        char input[] = "Mr John Smith    ".toCharArray();
        int inputTrueLength = 13;
        char output[] = "Mr%20John%20Smith".toCharArray();
        C_1_3 c_1_3 = new C_1_3();
        c_1_3.replaceSpace(input, inputTrueLength);
        String inputStr = input.toString();
        String outputStr = output.toString();
        assertEquals(outputStr, inputStr);
    }
}