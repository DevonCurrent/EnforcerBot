package main.java;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.User;

import javax.security.auth.login.LoginException;

public class CreateClientAccount {

    public static JDA createClientAccount(){
        JDA clientAccount = null;
        try{
            clientAccount = new JDABuilder(AccountType.CLIENT).setToken("MzU1ODMzNjQzNDQyMTEwNDY0.DYb0mw.bVxAuYp1L-6PRjQS5JIvIE9Kewk").buildBlocking();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
        return clientAccount;
    }


    public User getClientID(JDA clientAccount) {
        return clientAccount.getUserById("355833643442110464");
    }
}
