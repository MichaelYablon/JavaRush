package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

/**
 * Created by Miha on 18.05.2017.
 */
class DepositCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException{
        String code = null;
        try {
            code = ConsoleHelper.askCurrencyCode();
            String[] digits = ConsoleHelper.getValidTwoDigits(code);
            CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
            currencyManipulator.addAmount(Integer.parseInt(digits[0]), Integer.parseInt(digits[1]));
        } catch (InterruptOperationException e) {
            e.printStackTrace();
        }

    }
}
