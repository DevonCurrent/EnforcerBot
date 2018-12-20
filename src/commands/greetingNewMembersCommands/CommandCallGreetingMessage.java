package commands.greetingNewMembersCommands;

import commands.Command;
import main.java.Bot;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import performActions.SendGreetingMessage;

//calls the current greeting message for the guild that is set for new incoming members.
public class CommandCallGreetingMessage implements Command {
    private Message msg;
    Bot botAccount = Bot.getInstance();

    @Override
    public void doAction() {
        Member member = msg.getMember();
        new SendGreetingMessage(member);    //calls the same way that a new user would get the greeting message.
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
