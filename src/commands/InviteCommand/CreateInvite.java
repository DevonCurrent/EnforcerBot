package commands.InviteCommand;

import main.java.AccountCreator;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Invite;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.utils.cache.SnowflakeCacheView;

import java.util.List;

public class CreateInvite {

    AccountCreator accountCreator = new AccountCreator();
    private JDA botAccount = accountCreator.createBotAccount();


    private Invite CreateInvite(){
        SnowflakeCacheView<Guild> guilds = botAccount.getGuildCache();
        Guild testingGuild = guilds.getElementsByName("CS222Testing").get(0);

        SnowflakeCacheView<TextChannel> textChannels = testingGuild.getTextChannelCache();
        TextChannel generalChannel = textChannels.getElementsByName("general").get(0);
        generalChannel.createInvite().setMaxUses(1).complete();
        List<Invite> guildInvites = generalChannel.getInvites().complete();

        //TimeUnit.SECONDS.sleep(3);  //may need to adjust time for slower computers/networks

        return guildInvites.get(0);

    }
}
