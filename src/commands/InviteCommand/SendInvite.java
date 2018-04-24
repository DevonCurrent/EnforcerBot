package commands.InviteCommand;

import main.java.AccountCreator;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.utils.cache.SnowflakeCacheView;

import java.util.List;

class SendInvite {

    private AccountCreator accountCreator = new AccountCreator();
    private JDA botAccount = AccountCreator.createBotAccount();

    SendInvite(Message msg, PrivateChannel privateChannel) {
        Member member = msg.getMember();
        Guild guild = msg.getMember().getGuild();

        TextChannel generalChannel = guild.getTextChannels().get(0);
        generalChannel.createInvite().setMaxUses(1).complete();
        List<Invite> guildInvites = generalChannel.getInvites().complete();
        String inviteToMember = guildInvites.get(0).getCode();

        Message msgToPrivateChannel = new MessageBuilder().append(inviteToMember).build();
        privateChannel.sendMessage(msgToPrivateChannel).complete();
    }
}
