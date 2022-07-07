import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class Stegosaurus {

}
interface EggLayer<T extends EggLayer<T>> {
    public Egg<T> lay();
}
class Egg<T extends EggLayer<T>> {
    public Egg(Supplier<T> supplier) {
    }

    public T hatch() {
        return null;
    }
}