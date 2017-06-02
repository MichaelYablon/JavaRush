package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

/**
 * Created by Miha on 18.05.2017.
 */
class ExitCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Do you want to exit? y,n");
        String answer = ConsoleHelper.readString();
        if (answer.toLowerCase().trim().equals("y")){
            ConsoleHelper.writeMessage("GoodBye");
        }

    }


}
