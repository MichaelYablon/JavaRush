package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Miha on 18.05.2017.
 */
public class ConsoleHelper {

    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String input = "";

            try {
                input = bis.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (input.equalsIgnoreCase("exit")) {
                throw new InterruptOperationException();
            }

        return input;
    }

    public static Operation askOperation() throws InterruptOperationException {
        do {
            writeMessage("Choice operation:\\n1) INFO\\n2) DEPOSIT\\n3) WITHDRAW\\n4) EXIT");
            try {
                String input = readString();
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(input));
            } catch (IllegalArgumentException e) {
                writeMessage("Wrong code. Try again!");
                continue;
            }
        }
        while (true);

    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String code;

        writeMessage("Input currency code:");

        while (true){
            code = readString();
            if(code.matches("\\w{3}")){
                break;
            }else
                writeMessage("Invalid currency code, retry.");
        }

        return code.toUpperCase();

    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String valueAndAmount;
        String[] result;
        writeMessage("Input nominal and amount:");

        while (true) {
            valueAndAmount = readString();
            if (valueAndAmount.matches("\\d+ \\d+")) {
                result = valueAndAmount.split(" ");
                if(result[0].equals("0") || result[1].equals("0")){
                    writeMessage("Invalid nominal and amount, retry.");
                    continue;
                }
                return result;
            } else{
                writeMessage("Invalid nominal and amount, retry.");
            }
        }


    }
}
