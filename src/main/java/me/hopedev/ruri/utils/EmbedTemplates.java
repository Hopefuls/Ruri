package me.hopedev.ruri.utils;

import me.hopedev.ruri.Ruri;
import org.javacord.api.entity.message.embed.EmbedBuilder;

public class EmbedTemplates {

    public static EmbedBuilder defaultEb() {
        EmbedBuilder eb = new EmbedBuilder();

        eb.setFooter("Ruri by Hope", Ruri.getApi().getYourself().getAvatar());
        eb.setTimestampToNow();
        return eb;
    }
}
