package performActions;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;

import java.lang.reflect.Member;

public class MessagesStored {
    Message firstMessage = null;
    Message secondMessage = null;
    Message thirdMessage = null;

    public void updateMessagesStored(Message msg){
        firstMessage = secondMessage;
        secondMessage = thirdMessage;
        thirdMessage = msg;
    }

    public void compareMessages(){
        net.dv8tion.jda.core.entities.Member firstMember = firstMessage.getMember();
        net.dv8tion.jda.core.entities.Member secondMember = secondMessage.getMember();
        net.dv8tion.jda.core.entities.Member thirdMember = thirdMessage.getMember();
        String firstMessageContents = firstMessage.getContentDisplay();
        String secondMessageContents = secondMessage.getContentDisplay();
        String thirdMessageContents = thirdMessage.getContentDisplay();

        if(firstMember.equals(secondMember) && firstMember.equals(thirdMember)){
            if(firstMessageContents.equals(secondMessageContents) && firstMessageContents.equals(thirdMessageContents)){
                Guild guild = firstMember.getGuild();
                guild.getController().kick(firstMember).queue();
            }
        }
    }
}
