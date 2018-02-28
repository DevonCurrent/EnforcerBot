package main.java;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {

    private static JDA jda;

    public static void main(String [] args){
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken("NDE3NTI1MzM1MzQ5Nzg4Njcz.DXdamw.D7uf_Xgq__v6joVAkEoBLIvrmxc");
        builder.setAutoReconnect(true);
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.addEventListener(new Main());
        builder.addEventListener(new Command());

        try {
            jda = builder.buildBlocking();
        }catch(LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
