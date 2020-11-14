package me.hopedev.ruri;

import me.hopedev.ruri.commanding.MainCommand;
import me.hopedev.ruri.utils.Secrets;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Ruri {

    private static DiscordApi api;

    public static void main(String[] args) {
        api = new DiscordApiBuilder().setToken(Secrets.getToken()).setAllIntents().login().join();
        System.out.println(api.createBotInvite());
        System.out.println();
        api.addMessageCreateListener(new MainCommand());

    }

    public static DiscordApi getApi() {
        return api;
    }
    private static void startup() {
        System.out.println("82 117 114 105 66 111 116");
        System.out.println("Started Successfully!");

    }



}
