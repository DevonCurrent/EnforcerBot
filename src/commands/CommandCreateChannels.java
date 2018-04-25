package commands;

import net.dv8tion.jda.core.entities.*;

//command to create 1-10 voice channels.
public class CommandCreateChannels implements commands.Command {
    private Message msg;

    @Override
    public void doAction() {
        Guild guild = msg.getGuild();
        String[] msgName = msg.getContentRaw().split(" ");

        try {
            CreateVoiceChannels(guild, msgName[1]);
        } catch (NumberFormatException ex) {
            msg.getTextChannel().sendMessage("You must choose a number between 1 and 10 for how many channels you wish to create.\n").queue();
        }
    }

    private void CreateVoiceChannels(Guild guild, String s) {
        int numberOfChannels = Integer.parseInt(s);
        if(numberOfChannels > 10) {
            msg.getTextChannel().sendMessage("You must choose a number between 1 and 10 for how many channels you wish to create.\n").queue();
        }
        else
            for(int i=0; i<numberOfChannels; i++) {
                guild.getController().createVoiceChannel("Channel " + (i + 1)).complete();
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
