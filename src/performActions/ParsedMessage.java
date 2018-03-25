package performActions;

import net.dv8tion.jda.core.entities.TextChannel;

public class ParsedMessage {

    private String text;
    private TextChannel textChannel;

    ParsedMessage(String msgText, TextChannel textChannel) {
        this.text = msgText;
        this.textChannel = textChannel;
    }

    public String getText(){
        return this.text;
    }

    public TextChannel getTextChannel() {
        return textChannel;
    }
}
