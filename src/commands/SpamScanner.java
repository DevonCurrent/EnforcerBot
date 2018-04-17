package commands;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.requests.restaction.PermissionOverrideAction;

public class SpamScanner implements Command {
    private Message msg;

    @Override
    public void doAction() {
        Guild guild = null;
      //  Member memberToMute = guild.getMember(Member, "dsa");
      //  PermissionOverrideAction permissionOverride = msg.getTextChannel().createPermissionOverride(memberToMute);
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
