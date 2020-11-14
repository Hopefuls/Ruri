package me.hopedev.ruri.utils.managers.helppagemechanic;

import com.vdurmont.emoji.EmojiParser;
import me.hopedev.ruri.Ruri;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.emoji.Emoji;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.util.concurrent.TimeUnit;

public class HelpPageManager {
    private Message message;
    private int currentPage;
    private final int maxPage = 2;
    private final ServerTextChannel stc;
    public HelpPageManager(Message message, ServerTextChannel stc) {
        this.stc = stc;
        this.message = message;
    }


    public static HelpPageManager createHelpMessage(ServerTextChannel stc) {

        HelpPageManager manager = new HelpPageManager(null, stc);
        manager.setCurrentPage(1).update();
        return manager;

    }


    public final HelpPageManager setCurrentPage(int page) {
        this.currentPage = page;
        return this;

    }

    public final void update() {
        EmbedBuilder builder = defaultEb();
        switch (this.currentPage) {
            case 1:
                builder.setTitle("Help | Page "+this.currentPage+" of "+this.maxPage);
                builder.setDescription("**Prefix:** ``ruri! ``\n\n"+new HelpPageData(1).getPage());
                if (this.message == null) {
                    this.message = this.stc.sendMessage(builder).join();
                    this.message.addReactions(EmojiParser.parseToUnicode(":arrow_backward:"), EmojiParser.parseToUnicode(":arrow_forward:"));
                } else {
                    this.message.edit(builder);
                }
                break;
            case 2:
                builder.setTitle("Help | Page "+this.currentPage+" of "+this.maxPage);
                builder.setDescription("Prefix: ``ruri! ``\nNo commands on this page");
                if (this.message == null) {
                    this.message = this.stc.sendMessage(builder).join();
                    this.message.addReactions(EmojiParser.parseToUnicode(":arrow_backward:"), EmojiParser.parseToUnicode(":arrow_forward:"));
                } else {
                    this.message.edit(builder);
                }
                break;

        }

        Ruri.getApi().addReactionAddListener(event -> {
            if (event.getUser().get().isYourself()) {
                return;
            }
            if (event.getMessageId() == this.message.getId()) {
                Emoji reactionEmoji = event.getEmoji();
                if (reactionEmoji.isUnicodeEmoji()) {
                    if (reactionEmoji.asUnicodeEmoji().get().equalsIgnoreCase(EmojiParser.parseToUnicode(":arrow_backward:"))) {
                        if (this.currentPage == 1) {
                            // If the current page is the minimum
                        } else {
                            this.setCurrentPage(this.currentPage-1).update();
                        }
                    } else if (reactionEmoji.asUnicodeEmoji().get().equalsIgnoreCase(EmojiParser.parseToUnicode(":arrow_forward:"))) {
                        if (this.currentPage == this.maxPage) {
                            // If the current page is the minimum
                        } else {
                            this.setCurrentPage(this.currentPage+1).update();
                        }
                    }
                    event.removeReaction();

                }
            }
        }).removeAfter(10, TimeUnit.MINUTES);
    }



    private static EmbedBuilder defaultEb() {
        EmbedBuilder eb = new EmbedBuilder();

        eb.setFooter("Ruri by Hope", Ruri.getApi().getYourself().getAvatar());
        eb.setTimestampToNow();
        return eb;
    }
}
