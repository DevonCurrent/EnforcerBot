package commands.InviteCommand;

import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.*;

import java.util.List;

class SendInvite {


    SendInvite(Message msg, PrivateChannel privateChannel) {
        Guild guild = msg.getMember().getGuild();

        TextChannel generalChannel = guild.getTextChannels().get(0);
        generalChannel.createInvite().setMaxUses(1).complete();
        List<Invite> guildInvites = generalChannel.getInvites().complete();
        String inviteToMember = guildInvites.get(0).getCode();

        Message msgToPrivateChannel = new MessageBuilder().append(inviteToMember).build();
        privateChannel.sendMessage(msgToPrivateChannel).complete();
    }
}
