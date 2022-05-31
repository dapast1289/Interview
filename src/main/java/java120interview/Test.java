package java120interview;

import java.util.TreeSet;

public class Test {

    public static void main(String[] args) {
        Column<String> column = new Column<>("sex", String.class);
        Column<Integer> column2 = new Column<>("code", Integer.class);

        DatabaseRow StudentRecord = new DatabaseRow();
        StudentRecord.add(column, "man");
        StudentRecord.add(column2, 2);
        StudentRecord.add(column, "woman");

        System.out.println(StudentRecord.get(column));//结果输出man

    }
}
