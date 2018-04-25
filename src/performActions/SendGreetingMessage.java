package performActions;

import commands.greetingNewMembers.GreetingMessages;
import main.java.Bot;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.*;

//TODO: The bot needs to send the message through a private channel to the user
public class SendGreetingMessage {
    private Bot botAccount = Bot.getInstance();

    public SendGreetingMessage(Member newMember) {
        String memberName = newMember.getEffectiveName();
        System.out.println("Test 1");
        Guild guild = newMember.getGuild();
        String greetingMessage = GreetingMessages.getGreetingMessage(guild);

        if(greetingMessage != null){
            User userToInvite = botAccount.getUsersByName(memberName, true).get(0);
            PrivateChannel privateChannel = userToInvite.openPrivateChannel().complete();

            Message msgToPrivateChannel = new MessageBuilder().append(greetingMessage).build();
            privateChannel.sendMessage(msgToPrivateChannel).complete();
        }
    }
}
