package designPatter.creatinal.factory.factory;

import designPatter.creatinal.factory.bean.Computer;
import designPatter.creatinal.factory.bean.PC;
import designPatter.creatinal.factory.bean.Server;

public class ComputerFactory {

    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        if ("PC".equalsIgnoreCase(type)) return new PC(ram, hdd, cpu);
        else if ("Server".equalsIgnoreCase(type)) return new Server(ram, hdd, cpu);
        return null;
    }
}
