package main.java;

import net.dv8tion.jda.bot.sharding.ShardManager;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.requests.restaction.MessageAction;

public class SendMessages {
    public void sendHelpMessage(JDA clientAccount){
        Message correctMessage = new MessageBuilder().append("!help").build();
        TextChannel CS222TextChannel = clientAccount.getTextChannelById("415502671483633666");
        MessageAction sendCorrectMessage = CS222TextChannel.sendMessage(correctMessage);
        sendCorrectMessage.queue();
    }
}
