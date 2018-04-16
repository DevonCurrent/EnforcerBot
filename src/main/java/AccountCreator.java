package main.java;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.User;
import performActions.ActionListener;

import javax.security.auth.login.LoginException;

public class AccountCreator {

    private static JDA botAccount;
    private static JDA clientAccount;

    //creates the bot account using the Admin Bot token that was created during the setup. Throws exception if cannot connect.
    //buildBlocking() ensures that the bot is connected before continuing on with the code.
    public JDA createBotAccount(){
        JDA botAccount=null;
        try{
            botAccount = new JDABuilder(AccountType.BOT).setToken("NDE3NTI1MzM1MzQ5Nzg4Njcz.DXdamw.D7uf_Xgq__v6joVAkEoBLIvrmxc").buildBlocking();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
        assert botAccount != null;
        botAccount.setAutoReconnect(true);
        botAccount.addEventListener(new LaunchToDiscord());
        botAccount.addEventListener(new ActionListener());
        return botAccount;
    }

    public JDA createClientAccount(){
        try{
            clientAccount = new JDABuilder(AccountType.CLIENT).setToken("MzU1ODMzNjQzNDQyMTEwNDY0.DYb0mw.bVxAuYp1L-6PRjQS5JIvIE9Kewk").buildBlocking();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
        return clientAccount;
    }

    public User getBotID(JDA botAccount){
        return botAccount.getUserById("417525335349788673");
    }

    public User getClientID(JDA clientAccount) {
        return clientAccount.getUserById("355833643442110464");
    }

    public static JDA getBotAccount(){
        return botAccount;
    }

    public static JDA getClientAccount(){
        return clientAccount;
    }
}
