package commands;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.exceptions.PermissionException;

import java.util.List;

public class CommandRespondToKick implements commands.Command {

    Message msg=null;

    @Override
    public void doAction() {
        if (msg.getContentRaw().split(" ").length == 1) {
            msg.getTextChannel().sendMessage("You need to mention 1 or more members to kick!").queue();
        }

        else if(msg.getMentionedUsers().isEmpty()){
            msg.getTextChannel().sendMessage("One of the users does not exist!").queue();
        }

        else{
            Guild guild = msg.getTextChannel().getGuild();
            Member selfMember = guild.getSelfMember();

            List<User> mentionedUsers = msg.getMentionedUsers();
            for (User user : mentionedUsers) {
                System.out.println(user);
                Member member = guild.getMember(user);
                if (!selfMember.canInteract(member)) {
                    msg.getTextChannel().sendMessage(" Cannot kick member: " + member.getEffectiveName()
                            + ", they are in a higher role than I am!").queue();
                }

                guild.getController().kick(member).queue(
                        success -> msg.getTextChannel().sendMessage("Kicked " + member.getEffectiveName() + ". He just got the boot!\n").queue(),
                        error ->
                        {
                            if (error instanceof PermissionException) {
                                PermissionException pe = (PermissionException) error;
                                Permission missingPermission = pe.getPermission();

                                msg.getTextChannel().sendMessage(" I do not have the permission to kick " + member.getEffectiveName()
                                        + "\nRequired permission: `" + missingPermission.getName() + "`").queue();
                            } else {
                                msg.getTextChannel().sendMessage(" Unknown error while kicking " + member.getEffectiveName()
                                        + ": <" + error.getClass().getSimpleName() + ">: " + error.getMessage()).queue();
                            }
                        });
            }
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
