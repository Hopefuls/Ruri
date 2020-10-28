package me.hopedev.ruri;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Ruri {

    private static DiscordApi api;

    public static void main(String[] args) {
        api = new DiscordApiBuilder().setToken(Secrets.getToken()).login().join();
        System.out.println();


    }

    private static void startup() {
        System.out.println("82 117 114 105 66 111 116");
        System.out.println("Started Successfully!");

    }



}
