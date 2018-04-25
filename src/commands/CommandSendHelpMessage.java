package commands;

import net.dv8tion.jda.core.entities.Message;

//command to display all the bot's features and how to use them.
public class CommandSendHelpMessage implements commands.Command {
    private Message msg;

    @Override
    public void doAction() {
        msg.getTextChannel().sendMessage ("My commands are:\n\n" +
                "!ban [@User] - Kicks the user from the server and places them on the ban list.\n" +
                "!channels [1-10] - creates one to ten voice channels.\n" +
                "!greetings [string] - set up a message and I will DM any new members that join your server.\n" +
                "!greetings? - I'll remind you what you set your greetings message as for new members.\n" +
                "!kick [@User] - Kicks the user from the server. They can rejoin if they have an invite.\n" +
                "!ping - Relays bot latency.\n" +
                "!Unban [User] - Unbans the user from the ban list. Does not invite them to the server.\n").queue();
    }

    @Override
    public void setMessage(Message msg) {
        this.msg = msg;
    }

    @Override
    public Message getSentMessage() {
        return null;
    }
}
