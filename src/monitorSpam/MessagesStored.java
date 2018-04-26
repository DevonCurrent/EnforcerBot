package monitorSpam;

import main.java.Bot;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.requests.restaction.RoleAction;

import java.awt.*;
import java.util.List;

/*Stores most recent messages to run through to check for spam.
    Uses Singleton Model to create a single instance of an array that holds messages. Can update the
    data structure and compare messages to one another.
 */
public final class MessagesStored {

    private static final MessagesStored INSTANCE = new MessagesStored();

    Message storedMessages[] = {null, null, null};

    private MessagesStored(){ }

    public static MessagesStored getInstance() { return INSTANCE; }

    public void updateMessagesStored(Message msg) {

        storedMessages[0] = storedMessages[1];
        storedMessages[1] = storedMessages[2];
        storedMessages[2] = msg;
    }

    public void compareMessages() {
        String firstMessageContents = storedMessages[0].getContentRaw();
        String secondMessageContents = storedMessages[1].getContentRaw();
        String thirdMessageContents = storedMessages[2].getContentRaw();

        net.dv8tion.jda.core.entities.Member firstMember = storedMessages[0].getMember();
        net.dv8tion.jda.core.entities.Member secondMember = storedMessages[1].getMember();
        net.dv8tion.jda.core.entities.Member thirdMember = storedMessages[2].getMember();

        System.out.println(firstMessageContents);
        System.out.println(firstMember.getEffectiveName());

        System.out.println(secondMessageContents);
        System.out.println(secondMember.getEffectiveName());

        System.out.println(thirdMessageContents);
        System.out.println(thirdMember.getEffectiveName());




        if (firstMember.equals(secondMember) && secondMember.equals(thirdMember)) {
            if (firstMessageContents.equals(secondMessageContents) && secondMessageContents.equals(thirdMessageContents)) {
                Guild guild = thirdMember.getGuild();
                RoleAction role = guild.getController().createRole();
                guild.getController().kick(thirdMember).queue();
            }
        }
    }

    //To prevent comparing messages until all messages are assigned values.
    public boolean isStorageFull(){
        if(storedMessages[0] == null)
            return false;
        else
            return true;
    }
}
