package leetcode;

import java.util.LinkedList;

public class L567 {

    public static void main(String[] args) {
//        String s1 = "abc";
//        String s2 = "ccccbbbbaaaa";
        String s1 = "ab";
        String s2 = "eidbaooo";
        L567 l567 = new L567();
        l567.checkInclusion(s1, s2);
        String s = "A";
        System.out.println(s.getBytes());
        for (byte b : s.getBytes()) {
            System.out.println(b);
        }
        byte[] t = new byte[1];
        t[0] = 65;
        System.out.println(new String(t));
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] letterCount = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letterCount[s1.charAt(i) - 'a'] += 1;
            letterCount[s2.charAt(i) - 'a'] += -1;
        }
        if (isAllZero(letterCount)) {
            return true;
        }
        for (int i = 0, j = s1.length(); j < s2.length(); i++, j++) {
            letterCount[s2.charAt(j) - 'a'] -= 1;
            letterCount[s2.charAt(i) - 'a'] += 1;
        }
        return isAllZero(letterCount);
    }

    public boolean isAllZero(int[] letterCount) {
        for (int count : letterCount) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
