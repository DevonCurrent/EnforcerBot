package testResources;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.User;

import javax.security.auth.login.LoginException;


//create the client account for testing. Will send messages to Discord to run the AdminBot commands.
public class CreateClientAccount {

    public static JDA createClientAccount(){
        JDA clientAccount = null;
        try{
            clientAccount = new JDABuilder(AccountType.CLIENT).setToken("""Place client token in here. Do not give out.""").buildBlocking();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
        return clientAccount;
    }


    public User getClientID(JDA clientAccount) {
        return clientAccount.getUserById("""Place user ID in here. Do not give out.""");
    }
}
