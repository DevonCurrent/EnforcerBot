package commands;

import net.dv8tion.jda.core.entities.Message;

//command to display all the bot's features and how to use them.
public class CommandSendHelpMessage implements commands.Command {
    private Message msg;

    @Override
    public void doAction() {
        msg.getTextChannel().sendMessage ("My commands are:\n\n" +
                "!ban [@User] - I will ban the user from the server and places them on the ban list.\n" +
                "!channels [1-10] - I will create one to ten voice channels.\n" +
                "!greetings [string] - set up a message and I will DM any new members that join your server.\n" +
                "!greetings? - I'll remind you what you set your greetings message as for new members.\n" +
                "!kick [@User] - I will kick the user from the server. They can rejoin if they have an invite though.\n" +
                "!ping - Relay bot latency.\n" +
                "!rng [n] - I will choose a random number from 1 to n. If you don't give me a value, I will choose 6. \n" +
                "!Unban [User] - I will remove that user from the server ban list. This will NOT invite them back though.\n").queue();
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
