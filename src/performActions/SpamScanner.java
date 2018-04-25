package performActions;

import commands.Command;
import net.dv8tion.jda.core.entities.*;

public class SpamScanner implements Command {
    private Message msg;
    //looks through the ActionListener to find Spam
    @Override
    public void doAction() {
        Member memberThatSentMsg = msg.getMember();
        MessagesStored messagesStored = new MessagesStored();
        messagesStored.updateMessagesStored(msg);
        messagesStored.compareMessages();
    }

    // is necessary for library to function
    @Override
    public void setMessage(Message msg) {

    }

    @Override
    public Message getSentMessage() {
        return null;
    }
}
