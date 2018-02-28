package main.java;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Command extends ListenerAdapter{

    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getMessage().getContentDisplay().startsWith("!")){
            String[] args = e.getMessage().getContentDisplay().replaceFirst("!", "").split(" ");

            switch(args[0]) {
                case "help":
                    Help.run(e.getMessage());
            }
        }
    }
}
