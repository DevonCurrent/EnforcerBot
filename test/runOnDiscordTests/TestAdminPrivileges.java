package runOnDiscordTests;

import main.java.Bot;
import main.java.CreateClientAccount;
import main.java.LaunchToDiscord;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

//Test that only admins have priviledge to kick, ban, and make channels in the server.

public class TestAdminPrivileges {

    LaunchToDiscord launchToDiscord = new LaunchToDiscord();
    private JDA botAccount = Bot.getInstance();
    private JDA clientAccount = CreateClientAccount.createClientAccount();

}