package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Miha on 01.05.2017.
 */
public class BotClient extends Client {

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
           sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {

            ConsoleHelper.writeMessage (message);

            if (!message.contains (":"))
                return;
            String userName = message.substring (0, message.indexOf (":"));
            String text = message.substring (message.indexOf (":") + 2);
            switch (text) {
                case "дата":
                    sendTextMessage (String.format ("Информация для %s: %s", userName, new SimpleDateFormat ("d.MM.YYYY").format (Calendar.getInstance ( ).getTime ( ))));
                    break;
                case "день":
                    sendTextMessage (String.format ("Информация для %s: %s", userName, new SimpleDateFormat ("d").format (Calendar.getInstance ( ).getTime ( ))));
                    break;
                case "месяц":
                    sendTextMessage (String.format ("Информация для %s: %s", userName,new SimpleDateFormat ("MMMM").format (Calendar.getInstance ( ).getTime ( ))));
                    break;
                case "год":
                    sendTextMessage (String.format ("Информация для %s: %s", userName, new SimpleDateFormat ("YYYY").format (Calendar.getInstance ( ).getTime ( ))));
                    break;
                case "время":
                    sendTextMessage (String.format ("Информация для %s: %s", userName,new SimpleDateFormat ("H:mm:ss").format (Calendar.getInstance ( ).getTime ( ))));
                    break;
                case "час":
                    sendTextMessage (String.format ("Информация для %s: %s", userName,new SimpleDateFormat ("H").format (Calendar.getInstance ( ).getTime ( ))));
                    break;
                case "минуты":
                    sendTextMessage (String.format ("Информация для %s: %s", userName,new SimpleDateFormat ("m").format (Calendar.getInstance ( ).getTime ( ))));
                    break;
                case "секунды":
                    sendTextMessage (String.format ("Информация для %s: %s", userName, new SimpleDateFormat("s").format (Calendar.getInstance ( ).getTime ( ))));
                    break;

            }
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
