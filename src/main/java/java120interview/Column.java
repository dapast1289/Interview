package java120interview;

public class Column<T> {
    private Class<T> type;
    private String name;

    public Class<T> getType() {
        return type;

    }

    public Column(String n, Class cls){
        name = n;
        type = cls;
    }
}
