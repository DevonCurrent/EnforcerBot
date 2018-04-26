package commands;

import main.java.Bot;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

import java.util.Random;

public class CommandCreateRandomNumber implements Command {
    private Message sentMessage;
    private Message msg;
    private Bot botAccount =Bot.getInstance();


    @Override
    public void doAction() {
        String[] msgContents = msg.getContentRaw().split(" ");
        Random randomNumber = new Random();
        String reply = null;

        //DEFAULT of generating a random number from 1 to 6
        if(msgContents.length == 1){
            int answer = randomNumber.nextInt(6) + 1;
            reply = "I hope you wanted a " + answer + "!";
        }

        //If the user stated a number value, it will be the max possible value. Throws exception if a number was not stated.
        else if(msgContents.length == 2){
            reply = parseMaxNumber(msgContents[1]);
        }

        //If more than 1 number is stated, or if text is made after "!rng", it will respond with this.
        else{
            reply = ("You may only choose one number for the random number generator. Example: \"!rng 10\" \n");
        }

        sentMessage = new MessageBuilder().append(reply).build();

        TextChannel textChannel = msg.getTextChannel();
        textChannel.sendMessage(sentMessage).queue();
    }

    private String parseMaxNumber(String msgContent) {
        String reply;
        try {
            int maxNumber = Integer.parseInt(msgContent);

            if(maxNumber < 0){
                reply = ("I'm sorry. I don't know how to deal with negative numbers...");
            }
            else if(maxNumber == 0){
                reply = ("You want a random number and you are using 0? Ok, then it is 0!");
            }
            else{
                Random randomNumber = new Random();
                int answer = randomNumber.nextInt(maxNumber) + 1;
                reply = "I hope you wanted a " + answer + "!";
            }

        }catch (NumberFormatException ex){
            reply = ("You must choose a number for the random number generator.\n");
        }
        return reply;
    }

    @Override
    public void setMessage(Message msg) {
        this.msg = msg;
    }

    @Override
    public Message getSentMessage() {
        return this.sentMessage;
    }
}
