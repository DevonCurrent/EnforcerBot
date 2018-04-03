package commands;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.requests.RestAction;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CommandRespondToUnban implements commands.Command {

    private Message msg = null;

    @Override
    public void doAction() {

        String[] msgString = msg.getContentRaw().split(" ");
        String msgName = msgString[1];

        if (msgName == null && msg.getChannelType() != msg.getChannelType().PRIVATE)
            msg.getTextChannel().sendMessage("You must choose a user to unban").queue();

        else {
            Guild guild = msg.getGuild();
            Member selfMember = guild.getSelfMember();

            //Check if the bot have permission to kick.
            if (!selfMember.hasPermission(Permission.BAN_MEMBERS)) {
                msg.getTextChannel().sendMessage(" I need to have **Ban Members** Permission to unban members.").queue();
            } else if (!msg.getMember().hasPermission(Permission.BAN_MEMBERS)) {
                msg.getTextChannel().sendMessage(" You need to have **Ban Members** Permission to unban members.").queue();
                return;
            }

            List<Guild.Ban> banList = guild.getBanList().complete();
            guild.getController().unban(msgName);

            for (Guild.Ban aBanList : banList) {
                User bannedUser = aBanList.getUser();
                System.out.println(bannedUser);
                System.out.println(msgName);
                System.out.println(bannedUser.getName());
                if (bannedUser.getName().equals(msgName)) {
                    guild.getController().unban(bannedUser).complete(); //should unban the user from the banlist.
                }
            }
        }
    }


    @Override
    public void setMessage (Message msg){
        this.msg = msg;
    }

    @Override
    public Message getSentMessage () {
        return null;
    }
}
