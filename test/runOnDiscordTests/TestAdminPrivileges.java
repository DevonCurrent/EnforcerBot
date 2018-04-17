package runOnDiscordTests;

import main.java.AccountCreator;
import net.dv8tion.jda.core.JDA;

//Test that only admins have priviledge to kick, ban, and make channels in the server.

public class TestAdminPrivileges {

    private AccountCreator accountCreator = new AccountCreator();
    private JDA botAccount = accountCreator.createBotAccount();
    private JDA clientAccount = accountCreator.createClientAccount();

}