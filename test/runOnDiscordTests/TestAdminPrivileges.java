package runOnDiscordTests;

import main.java.Bot;
import main.java.CreateClientAccount;
import net.dv8tion.jda.core.JDA;

//Test that only admins have priviledge to kick, ban, and make channels in the server.

public class TestAdminPrivileges {

    private JDA botAccount = Bot.getInstance();
    private JDA clientAccount = CreateClientAccount.createClientAccount();

}