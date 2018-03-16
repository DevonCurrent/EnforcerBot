package main.java;

import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

//Main class. Launches an instance of the bot. Multiple bots can be created at same time, so stop any
//extra instances.
public class LaunchToDiscord extends ListenerAdapter {

    public static void main(String [] args){
        AccountCreator accountCreator = new AccountCreator();
        JDA botAccount = accountCreator.createBotAccount();
        JDA clientAccount = accountCreator.createClientAccount();


        SendMessages sendMessage = new SendMessages();
        sendMessage.sendHelpMessage(clientAccount);
    }
}
