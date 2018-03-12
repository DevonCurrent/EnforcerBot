package runOnDiscordTests;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.requests.restaction.MessageAction;

import javax.security.auth.login.LoginException;

class MessageListener extends ListenerAdapter
{

    public static void main(String[] args)
            throws LoginException, InterruptedException {
        //creates the connection to Discord for the bot account (Admin Bot) and client Devon Current's account (SacredZoren)
        JDA botAccount = new JDABuilder(AccountType.BOT).setToken("NDE3NTI1MzM1MzQ5Nzg4Njcz.DXdamw.D7uf_Xgq__v6joVAkEoBLIvrmxc").buildBlocking();
        botAccount.addEventListener(new MessageListener());     //adds listener to return messages on Discord to IntelliJ (for testing)
        JDA clientAccount = new JDABuilder(AccountType.CLIENT).setToken("MzU1ODMzNjQzNDQyMTEwNDY0.DKjfPQ.VU5t7ywdpi0kCENeqpGOPpg2X7c").buildBlocking();

        //call the ID of the accounts (for testing)
        User botID = botAccount.getUserById("417525335349788673");
        User clientID = clientAccount.getUserById("355833643442110464");

        //creates message !help that the client account sends to Discord. Admin Bot responds on Discord and the listener retrieves the Admin Bot "Test" message
        Message message = new MessageBuilder().append("!help").build();
        TextChannel CS222TextChannel = clientAccount.getTextChannelById("415502671483633666");
        MessageAction CorrectMessage = CS222TextChannel.sendMessage(message);
        CorrectMessage.queue();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.isFromType(ChannelType.TEXT))
        {
            System.out.printf("[%s][%s] %#s: %s%n", event.getGuild().getName(),
                    event.getChannel().getName(), event.getAuthor(), event.getMessage().getContentDisplay());
        }
        else
        {
            System.out.printf("[PM] %#s: %s%n", event.getAuthor(), event.getMessage().getContentDisplay());
        }
    }
}