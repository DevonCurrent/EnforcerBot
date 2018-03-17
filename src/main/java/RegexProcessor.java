package main.java;

import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

//processes the message. Checks to see if there is a regex ("!"). If so, removes it and calls the parser
public class RegexProcessor {
    private static Message processedMsg;

    public static void process(Message msg) {
        if (msg.getContentRaw().startsWith("!")) {
            String[] msgAsString = msg.getContentRaw().replaceFirst("!", "").split(" ");
            processedMsg = new MessageBuilder().append(msgAsString[0]).build();
            CommandParser.parse(processedMsg);
        }
    }

    public Message getProcessedMsg(){
        return processedMsg;
    }
}
