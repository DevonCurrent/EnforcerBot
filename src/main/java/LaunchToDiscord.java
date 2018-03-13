package main.java;

import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class LaunchToDiscord extends ListenerAdapter {

    public static void main(String [] args){
        AccountCreator accountCreator = new AccountCreator();
        JDA botAccount = accountCreator.createBotAccount();
        JDA clientAccount = accountCreator.createClientAccount();


        SendMessages sendMessage = new SendMessages();
        sendMessage.sendHelpMessage(clientAccount);
    }
}
