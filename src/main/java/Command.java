package main.java;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import sun.plugin2.message.Message;

public class Command extends ListenerAdapter{

    public void onMessageReceived(MessageReceivedEvent event){

        if (event.isFromType(ChannelType.TEXT))
        {
            System.out.printf("[%s][%s] %#s: %s%n", event.getGuild().getName(),
                    event.getChannel().getName(), event.getAuthor(), event.getMessage().getContentDisplay());
        }
        else
        {
            System.out.printf("[PM] %#s: %s%n", event.getAuthor(), event.getMessage().getContentDisplay());
        }


        if(event.getMessage().getContentDisplay().startsWith("!")){
            String[] args = event.getMessage().getContentDisplay().replaceFirst("!", "").split(" ");

            switch(args[0]) {
                case "help":
                    Help.run(event.getMessage());
            }
        }
    }
}
