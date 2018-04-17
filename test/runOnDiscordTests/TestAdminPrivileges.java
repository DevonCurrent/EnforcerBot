package runOnDiscordTests;

import com.sun.xml.internal.ws.resources.SenderMessages;
import main.java.AccountCreator;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.utils.cache.SnowflakeCacheView;
import org.junit.Assert;
import org.junit.Test;
import testResources.SendClientMessage;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

//Test that only admins have priviledge to kick, ban, and make channels in the server.

public class TestAdminPrivileges {

    private AccountCreator accountCreator = new AccountCreator();
    private JDA botAccount = accountCreator.createBotAccount();
    private JDA clientAccount = accountCreator.createClientAccount();


}
