from discord.ext import commands
import discord

class About(commands.Cog):
    def __init__(self, bot):
        self.bot = bot

    @commands.slash_command(name="about", description="About Ruri")
    async def about(self, interaction):
        """About the bot"""
        about_embed = discord.Embed()
        about_embed.set_thumbnail(url=self.bot.user.avatar.url)

        about_embed.color = discord.Color.purple()

        about_embed.title = "Ruri - The one and only"
        about_embed.description = "Ruri - Made by HopeDev with ❤️"
        about_embed.add_field(name="Language", value="Python (using pycord version 2.1.3)", inline=True)
        about_embed.add_field(name="Developer", value="Aurel", inline=False)
        about_embed.add_field(name="Ruri on GitHub", value="[/Hopefuls/Ruri](https://github.com/Hopefuls/Ruri)", inline=True)

        about_embed.set_footer(text=f"{interaction.user.name}", icon_url=interaction.user.avatar.url)

        await interaction.response.send_message(embed=about_embed)

def setup(bot):
    bot.add_cog(About(bot))