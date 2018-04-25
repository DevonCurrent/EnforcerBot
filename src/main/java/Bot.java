package main.java;

import net.dv8tion.jda.bot.JDABot;
import net.dv8tion.jda.client.JDAClient;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.hooks.IEventManager;
import net.dv8tion.jda.core.managers.AudioManager;
import net.dv8tion.jda.core.managers.Presence;
import net.dv8tion.jda.core.requests.RestAction;
import net.dv8tion.jda.core.requests.restaction.GuildAction;
import net.dv8tion.jda.core.utils.cache.CacheView;
import net.dv8tion.jda.core.utils.cache.SnowflakeCacheView;
import performActions.ActionListener;

import javax.security.auth.login.LoginException;
import java.util.Collection;
import java.util.List;


//Utilizes the Singleton model which must implement JDA. Creates a static instance of the bot (botAccount) that wraps the JDA.
public final class Bot implements JDA {

    private static final Bot INSTANCE = new Bot();

    private JDA botAccount = null;
    //creates the bot account using the Admin Bot token that was created during the setup. Throws exception if cannot connect.
    //buildBlocking() ensures that the bot is connected before continuing on with the code.
    private Bot() {
        try {
            botAccount = new JDABuilder(AccountType.BOT).setToken("NDE3NTI1MzM1MzQ5Nzg4Njcz.DXdamw.D7uf_Xgq__v6joVAkEoBLIvrmxc").buildBlocking();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }

        botAccount.setAutoReconnect(true);
        botAccount.addEventListener(new LaunchToDiscord());
        botAccount.addEventListener(new ActionListener());
    }

    public static Bot getInstance() {
        return INSTANCE;
    }

    @Override
    public Status getStatus() {
        return botAccount.getStatus();
    }

    @Override
    public long getPing() {
        return botAccount.getPing();
    }

    @Override
    public List<String> getCloudflareRays() {
        return botAccount.getCloudflareRays();
    }

    @Override
    public List<String> getWebSocketTrace() {
        return botAccount.getWebSocketTrace();
    }

    @Override
    public void setEventManager(IEventManager iEventManager) {
        botAccount.setEventManager(iEventManager);
    }

    @Override
    public void addEventListener(Object... objects) {
        botAccount.addEventListener(objects);
    }

    @Override
    public void removeEventListener(Object... objects) {
        botAccount.removeEventListener(objects);
    }

    @Override
    public List<Object> getRegisteredListeners() {
        return botAccount.getRegisteredListeners();
    }

    @Override
    public GuildAction createGuild(String s) {
        return botAccount.createGuild(s);
    }

    @Override
    public CacheView<AudioManager> getAudioManagerCache() {
        return botAccount.getAudioManagerCache();
    }

    @Override
    public SnowflakeCacheView<User> getUserCache() {
        return botAccount.getUserCache();
    }

    @Override
    public List<Guild> getMutualGuilds(User... users) {
        return botAccount.getMutualGuilds(users);
    }

    @Override
    public List<Guild> getMutualGuilds(Collection<User> collection) {
        return botAccount.getMutualGuilds(collection);
    }

    @Override
    public RestAction<User> retrieveUserById(String s) {
        return botAccount.retrieveUserById(s);
    }

    @Override
    public RestAction<User> retrieveUserById(long l) {
        return botAccount.retrieveUserById(l);
    }

    @Override
    public SnowflakeCacheView<Guild> getGuildCache() {
        return botAccount.getGuildCache();
    }

    @Override
    public SnowflakeCacheView<Role> getRoleCache() {
        return botAccount.getRoleCache();
    }

    @Override
    public SnowflakeCacheView<Category> getCategoryCache() {
        return botAccount.getCategoryCache();
    }

    @Override
    public SnowflakeCacheView<TextChannel> getTextChannelCache() {
        return botAccount.getTextChannelCache();
    }

    @Override
    public SnowflakeCacheView<VoiceChannel> getVoiceChannelCache() {
        return botAccount.getVoiceChannelCache();
    }

    @Override
    public SnowflakeCacheView<PrivateChannel> getPrivateChannelCache() {
        return botAccount.getPrivateChannelCache();
    }

    @Override
    public SnowflakeCacheView<Emote> getEmoteCache() {
        return botAccount.getEmoteCache();
    }

    @Override
    public SelfUser getSelfUser() {
        return botAccount.getSelfUser();
    }

    @Override
    public Presence getPresence() {
        return botAccount.getPresence();
    }

    @Override
    public ShardInfo getShardInfo() {
        return botAccount.getShardInfo();
    }

    @Override
    public String getToken() {
        return botAccount.getToken();
    }

    @Override
    public long getResponseTotal() {
        return botAccount.getResponseTotal();
    }

    @Override
    public int getMaxReconnectDelay() {
        return botAccount.getMaxReconnectDelay();
    }

    @Override
    public void setAutoReconnect(boolean b) {
        botAccount.setAutoReconnect(b);
    }

    @Override
    public void setRequestTimeoutRetry(boolean b) {
        botAccount.setRequestTimeoutRetry(b);
    }

    @Override
    public boolean isAutoReconnect() {
        return botAccount.isAutoReconnect();
    }

    @Override
    public boolean isAudioEnabled() {
        return botAccount.isAudioEnabled();
    }

    @Override
    public boolean isBulkDeleteSplittingEnabled() {
        return botAccount.isBulkDeleteSplittingEnabled();
    }

    @Override
    public void shutdown() {
        botAccount.shutdown();
    }

    @Override
    public void shutdownNow() {
        botAccount.shutdownNow();
    }

    @Override
    public AccountType getAccountType() {
        return botAccount.getAccountType();
    }

    @Override
    public JDAClient asClient() {
        return botAccount.asClient();
    }

    @Override
    public JDABot asBot() {
        return botAccount.asBot();
    }
}
