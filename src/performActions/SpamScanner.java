package performActions;

import commands.Command;
import net.dv8tion.jda.core.entities.Message;

/*Called on by ActionListener onMessageReceived. Will monitor the last three messages in a text channel.
  If they are all the same from the same member, AdminBot will kick the member.
*/
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
