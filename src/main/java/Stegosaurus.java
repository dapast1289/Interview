import java.util.function.Supplier;

public class Stegosaurus<T extends EggLayer<T>> implements EggLayer {

    public Stegosaurus(T t) {

    }
    @Override
    public Egg lay() {
        return null;
    }
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