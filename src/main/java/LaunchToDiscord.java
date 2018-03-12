package main.java;

import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.requests.restaction.MessageAction;

public class LaunchToDiscord extends ListenerAdapter {

    public static void main(String [] args){
        AccountCreator accountCreator = new AccountCreator();
        JDA botAccount = accountCreator.createBotAccount();
        JDA clientAccount = accountCreator.createClientAccount();

        Message correctMessage = new MessageBuilder().append("!help").build();
        TextChannel CS222TextChannel = clientAccount.getTextChannelById("415502671483633666");
        MessageAction sendCorrectMessage = CS222TextChannel.sendMessage(correctMessage);
        sendCorrectMessage.queue();
    }
}
