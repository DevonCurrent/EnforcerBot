package main.java;

import net.dv8tion.jda.core.entities.Message;

//parses the message and calls on the respective command for the message
public class CommandParser {
    public static void parse(Message processedMsg) {
        String processedMsgAsString = processedMsg.getContentRaw();
        switch(processedMsgAsString){
            case "help":
                CommandRespondToHelp.sendBotMessage();
        }
    }
}
