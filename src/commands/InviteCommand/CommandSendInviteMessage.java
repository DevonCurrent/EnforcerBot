package commands.InviteCommand;

import main.java.Bot;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.entities.User;

import java.util.concurrent.TimeUnit;

//TODO: The bot needs to send the message through a private channel to the user
//TODO: Need to verify that the bot will be able to contact a user that is outside of the guild
//TODO: Need to organize the structure of the SendClientMessage and CreateInvite that are also in this package
public class CommandSendInviteMessage implements commands.Command {

    private Message msg;
    private JDA botAccount = Bot.getInstance();

    @Override
    public void doAction() {
        String[] msgAsArray = msg.getContentRaw().split(" ");

        if (msgAsArray.length == 1) {
            msg.getTextChannel().sendMessage("You need to mention 1 or more members to ban!").queue();
        } else {
            String userToInviteName = msgAsArray[1];
            User userToInvite = botAccount.getUsersByName(userToInviteName, true).get(0);
            System.out.println(userToInvite.getName());
            PrivateChannel privateChannel = userToInvite.openPrivateChannel().complete();
            try {
                TimeUnit.SECONDS.sleep(1);  //may need to adjust time for slower computers/networks
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

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
