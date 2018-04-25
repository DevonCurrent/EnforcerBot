package runOnDiscordTests;

import main.java.Bot;
import main.java.LaunchToDiscord;
import net.dv8tion.jda.core.JDA;

//Test that only admins have priviledge to kick, ban, and make channels in the server.

public class TestAdminPrivileges {

    LaunchToDiscord launchToDiscord = new LaunchToDiscord();
    private JDA botAccount = Bot.getInstance();
    private JDA clientAccount = CreateClientAccount.createClientAccount();

}