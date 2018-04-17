package testResources;

import net.dv8tion.jda.bot.sharding.ShardManager;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.requests.restaction.MessageAction;

//sends a client-made message to Discord for testing
public class SendClientMessage {
    private Message msg = null;

    public void sendMessageToDiscord(JDA clientAccount, String messageAsString){

        msg = new MessageBuilder().append(messageAsString).build();

        Guild clientInGuild = clientAccount.getGuildsByName("CS222Testing", true).get(0);
        TextChannel generalTextChannel = clientInGuild.getTextChannelsByName("general", true).get(0);

        MessageAction sendCorrectMessage = generalTextChannel.sendMessage(msg);
        sendCorrectMessage.queue();
    }

    public Message getMessage(){
        return this.msg;
    }
}