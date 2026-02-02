package com.telegrambot.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TelegrambotService extends TelegramLongPollingBot  {
	@Value("${telegram.bot.username}")
	private String username; 
	
	@Value("${telegram.bot.token}")
	private String token ; 
	
	
	@Override
	public void onUpdateReceived(Update update) {
		
		if(!update.hasMessage() || !update.getMessage().hasText()) {
			return; 
		}
		
		String text = update.getMessage().getText(); 
		Long chatId = update.getMessage().getChatId(); 
		 
		System.out.println("escribieron en el bot: "+ text);
				
		//se crea un objeto mensaje 
		SendMessage message = new SendMessage(); 
		message.setChatId(chatId);
		message.setText("Gracias por escribirnos");
		
		try{
			//se envia el mensaje 
			execute(message);			
		}catch(TelegramApiException e){
			e.printStackTrace();
		}
	}

	@Override
	public String getBotUsername() {
		return username;
	}
	
	@Override
	public String getBotToken() {
		return token;
	}
}
