package commands;

import main.java.Bot;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

//command to display the ping (latency) of the bot.
public class CommandSendPingStatus implements Command {

    private Message sentMessage;
    private Message msg;
    private Bot botAccount =Bot.getInstance();

    @Override
    public void doAction() {
        long ping = botAccount.getPing();
        sentMessage = new MessageBuilder().append("My ping is " + ping +"ms!").build();

        TextChannel textChannel = msg.getTextChannel();
        textChannel.sendMessage(sentMessage).queue();
    }

    @Override
    public void setMessage(Message msg) {
        this.msg = msg;
    }

    @Override
    public Message getSentMessage(){
        return this.sentMessage;
    }
}
