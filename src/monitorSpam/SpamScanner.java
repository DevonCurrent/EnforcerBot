package monitorSpam;

import commands.Command;
import net.dv8tion.jda.core.entities.*;

/*SpamScanner called by CommandCreator. Keeps track of last three messages, and will compare them. If they are the
    same, and from the same person, will kick that person from the guild.
*/
public class SpamScanner implements Command {

    private Message msg;

    @Override
    public void doAction() {
        MessagesStored messagesStored = MessagesStored.getInstance();

        messagesStored.updateMessagesStored(msg);

        if(messagesStored.isStorageFull() == true){
            messagesStored.compareMessages();
        }
    }

    // is necessary for library to function
    @Override
    public void setMessage(Message msg) {
        this.msg = msg;
    }

    @Override
    public Message getSentMessage() {
        return null;
    }
}
