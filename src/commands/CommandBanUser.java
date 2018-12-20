package commands;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.exceptions.PermissionException;
import java.util.List;

/*command to ban a user from the server. Places them on a banlist, where they must be taken off before
    being allowed to join again.
*/
public class CommandBanUser implements commands.Command {

    private Message msg = null;

    @Override
    public void doAction() {
        if (msg.getContentRaw().split(" ").length == 1) {
            msg.getTextChannel().sendMessage("You need to mention 1 or more members to ban!").queue();
        }

        else if(msg.getMentionedUsers().isEmpty()){
            msg.getTextChannel().sendMessage("One of the users does not exist!").queue();
        }

        else{
            Guild guild = msg.getGuild();
            Member selfMember = guild.getSelfMember();

            List<User> mentionedUsers = msg.getMentionedUsers();
            for (User user : mentionedUsers) {
                System.out.println(user);
                Member member = guild.getMember(user);
                if (!selfMember.canInteract(member)) {
                    msg.getTextChannel().sendMessage(" Cannot ban member: " + member.getEffectiveName()
                            + ", they are in a higher role than I am!").queue();
                }

                guild.getController().ban(member, 1).queue(
                        success -> msg.getTextChannel().sendMessage(" Banned " + member.getEffectiveName() + " User banned!\n").queue(),
                        error ->
                                error(member, error));
            }
        }
    }

    private void error(Member member, Throwable error) {
        if (error instanceof PermissionException) {
            PermissionException pe = (PermissionException) error;
            Permission missingPermission = pe.getPermission();
            msg.getTextChannel().sendMessage(" I do not have the permission to ban " + member.getEffectiveName()
                    + "\nRequired permission: `" + missingPermission.getName() + "`").queue();
        } else {
            msg.getTextChannel().sendMessage(" Unknown error while banning " + member.getEffectiveName()
                    + ": <" + error.getClass().getSimpleName() + ">: " + error.getMessage()).queue();
        }
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

