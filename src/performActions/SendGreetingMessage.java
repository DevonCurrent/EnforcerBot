package performActions;

import commands.greetingNewMembers.GreetingMessages;
import main.java.Bot;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.*;

//Called on by the ActionListener onGuildMemberJoin. Will send a private message (if set up) to incoming members.
public class SendGreetingMessage {
    private Bot botAccount = Bot.getInstance();

    public SendGreetingMessage(Member newMember) {
        String memberName = newMember.getEffectiveName();
        Guild guild = newMember.getGuild();
        String greetingMessage = GreetingMessages.getGreetingMessage(guild);

        if(greetingMessage != null){    //so as not to send a null message to a new member
            User userToInvite = botAccount.getUsersByName(memberName, true).get(0);
            PrivateChannel privateChannel = userToInvite.openPrivateChannel().complete();

            Message msgToPrivateChannel = new MessageBuilder().append(greetingMessage).build();
            privateChannel.sendMessage(msgToPrivateChannel).complete();
        }
    }
}
