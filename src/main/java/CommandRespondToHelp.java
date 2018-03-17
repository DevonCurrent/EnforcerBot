package main.java;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.TextChannel;

//command for bot to respond to a ping message.
public class CommandRespondToHelp {
    public static void sendBotMessage() {
        Events.getTextChannel().sendMessage("Test").queue();
    }
}
