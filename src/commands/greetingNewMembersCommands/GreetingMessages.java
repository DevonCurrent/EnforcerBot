package commands.greetingNewMembersCommands;

import net.dv8tion.jda.core.entities.Guild;

import java.util.HashMap;

//Stores greeting messages for each guild.
public class GreetingMessages {

    private static HashMap<Guild, String> greetingMessages = new HashMap<>();

    public static void updateGreetingMessages(Guild guild, String greeting) {
        greetingMessages.put(guild, greeting);

        guild.getTextChannels().get(0).sendMessage("Alright! The new message that will be sent to joining members will be: \n" + greeting).complete();
    }

    //call on greeting messages for CommandCallGreetingMessage and SendGreetingMessage classes
    public static String getGreetingMessage(Guild guild){
        return greetingMessages.get(guild);
    }
}
