package main.java;

import net.dv8tion.jda.core.entities.Message;

public class Help {
    public static void run(Message msg) {
        msg.getChannel().sendMessage("Test").queue();
    }
}