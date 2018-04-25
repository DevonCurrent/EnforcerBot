package commands.InviteCommand;

import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

class SendInvite {


    SendInvite(Message msg, PrivateChannel privateChannel) {
        Guild guild = msg.getMember().getGuild();

        TextChannel generalChannel = guild.getTextChannels().get(0);
        generalChannel.createInvite().setMaxUses(1).complete();
        List<Invite> guildInvites = generalChannel.getInvites().complete();
        String inviteToMember = guildInvites.get(0).getCode();

        try {
            TimeUnit.SECONDS.sleep(5);  //may need to adjust time for slower computers/networks
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Message msgToPrivateChannel = new MessageBuilder().append("Here is the invite code to join the server " + guild.getName() + ": " +inviteToMember).build();
        privateChannel.sendMessage(msgToPrivateChannel).complete();
    }
}
