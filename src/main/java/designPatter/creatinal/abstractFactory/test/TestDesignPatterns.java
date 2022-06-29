package designPatter.creatinal.abstractFactory.test;

import designPatter.creatinal.abstractFactory.abstractFactory.ComputerFactory;
import designPatter.creatinal.abstractFactory.abstractFactory.PCFactory;
import designPatter.creatinal.abstractFactory.abstractFactory.ServerFactory;
import designPatter.creatinal.abstractFactory.bean.Computer;

public class TestDesignPatterns {

    public static void main(String[] args) {
        testAbstractFactory();
    }

    private static void testAbstractFactory() {
        Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB", "500 GB", "2.4 GHz"));
        Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB", "1 TB", "2.9 GHz"));
        System.out.println("AbstractFactory PC Config::" + pc);
        System.out.println("AbstractFactory Server Config::" + server);
    }
}
