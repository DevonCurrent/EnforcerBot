package commands.greetingNewMembers;

import commands.Command;
import main.java.Bot;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import performActions.SendGreetingMessage;

public class CommandCallGreetingMessage implements Command {
    private Message msg;
    Bot botAccount = Bot.getInstance();

    @Override
    public void doAction() {
        Member member = msg.getMember();
        String memberName = member.getEffectiveName();

        SendGreetingMessage sendGreetingMessage = new SendGreetingMessage(member);
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
