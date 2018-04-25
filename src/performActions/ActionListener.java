package performActions;

import commands.Command;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/*ActionListener listens for messages received on Discord. All messages received are sent to CommandParser and
    the action of the command is performed. If no action exists, throw exception.
 */

public class ActionListener extends ListenerAdapter {

    public void onGuildMemberJoin(GuildMemberJoinEvent event){
        Member newMember = event.getMember();
        new SendGreetingMessage(newMember);
    }


    public void onMessageReceived(MessageReceivedEvent event){

        if (event.isFromType(ChannelType.TEXT))
        {
            System.out.printf("[%s][%s] %#s: %s%n", event.getGuild().getName(),
                    event.getChannel().getName(), event.getAuthor(), event.getMessage().getContentDisplay());

            try{
                Command actionCommand = CommandParser.parse(event.getMessage());
                actionCommand.doAction();
            }
            catch(RuntimeException e){
                event.getTextChannel().sendMessage("That is an invalid request. If you need help knowing my functions, type '!help'").queue();
            }
        }
    }
}
