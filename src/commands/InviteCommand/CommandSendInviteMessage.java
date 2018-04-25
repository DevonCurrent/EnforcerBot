package commands.InviteCommand;

import main.java.Bot;
import net.dv8tion.jda.core.entities.*;

//TODO: The bot needs to send the message through a private channel to the user
//TODO: Need to verify that the bot will be able to contact a user that is outside of the guild
//TODO: Need to organize the structure of the SendClientMessage and CreateInvite that are also in this package
public class CommandSendInviteMessage implements commands.Command {

    private Message msg;
    private Bot botAccount = Bot.getInstance();

    @Override
    public void doAction() {
        String[] msgAsArray = msg.getContentRaw().split(" ");
        Guild guild = msg.getGuild();

        if (msgAsArray.length == 1) {
            msg.getTextChannel().sendMessage("You need to mention 1 member to invite!").queue();
        } else {
            String userToInviteName = msgAsArray[1];
            msg.getTextChannel().sendMessage("Invite to " + userToInviteName + " sent!").queue();

            botAccount.getUsersByName(userToInviteName, true).get(0);
            User userToInvite = botAccount.getUsersByName(userToInviteName, true).get(0);
            PrivateChannel privateChannel = userToInvite.openPrivateChannel().complete();

            new SendInvite(msg, privateChannel);
        }
    }


    @Override
    public void setMessage(Message msg) { this.msg = msg; }

    @Override
    public Message getSentMessage() {
        return null;
    }
}
