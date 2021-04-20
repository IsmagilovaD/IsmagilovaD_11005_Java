import java.io.IOException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.util.Arrays;
import java.util.HashMap;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Bot extends TelegramLongPollingBot {

    private HashMap<String, Method> commands;

    public Bot() {
        commands = new HashMap<>();

        for (Method m : BotCommands.class.getDeclaredMethods()) {
            if (!m.isAnnotationPresent(Commands.class))
                continue;

            Commands cmd = m.getAnnotation(Commands.class);
            for (String name : cmd.aliases())
                commands.put(name, m);
        }
    }

    private static final String PORT = System.getenv("PORT");

    @SneakyThrows
    public void run() throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new Bot());

        try (ServerSocket serverSocket = new ServerSocket(Integer.parseInt(PORT))) {
            while (true) {
                serverSocket.accept();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "BassTears_bot";
    }

    @Override
    public String getBotToken() {
        return "1657136759:AAFY6O1pCUcufHMKLSZqynQPgqZpBuEF8AI";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage())
            return;

        Message message = update.getMessage();
        String chatId = String.valueOf(message.getChatId());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        String text = message.getText();

        String[] splitted = text.split(" ");
        String command = splitted[0].toLowerCase();
        String[] args = Arrays.copyOfRange(splitted, 1, splitted.length);

        Method m = commands.get(command);
        if (m != null) {
            try {
                sendMessage.setText((String) m.invoke(new BotCommands(), (Object) args));
            } catch (Exception e) {
                sendMessage.setText("Something went wrong, try again");
            }
        } else {
            sendMessage.setText("I don't know this command");
        }

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}