//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.function.Supplier;
//
//// fsdfds
//public class Test implements EggLayer {
//
//    @Override
//    public Egg lay() {
//        return new Egg( () -> null);
//    }
//}
//interface EggLayer<T extends EggLayer<T>> {
//    public Egg<T> lay();
//}
//class Egg<T extends EggLayer<T>> {
//    public Egg(Supplier<T> supplier) {
//        supplier.get();
//    }
//
//    public T hatch() {
//        throw new UnsupportedOperationException("You need to implement this method!");
//    }
//}