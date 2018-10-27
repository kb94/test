package telegram.telegram;

import java.lang.StringBuilder.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyAmazingBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
    	// We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
        	String temp="Your message to BOT : "+update.getMessage().getText();
        	//temp = temp.append(System.getProperty("line.separator"));
        	String id="Your chat id with BOT : "+update.getMessage().getChatId();
        	String x = temp+"\n"+id;
        	
            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId())
                    .setText(x);
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
    	return "@kunalbhave_bot";
        
    }

    @Override
    public String getBotToken() {
        // TODO
        return "778488199:AAF2SCXY6BGp9ZQGDkSbyZ8z9Yzt8Tz8rwc";
    }

}