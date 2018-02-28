package runOnDiscordTests;

import main.java.Command;
import main.java.Main;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.junit.Assert;
import org.junit.Test;
import javax.security.auth.login.LoginException;

public class RegexTest extends ListenerAdapter{

    @Test
    public void testRegex() {
        Main main = new Main();
        String botOutput = "!help";
        System.out.println(botOutput);
        Command command = new Command();
        Assert.assertEquals(botOutput, "Test");

    }
}