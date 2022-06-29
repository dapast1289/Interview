package designPatter.creatinal.abstractFactory.abstractFactory;

import designPatter.creatinal.abstractFactory.bean.Computer;

public class ComputerFactory {

    public static Computer getComputer(ComputerAbstractFactory factory) {
        return factory.createComputer();
    }
}
