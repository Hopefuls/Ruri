package me.hopedev.ruri.commanding;

import me.hopedev.ruri.Ruri;
import me.hopedev.ruri.utils.EmbedTemplates;
import me.hopedev.ruri.utils.managers.helppagemechanic.HelpPageManager;
import me.hopedev.ruri.utils.objects.CommandMessage;
import org.javacord.api.Javacord;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class MainCommand implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        CommandMessage message = new CommandMessage(event);

        if (message.getCallerCMD().equalsIgnoreCase("ruri!")) {
            if (message.getArg(0).equalsIgnoreCase("help")) {
                HelpPageManager.createHelpMessage(message.getSTChannel());
                return;
            }
            if (message.getArg(0).equalsIgnoreCase("about")) {
                EmbedBuilder eb = EmbedTemplates.defaultEb();
                eb.setImage(Ruri.getApi().getYourself().getAvatar());
                eb.setDescription("Ruri - Made by HopeDev");
                eb.setTitle("Ruri - The one and only");
                eb.addInlineField("Language", "Java");
                eb.addInlineField("Library", "Javacord");
                eb.addInlineField("Library Version", Javacord.DISPLAY_VERSION);
                eb.addInlineField("Developer", "Hope#1000 ([top.gg](https://top.gg/user/669452973755072524) | [reddit](https://www.reddit.com/user/LessH0pe/) | [GitHub](https://github.com/Hopefuls))");
                eb.addField("Ruri's Source Code on Github", "[/Hopefuls/Ruri](https://github.com/Hopefuls/Ruri)");
                message.getSTChannel().sendMessage(eb);
                return;
            }
        }
    }
}
