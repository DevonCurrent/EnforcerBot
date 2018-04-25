package commands;

import net.dv8tion.jda.core.entities.Message;

public class SpamScanner implements Command {
    private Message msg;

    @Override
    public void doAction() {

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
