package commands.InviteCommand;

import main.java.AccountCreator;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.utils.cache.SnowflakeCacheView;

import java.util.List;

//TODO: The bot needs to send the message through a private channel to the user
//TODO: Need to verify that the bot will be able to contact a user that is outside of the guild
//TODO: Need to organize the structure of the SendClientMessage and CreateInvite that are also in this package
public class CommandSendInviteMessage implements commands.Command {

    private Message msg;
    private AccountCreator accountCreator = new AccountCreator();
    private JDA botAccount = accountCreator.createBotAccount();
    SendClientMessage sentMessage = new SendClientMessage();

    @Override
    public void doAction() {
        SnowflakeCacheView<Guild> guilds = botAccount.getGuildCache();
        Guild testingGuild = guilds.getElementsByName("CS222Testing").get(0);

        String[] msgAsArray = msg.getContentRaw().split(" ");

        if (msgAsArray.length == 1) {
            msg.getTextChannel().sendMessage("You need to mention 1 or more members to ban!").queue();
        }

        else{
            String userToInviteName = msgAsArray[1];
            User userToInvite = botAccount.getUsersByName(userToInviteName, true).get(0);

            CreateInvite createdInvite = new CreateInvite();
            sentMessage.sendMessageToDiscord(botAccount, String.valueOf(createdInvite));
        }
    }

    @Override
    public void setMessage(Message msg) { this.msg = msg; }

    @Override
    public Message getSentMessage() {
        return null;
    }
}
