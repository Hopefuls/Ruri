package me.hopedev.ruri.utils;

import me.hopedev.ruri.Ruri;
import org.javacord.api.entity.emoji.Emoji;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.Reaction;

import java.util.concurrent.TimeUnit;

public class MessageUtils {




    public static void deleteOnReact(Emoji emoji, Message message) {
        message.addReaction(emoji);
        Ruri.getApi().addReactionAddListener(event -> {
            if (event.getUser().get().isYourself()) {
                return;
            }
            if (event.getMessageId() == message.getId()) {
                if (event.getReaction().get().getEmoji().equalsEmoji(emoji)) {
                        message.delete("Reacted with unicode "+event.getReaction().get().getEmoji().getMentionTag()+" on Thread "+Thread.currentThread().getId());
                }
            }
        }).removeAfter(5, TimeUnit.MINUTES);
    }
}
