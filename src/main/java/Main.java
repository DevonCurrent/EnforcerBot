package main.java;

import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.requests.restaction.MessageAction;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {

    public static void main(String [] args){
        JDA botAccount = null;
        JDA clientAccount = null;
        try {
            botAccount = new JDABuilder(AccountType.BOT).setToken("NDE3NTI1MzM1MzQ5Nzg4Njcz.DXdamw.D7uf_Xgq__v6joVAkEoBLIvrmxc").buildBlocking();
            clientAccount = new JDABuilder(AccountType.CLIENT).setToken("MzU1ODMzNjQzNDQyMTEwNDY0.DKjfPQ.VU5t7ywdpi0kCENeqpGOPpg2X7c").buildBlocking();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }

        assert botAccount != null;      //if null, then catch branch will stop the program
        assert clientAccount != null;

        botAccount.setAutoReconnect(true);
        botAccount.addEventListener(new Main());
        botAccount.addEventListener(new Command());


        User botID = botAccount.getUserById("417525335349788673");
        User clientID = clientAccount.getUserById("355833643442110464");

        Message message = new MessageBuilder().append("!help").build();
        TextChannel CS222TextChannel = clientAccount.getTextChannelById("415502671483633666");
        MessageAction CorrectMessage = CS222TextChannel.sendMessage(message);
        CorrectMessage.queue();
    }
}
