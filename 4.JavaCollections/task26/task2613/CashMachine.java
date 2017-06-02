package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by Miha on 18.05.2017.
 */
public class CashMachine {

    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources";

    public static void main(String[] args) {

        try
        {
            Locale.setDefault(Locale.ENGLISH);
            Operation operation = null;
            do
            {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            }
            while (!operation.equals(Operation.EXIT));
        } catch (InterruptOperationException e){
            ConsoleHelper.writeMessage("GoodBye");
        }
    }
}
