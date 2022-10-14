from discord.ext import commands
import discord

class Help(commands.Cog):
    def __init__(self, bot):
        self.bot = bot

    @commands.slash_command(name="help", description="Receive help")
    async def help(self, interaction):
        # get all commands
        commands = ""
        print(self.bot.commands)
        for command in self.bot.commands:
            commands += f"**/{command.name}** - {command.description}\n\n"

        help_embed = discord.Embed()
        help_embed.set_thumbnail(url=self.bot.user.avatar.url)
        help_embed.color = discord.Color.blurple()
        help_embed.description = "Ruri is a bot that can do many things (not yet)."
        help_embed.add_field(name="Commands", value=commands)

        help_embed.set_footer(text=interaction.user.name, icon_url=interaction.user.avatar.url)

        await interaction.response.send_message(embed=help_embed)

        



def setup(bot):
    bot.add_cog(Help(bot))