package leetcode;

public class L2325 {
    public String decodeMessage(String key, String message) {
        char[] subtitution = new char[26];

        int i = 0;
        for (char c : key.toCharArray()) {
            if (c == ' ') continue;
            if (subtitution[c - 'a'] == (char) 0) {
                subtitution[c - 'a'] = (char)((int)'a' + i);
                i++;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                builder.append(" ");
            } else {
                builder.append(subtitution[c - 'a']);
            }
        }
        return builder.toString();
    }
}
