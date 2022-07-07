import java.util.function.Supplier;

public class Stegosaurus implements EggLayer<Stegosaurus>{

    @Override
    public Egg<Stegosaurus> lay() {
        return new Egg<>(Stegosaurus::new);
    }
    public static void main(String[] args) throws Exception {
        Stegosaurus s1 = new Stegosaurus();
        Egg<Stegosaurus> egg1 = s1.lay();
        Stegosaurus s2 = egg1.hatch();
        Egg<Stegosaurus> egg2 = s2.lay();
        egg2.hatch();
        System.out.println();
    }

}
interface EggLayer<T extends EggLayer<T>> {
    public Egg<T> lay();
}
class Egg<T extends EggLayer<T>> {
    private boolean isHatch = false;
    private final Supplier<T> supplier;
    public Egg(Supplier<T> supplier) {
        this.supplier = supplier;
    }
    public T hatch() throws Exception {
        if (!this.isHatch) {
            isHatch = true;
            return supplier.get();
        } else {
            throw new Exception("");
        }
    }
}