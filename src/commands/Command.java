package commands;

import net.dv8tion.jda.core.entities.Message;

public interface Command {
    void doAction();
    void setMessage(Message msg);
    Message getSentMessage();
}
