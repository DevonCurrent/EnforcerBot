package commands;

import net.dv8tion.jda.core.entities.Message;

public class CommandRespondToHelp implements commands.Command {
    private Message msg;

    @Override
    public void doAction() {
        msg.getTextChannel().sendMessage ("My commands are:\n\n" +
                "!ban [@User] - Kicks the user from the server and places them on the ban list.\n" +
                "!kick [@User] - Kicks the user from the server. They can rejoin if they have an invite.\n" +
                "!Unban [User] - Unbans the user from the ban list. Does not invite them to the server.\n" +
                "!channels [1-10] - creates one to ten voice channels.\n").queue();
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
