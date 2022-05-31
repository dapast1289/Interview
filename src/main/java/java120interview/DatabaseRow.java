package java120interview;

import java.util.HashMap;
import java.util.Map;

public class DatabaseRow {

    Map<Column<?>, Object> map = new HashMap<>();

    public <T> boolean add(Column<T> column, T value){
        map.put(column, value);
        return true;
    }

    public <T> T get(Column<T> column){
        Object o = map.get(column);
        return column.getType().cast(o);
    }
}
