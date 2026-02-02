package com.telegrambot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import com.telegrambot.services.TelegrambotService;

@Configuration
public class BotConfig {
    
    @Bean
    public TelegramBotsApi telegramBotsApi(TelegrambotService telegrambotService) 
            throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(telegrambotService);
        return botsApi;
    }
}