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

public final class Bot implements JDA {

    private static final Bot INSTANCE = new Bot();

    JDA botAccount;

    //creates the bot account using the Admin Bot token that was created during the setup. Throws exception if cannot connect.
    //buildBlocking() ensures that the bot is connected before continuing on with the code.
    private Bot(){
        try {
            botAccount = new JDABuilder(AccountType.BOT).setToken("NDE3NTI1MzM1MzQ5Nzg4Njcz.DXdamw.D7uf_Xgq__v6joVAkEoBLIvrmxc").buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert botAccount != null;
        botAccount.setAutoReconnect(true);
        botAccount.addEventListener(new LaunchToDiscord());
        botAccount.addEventListener(new ActionListener());
    }

    public static Bot getInstance(){
        return INSTANCE;
    }



    //JDA functions of the AdminBot
    @Override
    public Status getStatus() {
        return null;
    }

    @Override
    public long getPing() {
        return 0;
    }

    @Override
    public List<String> getCloudflareRays() {
        return null;
    }

    @Override
    public List<String> getWebSocketTrace() {
        return null;
    }

    @Override
    public void setEventManager(IEventManager iEventManager) {

    }

    @Override
    public void addEventListener(Object... objects) {

    }

    @Override
    public void removeEventListener(Object... objects) {

    }

    @Override
    public List<Object> getRegisteredListeners() {
        return null;
    }

    @Override
    public GuildAction createGuild(String s) {
        return null;
    }

    @Override
    public CacheView<AudioManager> getAudioManagerCache() {
        return null;
    }

    @Override
    public SnowflakeCacheView<User> getUserCache() {
        return null;
    }

    @Override
    public List<Guild> getMutualGuilds(User... users) {
        return null;
    }

    @Override
    public List<Guild> getMutualGuilds(Collection<User> collection) {
        return null;
    }

    @Override
    public RestAction<User> retrieveUserById(String s) {
        return null;
    }

    @Override
    public RestAction<User> retrieveUserById(long l) {
        return null;
    }

    @Override
    public SnowflakeCacheView<Guild> getGuildCache() {
        return null;
    }

    @Override
    public SnowflakeCacheView<Role> getRoleCache() {
        return null;
    }

    @Override
    public SnowflakeCacheView<Category> getCategoryCache() {
        return null;
    }

    @Override
    public SnowflakeCacheView<TextChannel> getTextChannelCache() {
        return null;
    }

    @Override
    public SnowflakeCacheView<VoiceChannel> getVoiceChannelCache() {
        return null;
    }

    @Override
    public SnowflakeCacheView<PrivateChannel> getPrivateChannelCache() {
        return null;
    }

    @Override
    public SnowflakeCacheView<Emote> getEmoteCache() {
        return null;
    }

    @Override
    public SelfUser getSelfUser() {
        return null;
    }

    @Override
    public Presence getPresence() {
        return null;
    }

    @Override
    public ShardInfo getShardInfo() {
        return null;
    }

    @Override
    public String getToken() {
        return null;
    }

    @Override
    public long getResponseTotal() {
        return 0;
    }

    @Override
    public int getMaxReconnectDelay() {
        return 0;
    }

    @Override
    public void setAutoReconnect(boolean b) {

    }

    @Override
    public void setRequestTimeoutRetry(boolean b) {

    }

    @Override
    public boolean isAutoReconnect() {
        return false;
    }

    @Override
    public boolean isAudioEnabled() {
        return false;
    }

    @Override
    public boolean isBulkDeleteSplittingEnabled() {
        return false;
    }

    @Override
    public void shutdown() {

    }

    @Override
    public void shutdownNow() {

    }

    @Override
    public AccountType getAccountType() {
        return null;
    }

    @Override
    public JDAClient asClient() {
        return null;
    }

    @Override
    public JDABot asBot() {
        return null;
    }
}
