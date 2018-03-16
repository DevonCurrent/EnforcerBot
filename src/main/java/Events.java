package main.java;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Events extends ListenerAdapter{

    private static TextChannel channel;
    private static Message msg;

    public void onMessageReceived(MessageReceivedEvent event){


        if (event.isFromType(ChannelType.TEXT))
        {
            System.out.printf("[%s][%s] %#s: %s%n", event.getGuild().getName(),
                    event.getChannel().getName(), event.getAuthor(), event.getMessage().getContentDisplay());
            msg = event.getMessage();
            channel = event.getTextChannel();
            RegexProcessor.process(event.getMessage());
        }
        else
        {
            System.out.printf("[PM] %#s: %s%n", event.getAuthor(), event.getMessage().getContentDisplay());
        }

    }
    public static TextChannel getTextChannel(){
        return channel;
    }

    public static Message retrieveMessage() {
        return msg;
    }
}
