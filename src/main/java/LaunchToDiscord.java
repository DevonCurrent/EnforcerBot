package main.java;

import net.dv8tion.jda.core.hooks.ListenerAdapter;
import performActions.ActionListener;

//Main class. Launches an instance of the bot. Multiple bots can be created at same time, so stop any
//extra instances.
public class LaunchToDiscord extends ListenerAdapter {

    public static void main(String [] args){
        Bot botAccount = Bot.getInstance();
    }
}
