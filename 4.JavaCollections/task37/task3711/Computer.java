package com.javarush.task.task37.task3711;

/**
 * Created by Miha on 16.05.2017.
 */
public class Computer {

    private CPU cpu = new CPU();
    private HardDrive hardDrive = new HardDrive();
    private Memory memory = new Memory();

    public void run() {
        cpu.calculate();
        hardDrive.storeData();
        memory.allocate();
    }
}
