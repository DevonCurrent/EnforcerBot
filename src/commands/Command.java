package commands;

import net.dv8tion.jda.core.entities.Message;

//interface for the command design model
public interface Command {
    void doAction();
    void setMessage(Message msg);
    Message getSentMessage();
}
